package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> getList();//�ڼ��� ����
	
	BoardVO read(int bno);
	void upHit(int bno);
	
	@Delete("Delete from mvc_board where bId = #{bno}")//direct�� interface ���� @�ְ� ������ �Է���
	int delete(int bno);
	void insertBoard(BoardVO boardVO);
	//�̷��Ը� �ᵵ ������ ���� mapper.xml���� ���� �̸��� VO�� ���� �����
	//���������� �� �������� getter�Լ��� ȣ���ϱ� ������ BoardVO boardVO �̷��Ը� �ᵵ �˾Ƽ� ã���ش�.
	
	void updateShape(@Param("boardVO")BoardVO boardVO);
	//������ �Ķ���� �ϳ����� @Param �ǹ� ����
	//��ü�� 2�� �̻� ���� �� ���� ����(board2 ����...)�׷� �� ȿ�����̾�.
	
	void insertReply(BoardVO boardVO);
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
}
