package kh.spring.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.MoviesDTO;
import kh.spring.repositories.MoviesDAO;

@Controller
public class HomeController {

	@Autowired
	private MoviesDAO dao;

	@RequestMapping("/")
	public String home(Locale locale, Model model) throws Exception {

		return "home";
	}

	@RequestMapping("/toInput")
	public String toInput() {  // 리턴자료형이 void 일 경우 자동으로 요청된 String 을 forward > 해당 리퀘스트의 경우 
		// toInput.jsp로 보냄
		return "inputForm"; //리턴값이 단순한 String 일 경우 forward (앞에 prefix, 뒤에 suffix를 붙여 전송)
	}

	@RequestMapping("/inputProc")
	public String inputProc(/*HttpServletRequest request/ String title, String genre*/ MoviesDTO dto) throws Exception {
		//		String title = request.getParameter("title");
		//		String genre = request.getParameter("genre");
		//리퀘스트로 받지 않고 매개변수로 받을경우 name값을 변수명으로 지정해주어야 받아올 수 있음.
		//DTO를 입력하면 알아서 들어감.

		//DTO가 여러개이며 동일한 매개변수명을 가질 경우 받아온 매개변수의 데이터를 여러 DTO에 뿌려줌

		System.out.println(dto.getTitle()+":"+dto.getGenre());
			int result = dao.insert(dto);
			return "redirect:/";
		}
	

	@RequestMapping("/toOutput")
	public String outputProc(Model model)throws Exception  {
			List<MoviesDTO> list = dao.selectAll();
			model.addAttribute("list",list);
			return "list";
		}
	
	
	@RequestMapping("/deleteById")
	public String deleteMovieById(int delid)throws Exception  {
			int result = dao.deleteMovieById(delid);
			return "redirect:/toOutput";
		}
	
	@RequestMapping("/modifyMovie")
	public String modifyMovie(MoviesDTO dto)throws Exception{
		int result = dao.modifyMovieById(dto);
		return "redirect:/toOutput";
	}
	
	@RequestMapping("/selectById")
	public String selectById(int id) {
		MoviesDTO dto = dao.selectById(id);
		System.out.println(dto.getId() + " : " + dto.getTitle()+ " : " + dto.getGenre());
		return "redirect:/";
	}
	
	@RequestMapping("/selectCount")
	public String selectCount() {
		int result = dao.selectCount();
		System.out.println(result);
		return "redirect:/";
	}
	
	
	
	
	
	
	//예외처리 argument에 Exceiption e 를 넣어 pispatcher에게 요청하여 출력
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/error";
	}
}
