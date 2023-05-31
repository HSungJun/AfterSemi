package kh.spring.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;


public class LoginValidator implements HandlerInterceptor{

	@Autowired
	private HttpSession session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String id = (String)session.getAttribute("loginId");
		if(id != null) return true; // 로직검사를 통과하여 처리에 문제없음을 의미하여 진행시키는 true

		response.sendRedirect("/error"); // 로직검사에 문제가있을 경우 error로 redirect 보냄
		return false;
	}


}

