package kh.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {

		return "home";
	}
	
	@RequestMapping("/toInput")
	public String toInput() {
		
		return "inputForm";
	}
	
	@RequestMapping("/inputProc")
	public String inputProc(HttpServletRequest request) {
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		
		System.out.println(title+":"+genre);
		
		return "redirect:/";
	}
	
}
