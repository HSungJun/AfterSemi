package kh.spring.contrillers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		// 제어의 역전을 통한 유지보수의 장점 취함
		
//		TV tv = TvFactory.getTv(args[0]); 6
//		tv.powerOn();
//		tv.powerOff();
//		삼성 > LG 변경 귀찮음 > interface 사용 > factory 추가로 메인 시작시 바로 적용
 		
//		xml > TV 인스턴스를 만들겠다고 선언해 놓았음. Spring 인스턴스를 만들어야함.
//		Spring > 스프링 인스턴스란 알아서 여러 기능을 수행해놓는 인스턴스
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("context.xml");
		//윗줄이 스프링 컨테이너 인스턴스를 만든거임 > context.xml에 삼성 인스턴스를 만들도록 해놔서
		// 스프링 컨테이너 인스턴스 내부에 자동으로 삼성 인스턴스까지 만들어짐
		
//		ctx.getBean("tv");
		//() 내부에 id 값을 입력해줄경우 수행
		// 캐스팅을 해주어야 함
		TV tv = (TV)ctx.getBean("tv");
		tv.powerOn();
		
//		DL : Dependency Lookup > getBean 으로 특정 데이터를 찾아달라는 요청
//		DI : Dependency Injection > 
		
		
	}
}
