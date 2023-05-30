package kh.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringProvider implements ApplicationContextAware{
	
	private static ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//클래스 생성 > 인터페이스 상속 = 컴포넌트스캔 실행> 컴포넌트 스캔후 인스턴스 생성 -스프링컨테이너 자신의 주소가
		//필요한 것을 확인 > 해당 메서드가 자기 자신의 주소를 저장.
		// 톰캣에 의해 스프링컨테이너가 생성된 후 해당 주소가 필요할 경우에 위와같은 코드를 작성함.
		ctx = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	
}
