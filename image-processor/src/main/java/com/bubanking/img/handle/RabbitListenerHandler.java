package com.bubanking.img.handle;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bubanking.common.configuration.RabbitProperties;
import com.bubanking.img.IPService;


@Configuration
public class RabbitListenerHandler implements MessageListener{
	
	
	@Autowired
	private RabbitProperties rabbitProperties;
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private MessageConverter messageConverter;
	
	@Autowired
	private IPService ipService;
	
	
	@Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setConcurrentConsumers(rabbitProperties.getConsummers());
		container.setQueueNames(rabbitProperties.getQueueName());
        container.setMessageListener(this);
      
        return container;
    }

	/***
	 * handle all messages receive from this queue
	 */
	
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		ipService.handleMessage(messageConverter.fromMessage(message));
		
	}
}
