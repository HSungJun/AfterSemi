package kh.spring.endpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import kh.spring.config.HttpSessionConfigurator;

// /chat은 web socket 통신으로 http 통신이 아님으로 주소창에 /chat을 써도 의미가 없음.
// 자바스크립트를 통한 웹소켓 접속 
@ServerEndpoint(value="/chat", configurator=HttpSessionConfigurator.class)
public class ChatEndpoint {
	
	private HttpSession hSession;
	//Http세션에서 가져오는 세션값을 멤버필드로 설정

	//	private static List<Session> clients = new ArrayList<>();
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());

	// List와 차이점 = Set 입력 순서를 유지하지 않음. 중복을 허용하지 않음.

	@OnOpen // 최초로 연결 되었을 경우 컴포넌트 어노테이션이 아니어서 인스턴스로 생성되지 않는다.
	//톰캣에 의해 만들어져 스프링 관할이 아님. 클라이언트가 요청시 endpoint 인스턴스가 하나씩 만들어진다.
	// web socket이 연결한 사람당 하나씩 생성이 되며 session이라는 것이 생성됨 > http의 세션과는 별개
	public void onConnect(Session session, EndpointConfig config) {
		System.out.println("웹소켓 연결 확인");
		ChatEndpoint.clients.add(session);
		this.hSession = (HttpSession)config.getUserProperties().get("hSession");
		
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("웹소켓 연결 해제");
		clients.remove(session);
	}

	@OnError
	public void onError(Throwable t,Session session) {
		System.out.println("웹소켓 연결 실패");
		clients.remove(session);
	}

	@OnMessage
	public void onMessage(String message)  {
		System.out.println(message);
		//동시성 오류 이슈를 해결하기 위해서 > List를 변경해주어야 함

		String id = (String)hSession.getAttribute("loginId");
		
		synchronized (clients) {

			for(Session session : clients) {
				try {
					session.getBasicRemote().sendText(id+" : "+message);
				} catch (IOException e) {/*에러의 원인은 소켓통신이 막힌것 뿐이라 표시할이유 없음.*/}

			}

		}
	}

}
