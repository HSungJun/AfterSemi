package kh.spring.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.spring.DTO.MessageDTO;
import kh.spring.repositories.MessageDAO;


@Controller
public class HomeController {
	
	@Autowired
	private MessageDAO dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	
	@RequestMapping("insertMessage")
	public String insertMessage(String name, String message) {
		int result = dao.insertMessage(name,message);
		String insertResult="실패";
		if (result == 1) {
			insertResult = "성공";
		}
		return String.valueOf(insertResult);
	}
	
	@RequestMapping("listMessage")
	public String listMessage(Model model) {
		List<MessageDTO> list = dao.listMessage();
		model.addAttribute("list",list);
		return String.valueOf(list);
	}
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/error";
	}
	
}
