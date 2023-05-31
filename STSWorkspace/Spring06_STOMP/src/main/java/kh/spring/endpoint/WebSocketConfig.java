package kh.spring.endpoint;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

//스톰프에서 웹소켓 활성화 (스프링과 연결된 웹소켓)
@Configuration
@EnableWebSocketMessageBroker 
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic"); 
		// 구독할 수 있는 EndPoint URL의 prefix [server > client]
		registry.setApplicationDestinationPrefixes("/app"); 
		// 클라이언트가 메세지를 보낼 떄 사용할 URL의 prefix	[client > server]
	}
	// STOMP 는 구독 시스템
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("*");
		// 웹소켓에 접속할 수 있는 사람을 통제
		// 서버를 켜서 아이피만 해당 서버로 하고 배포할경우 데이터를 훔쳐가는 경우 발생 방지 위해 사용. 
		//new HttpSessioHanshakeInterceptor -> http session을 가져올 수 없어서 톰캣에서 세션정도 가져오는 코드 
	}
	
}
