package kh.spring.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("/guest")
	public String guest() {
		return "guest";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member";
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
}