package kh.spring.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class measuringInterceptor implements HandlerInterceptor{

	@Autowired
	private HttpSession session;
		
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		long ssec = System.currentTimeMillis();
		
		long sec = (long)session.getAttribute("sec");
		long compSec = ssec-sec;
		System.out.println(request.getRequestURI()+" 요청은 "+compSec+" ms 만큼 걸렸음");
		session.removeAttribute("sec");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		long sec = System.currentTimeMillis();
		session.setAttribute("sec", sec);
		return true;
	}
	
	
}
