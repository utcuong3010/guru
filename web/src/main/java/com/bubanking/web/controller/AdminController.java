package com.bubanking.web.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bubanking.common.cmd.IProcessingCmd;
import com.bubanking.common.configuration.RabbitProperties;
import com.bubanking.common.domain.IPTransaction;
import com.bubanking.common.domain.User;
import com.bubanking.common.repository.IPTransactionRepository;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private IPTransactionRepository ipTransactionRepository;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private RabbitProperties rabbitProperties;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		
		
		User user = new User();
		user.setLastName("admin");
		
		
		
		//create new transaction
		IPTransaction ipTransaction = IPTransaction.create("cuong", "/temp", user);
		ipTransaction = ipTransactionRepository.save(ipTransaction);

		
		IProcessingCmd cmd = new IProcessingCmd();
		cmd.setTxId(ipTransaction.getId());
		cmd.setQueryName("cuong");
		cmd.setUser(user);
		cmd.setSource("/tmp");
		
		
		rabbitTemplate.convertAndSend(rabbitProperties.getExchangeName(),rabbitProperties.getQueueName(), cmd);
		
		
		return "hello word";
	}
	
}
