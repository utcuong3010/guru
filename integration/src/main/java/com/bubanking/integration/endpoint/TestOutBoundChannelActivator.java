package com.bubanking.integration.endpoint;

import java.util.Map;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint
public class TestOutBoundChannelActivator {
	
	
	@ServiceActivator
	public void handle(Message<Map<String,Object>>message) throws Throwable {
		System.err.println(message);
	}

}
