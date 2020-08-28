package edu.bit.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.BoardService;
import edu.bit.board.service.LoginService;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class LoginController {

	private LoginService loginService;
	
	@GetMapping("/")
	public String home() {
		log.info("home");
		return "login"; //login.jsp�� ������.
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		log.info("post login");
		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		UserVO login =  loginService.loginUser(id, pw);
		
		if(login == null) {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("user", login);//user�� ���� ������ ���ǿ� ���� �Ѵ�
		}
		
		return "redirect:/";
	}//�������� �α��� ���� ���
	
	//�α׾ƿ�
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		log.info("/member/logout");
		
			session.invalidate();//GC�� user session�� ������.������ �ϴ� ������� GC���� �˷��ִ� ����
		
		return "redirect:/";
	}
	
	
}


