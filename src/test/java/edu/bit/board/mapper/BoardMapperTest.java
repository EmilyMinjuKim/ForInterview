package edu.bit.board.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	
	/*
	 * ���� 3���� ���
	 * 1.������  2.setter 3.�ʵ忡 ���̷�Ʈ
	 * 
	 * 3����
	 * @Autowired
	 * private BoardMapper boardMapper �̷��� ����
	 * 
	 * �ظ��ϸ� �����ڳ� setter �Լ��� �ִ´�.
	 */
	
	
	@Setter(onMethod_ = @Autowired)//lombok ---> board mapper�� ���� setter�Լ��� �����
	private BoardMapper boardMapper;//�긦 �׽�Ʈ �ϱ� ���ؼ��� ���� �����ؾ��ϳ�... dao �׽�Ʈ --> Ŀ�ؼ� Ǯ ~> db����
	//setBoardMapper BoardMapper boardMapper �̷��� ����� ��
	
	@Test
	public void testBoardMapper() {
		log.info(boardMapper);
	}
	
	
	@Test public void testBoardMapperList() {//�Լ��� �׽�Ʈ�� �ؾ��� getList()
		List<BoardVO> list = boardMapper.getList();
	  
	    for(BoardVO boardVO : list) { 
	    	log.info(boardVO.getbContent());
	    	log.info(boardVO.getbId());
	    	} 
	    }
	 
}
