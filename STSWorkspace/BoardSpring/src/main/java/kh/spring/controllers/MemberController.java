package kh.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import commons.EncryptionUnits;
import kh.spring.dto.MembersDTO;
import kh.spring.services.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberService memberService;	

	@Autowired
	private HttpSession session;

	@RequestMapping("signup")
	public String signup() {

		return "member/signup";
	}

	@RequestMapping("join")
	public String join(MembersDTO dto) throws Exception {
		dto.setPw(memberService.shapw(dto.getPw()));
		int result = memberService.join(dto);
		return "redirect:/";
	}

	@ResponseBody // return으로 돌려보내는 값을 데이터 그대로 보내고, viewresolve를 거치지 않음.
	@RequestMapping(value="IdCheck",produces="text/html;charset=utf8") // 
	public String IdCheck(String id) {
		System.out.println("중복검사ID="+id);
		MembersDTO result = memberService.IdCheck(id);
		//ajax는 페이지 전환없이 소스코드를 보냄
		int resultId = 1;
		if (result == null) {
			resultId = 0;
		}
		return String.valueOf(resultId);
		//dispatcher가 return을 받음 String이 리턴될경우 viewresolver한테 보냄 > 페이지로 넘어가려함.
	}

	@RequestMapping("login")
	public String login(String id, String pw, RedirectAttributes rdat) throws Exception {
		pw = memberService.shapw(pw);
		MembersDTO result = memberService.login(id,pw);
		if (result!=null) {
			session.setAttribute("loginId", id);
			rdat.addFlashAttribute("status","LS");
		}
		return "redirect:/";

	}

	@RequestMapping("logout")
	public String logout(String id, String pw) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}

	@RequestMapping("out")
	public String out (String loginId) {
		
		int result = memberService.memberOut(loginId);
		if(result == 1) {
			session.invalidate();
		}
		return "redirect:/";
		}


	@RequestMapping("myPage")
	public String myPage(String loginId,Model model) {
		
		MembersDTO dto = memberService.memberInfo(loginId);
		model.addAttribute("dto", dto);
		
		return "/member/myPage";
	}
	
	@RequestMapping("updateMyInfo")
	public String updateMyInfo(MembersDTO dto) {
		
		int result = memberService.updateMyInfo(dto);
		
		return "redirect:/member/myPage?loginId="+dto.getId();
	}
	
	
}
