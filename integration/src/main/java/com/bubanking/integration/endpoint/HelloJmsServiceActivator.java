package com.bubanking.integration.endpoint;



import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@MessageEndpoint
public class HelloJmsServiceActivator {
	
	private final Logger logger = LoggerFactory.getLogger(HelloJmsServiceActivator.class);
	
	
	@ServiceActivator
	public Message<Map<String, Object>> handle(Message<String>inboundMsg) throws Throwable{
		
		Map<String, Object> msg = new HashMap<String, Object>();
//		logger.debug("firstName:{}, lastName:{} , id: {}", msg.get("firstName"), msg.get("lastName"), msg.get("id"));
		logger.info("messgae:" + inboundMsg.getPayload());
		msg.put("1", "aloo");
		
		return MessageBuilder.withPayload(msg).build();
		
		
	}


}
