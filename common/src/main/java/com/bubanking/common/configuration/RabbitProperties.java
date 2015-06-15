package com.bubanking.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="spring.rabbitmq")
public class RabbitProperties extends org.springframework.boot.autoconfigure.amqp.RabbitProperties {
	
	
	
	private String exchangeName;
	
	/**
	 * this is the name queue
	 */
	private String queueName;
	
	/***
	 * how many consummers
	 */
	private int consummers;
	

	
	public int getConsummers() {
		return consummers;
	}
	
	public void setConsummers(int consummers) {
		this.consummers = consummers;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	
	
	
}
