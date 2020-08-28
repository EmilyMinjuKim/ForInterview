package edu.bit.board.aop;

import javax.xml.ws.soap.Addressing;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Component
public class LogAOP {
	
	//@Around("within(edu.bit.board..*)")
	@Pointcut("execution(* edu.bit.board.*.getList())")	//����Ʈ�� ����ð� �������� ����
	public void pointcutMethod() {
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String signatureStr = joinpoint.getSignature().toShortString();
		//�����ð� �ٽɱ�� list������
		System.out.println(signatureStr +" is start.");
		
		
		long st = System.currentTimeMillis(); //���۽ð�
		
		try {
			Object obj = joinpoint.proceed(); //list ����(�ٽɱ��)
			return obj;
		}finally {
			
			long et = System.currentTimeMillis(); //������ //�����ð�
			
			System.out.println(signatureStr +" is finished.");
			System.out.println(signatureStr + " ����ð� : "+ (et-st)); //�ɸ��ð�
		}
	}

}
