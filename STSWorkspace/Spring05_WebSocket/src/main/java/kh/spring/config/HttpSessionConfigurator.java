package kh.spring.config;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class HttpSessionConfigurator extends Configurator{
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		//hadshake = 프로토콜 수정작업을 말함
		HttpSession session = (HttpSession)request.getHttpSession();
		//Web Socket 연결 과정에 포함될 HttpSession을 얻어옴
		
		sec.getUserProperties().put("hSession", session); 
		//WebSocket으로 전달되는 데이터 맵 안에 HttpSession을 첨부
	}
}
