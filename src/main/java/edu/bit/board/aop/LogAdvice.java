package edu.bit.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Component
@Aspect		
public class LogAdvice {
	
	@Before("within(edu.bit.board.service.*)")//������Ű������ ����� �� printLogging()�� ���� ���κп��� ����
	//@Before("within(edu.bit.board.*)")		
	public void printLogging() {	//�긦 ���������� ����ڴ�
		System.out.println("������ - ����Ʈ �α�");
		
	}
}
