package edu.bit.board.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TransactionService {

	private BoardMapper boardMapper;
	
	public void transactionTest1() {
		log.info("transactionTest1()�׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	public void transactionTest2() {
		log.info("transactionTest2()�׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");
		
		boardVO = null;
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	@Transactional
	public void transactionTest3() {
		log.info("transactionTest3()�׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.insertBoard(boardVO);
		
		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");
		
		boardVO = null;
		
		boardMapper.insertBoard(boardVO);
		
	}
	
	@Transactional
	public void transactionTest4() {
		log.info("transactionTest4()�׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.insertBoard(boardVO);
		
		//�ǵ������� ���� �߻���Ű��.
		throw new RuntimeException("RuntimeException for rollback");
	}
	
	@Transactional
	public void transactionTest5() throws IOException {
		log.info("transactionTest5()�׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.insertBoard(boardVO);
		
		//�ǵ������� ���� �߻���Ű��.
		throw new IOException("IOException for rollback");
	}
	
	//IOException �ѹ� ����
	@Transactional(rollbackFor = Exception.class)
	public void transactionTest6() throws IOException {
		log.info("transactionTest6()�׽�Ʈ");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		boardMapper.insertBoard(boardVO);
		
		//�ǵ������� ���� �߻���Ű��.
		throw new IOException("IOException for rollback");
	}
	
}
