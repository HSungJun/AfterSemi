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

import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;

import kh.spring.config.HttpSessionConfogurator;
import kh.spring.config.SpringProvider;
import kh.spring.services.ChatService;

@ServerEndpoint(value="/chat", configurator = HttpSessionConfogurator.class)
public class ChatEndpoint {
	
	private HttpSession hSession;
	
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
	
	//램에다 공간을 만들어서 저장하는 것
//	private static EvictingQueue<ChatDTO> messages = EvictingQueue.create(100);
	
	// DB 저장 Dependency Lookup으로 ChateSrvice bean을 가져와야 함
	private ApplicationContext ctx = SpringProvider.getApplicationContext();
	// Spring 주소를 가져와 ctx에 저장.
	
	
	@OnMessage
	public void onMessage(String message) {
		String id = (String)hSession.getAttribute("loginId");
		
		ChatService service = ctx.getBean(ChatService.class);
		
		
//		램에다 저장할 시 dto를 EvictingQueue에 추가
//		ChatDTO dto = new ChatDTO(id, message, null);
//		messages.add(dto);
		
//		JsonObject json = new JsonObject();
//		json.addProperty("userId", id);
//		json.addProperty("message", message);
		
		
		synchronized (clients) {
			
			for(Session session : clients) {
				try {
					session.getBasicRemote().sendText(new Gson().toJson(dto));
				}catch(IOException e) {}
			}
		}
	}
	
	
	@OnOpen
	public void onConnect(Session session, EndpointConfig config) {
		ChatEndpoint.clients.add(session);
		this.hSession = (HttpSession)config.getUserProperties().get("hSession");
		
		try {session.getBasicRemote().sendText(new Gson().toJson(messages));}
		catch(IOException e) {}
		
//		String message = "님 어서오세요";
//		
//		JsonObject json = new JsonObject();
//		json.addProperty("userId", id);
//		json.addProperty("message", message);
		
//		try {
//			session.getBasicRemote().sendText(json.toString());
//		} catch (IOException e) {}
	}
	
	@OnClose
	public void onClost(Session session) {
		clients.remove(session);
	}
	
	@OnError
	public void onError(Throwable t,Session session) {
		clients.remove(session);
	}
	
	
}
