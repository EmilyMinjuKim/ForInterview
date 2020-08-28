package edu.bit.board.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	//����¡ ó���� �� �ʿ��� ������ - ���� 7���� ���!
	private int startPage;		//ȭ�鿡 �������� ������ ���۹�ȣ
	private int endPage;		//ȭ�鿡 �������� ����ȣ
	private boolean prev, next; //������ �������� �̵������� ��ũ ǥ��
	
	private int total;			//��ü �Խñ� �� 
	private Criteria cri;		
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;		//��ü ������ ��
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0))*10;
		//getPageNum: ���� ������ ��ȣ (ex. 3)
		//10.0 : �ϴ� ����¡ �ٿ� ������ ����¡�� ����
		//����: ceil(3 / 10.0) * 10 = 1 * 10 = 10
		//getPageNum�� 11�� �Ǵ� ���� endPage�� 20���� �ٲ�.
		
		this.startPage = this.endPage - 9;
		
		//Total�� ���� endPage�� ����
		//10���� �����ִ� ��� ��ü ������ ���� 80����� �����ϸ� ����ȣ�� 10�� �ƴ� 8�� ��.
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		
		//���۹�ȣ�� 1���� ū ���
		this.prev = this.startPage > 1;
		
		//realEnd�� ����ȣ(endPage)���� ū ���
		this.next = this.endPage < realEnd;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) // pageNum = 3
				.queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
				.build(); // ?pageNum=3&amount=10
		return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 ���� 
	}
	
}
