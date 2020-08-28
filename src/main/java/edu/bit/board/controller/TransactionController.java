package edu.bit.board.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.bit.board.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class TransactionController {

	private TransactionService transactionService;
	
	//restful: url�� �ش� ������ �ްڴ�
	@GetMapping("/tran/{num}")
	public void transaction(@PathVariable("num") int num) throws IOException {
		if(num==1) {
			log.info("transactionTest1 �׽�Ʈ");
			transactionService.transactionTest1();
		} else if(num==2) {
			log.info("transactionTest2 �׽�Ʈ");
			transactionService.transactionTest2();
		} else if(num==3) {
			log.info("transactionTest3 �׽�Ʈ");
			transactionService.transactionTest3();
		} else if(num==4) {
			log.info("transactionTest4 �׽�Ʈ");
			transactionService.transactionTest4();
		} else if(num==5) {
			log.info("transactionTest5 �׽�Ʈ");
			transactionService.transactionTest5();
		} else if(num==6) {
			log.info("transactionTest6 �׽�Ʈ");
			transactionService.transactionTest6();
		}
	}

}


