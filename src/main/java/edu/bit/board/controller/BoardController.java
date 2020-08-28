package edu.bit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageDTO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor//controller���� �����ڸ� ����� ���, �Ķ���ͷ� service�� �ҷ��� list�� ������ ȣ���� ���� �ִ�.
/*
 * �������� ������ ���� ���� ��쿡�� Controller ��ü�� ������ �� ����. ��, �������迡 ���� ������ �ܺη� �����Ŵ���ν� ������ Ÿ�ӿ� ������ ��Ƴ� �� �ִ�.
 * @ ������̼��� ��ĵ�ϰ� �� ��ҵ��� IoC container�� �ִ´�.
 */
//�̰� ��������� private BoardService service;���⿡ ���� ��ƾ� �ϴ°����� �˼� ���� �ǹ����� �����ڰ� �־�� �Ѵ�.
public class BoardController {

	/*
	 * spring5 �����ڰ� ������ �ڵ����� �־���
	 * �����ڰ� ������ BoardService�� �ڵ����� �־���
	 */
	private BoardService service;//���񽺿��� business logic�� �� �����ڸ� ����� �ִϱ�
	
	/*
	 * @Inject
	 * public BoardController(BoardService service){ 
	 * 		this.service = service; 
	 * }
	 */
	
	 @GetMapping("/list3")
	 public void list2(Criteria cri, Model model) {	
		 log.info("list3");
		 log.info(cri);
		 model.addAttribute("list", service.getList(cri));	
		 
		 int total = service.getTotal(cri);
		 log.info("total" + total);
		 
		 model.addAttribute("pageMaker", new PageDTO(cri,total));	
	 }
	
	@GetMapping("/list")//�������� @RequestMapping �̿��� ����� ���� get����̴ϱ�
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view");
		
		model.addAttribute("content_view", service.get(boardVO.getbId()));
		
		return "content_view";
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete");
		
		service.remove(boardVO.getbId());
		
		return "redirect:list";
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO) throws Exception {
		log.info("write()");
		
		service.writeBoard(boardVO);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view()");
		
		model.addAttribute("reply_view", service.get(boardVO.getbId()));
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO) throws Exception {
		log.info("reply()");
		
		service.writeReply(boardVO);
		
		return "redirect:list";
	}
	
	//ajax ���
	@RequestMapping("/ajaxList")//���⿡ �츮�� ���� ��ΰ� �پ�
	public String ajaxList() {
		log.info("ajaxList()");
		
		return "ajaxList";
	}

}


