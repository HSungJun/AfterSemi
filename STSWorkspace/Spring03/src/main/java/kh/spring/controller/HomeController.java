package kh.spring.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.MessagesDTO;
import kh.spring.repositories.MessagesDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MessagesDAO dao;

	@RequestMapping("/")
	public String home(Locale locale, Model model) throws Exception {

		return "home";
	}
	
	@RequestMapping("/toInput")
	public String toInput() {
		
		return "inputForm";
	}
	
	@RequestMapping("/writeMsg")
	public String writeMsg(MessagesDTO dto) throws Exception {
		
		int result = dao.writeMsg(dto);
		return "redirect:/";
	}
	
	@RequestMapping("/listMsg")
	public String listMsg(Model model) throws Exception{
		
		List<MessagesDTO> list = dao.selectAll();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/deleteByseq")
	public String deleteByseq(int delseq) throws Exception{
		int result = dao.deleteMovieById(delseq);
		
		return "redirect:/listMsg";
	}
	
	@RequestMapping("/modifyMsg")
	public String modifyMovie(MessagesDTO dto)throws Exception{
		int result = dao.modifyMsgBySeq(dto);
		return "redirect:/listMsg";
	}
	
	
	
	
	
	//예외처리 argument에 Exceiption e 를 넣어 pispatcher에게 요청하여 출력
		@ExceptionHandler(Exception.class)
		public String exceptionHandler(Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}
}
