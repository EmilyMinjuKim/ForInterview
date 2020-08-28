package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.RecVO;
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
public class RestBoardSpring4BeforeController {

	 private BoardService service;
	   
	   @ResponseBody
	   @RequestMapping("/restful/before")
	   public List<BoardVO> before() {
	      log.info("/restful/before");
	      List<BoardVO> list = service.getList();
	      
	      return list;
	   }
	   
	   @RequestMapping("/restful/recArea")
	   public String recArea() {
		   log.info("recArea");
		   
		   return "areaAjax";
	   }
	   
	   @ResponseBody
	   @RequestMapping("/restful/recAjax")
	   public int recAjax(RecVO rec) {
		   log.info("recAjax");
		   
		   return rec.getArea();
	   }
}


