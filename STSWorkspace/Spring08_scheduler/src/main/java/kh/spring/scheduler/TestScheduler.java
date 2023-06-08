package kh.spring.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {
	
	
	@Scheduled(fixedRate=5000)
	public void test() {
		System.out.println("스케줄러 동작 확인");
		//실행되면 5초마다 해당 메서드 실행
		
	}
	
}
