package kh.spring.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	@SubscribeMapping("/topic/test")
	public String onopen() {
		
		return "hello";
	}
	
	
	@SendTo("/topic/test") //구독한 채널명을 입력하면 해당 채널을 구독한 모든 사람들에게 return값이 전송됨.
	@MessageMapping("/message") // 클라이언트는 /app/client로 보냈으나 /app은 목적지 prefix정보라 사라짐 
	public String message(String message,SimpMessageHeaderAccessor smha) { // 프론트에서 string으로 변경하여 보내 name값이랑 전부 들어오게됨.
		
		String loginId = (String)smha.getSessionAttributes().get("loginId");
		
				System.out.println(loginId+ ":" +message);// SMHA에 세션 정보를 담아서 보내줌.
		
		return message;
	}
	
}
