package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@RestController//spring v4.0 ���� ���� Controller +@ResponseBody
@AllArgsConstructor//controller���� �����ڸ� ����� ���, �Ķ���ͷ� service�� �ҷ��� list�� ������ ȣ���� ���� �ִ�.
/*
 * �������� ������ ���� ���� ��쿡�� Controller ��ü�� ������ �� ����. ��, �������迡 ���� ������ �ܺη� �����Ŵ���ν� ������ Ÿ�ӿ� ������ ��Ƴ� �� �ִ�.
 * @ ������̼��� ��ĵ�ϰ� �� ��ҵ��� IoC container�� �ִ´�.
 */
//�̰� ��������� private BoardService service;���⿡ ���� ��ƾ� �ϴ°����� �˼� ���� �ǹ����� �����ڰ� �־�� �Ѵ�.
public class RestBoardSpring4AfterController {

	 private BoardService service;
	 
	   //@CrossOrigin
	   //@ResponseBody
	   @RequestMapping("/restful/after")
	   public List<BoardVO> before() {
	      log.info("/restful/after");
	      List<BoardVO> list = service.getList();
	      
	      return list;
	   }
	   
		@RequestMapping(value = "/rest/delete/{bId}", method = RequestMethod.DELETE)
		 public int restDelete(@PathVariable("bId") int bId){
			log.info("restDelete");
		 
		 return service.remove(bId);//content_view���� result�� �޴´�.
		}
		 
}


