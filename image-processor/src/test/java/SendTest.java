import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.bubanking.common.configuration.RabbitConfiguration;






@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.bubanking.common"})
@PropertySource("classpath:application.properties")
@Import(RabbitConfiguration.class)
public class SendTest {
	
	
	public static void main(String[] args) {
		
		ApplicationContext  ctx = SpringApplication.run(SendTest.class, args);
		
		RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
		
		 
		
		template.convertAndSend("image.processor.queue","this is a test");
		
		template.convertAndSend("this is a test");
		template.convertAndSend("this is a test");
		template.convertAndSend("this is a test");
		template.convertAndSend("this is a test");
		
		template.convertAndSend("this is a test");
		template.convertAndSend("this is a test");
		template.convertAndSend("this is a test");
		template.convertAndSend("this is a test");
		template.convertAndSend("this is a test");
		template.convertAndSend("this is a test");
		template.convertAndSend("this is a test");
		
		template.convertAndSend("this is a test");
		
		
		
	}

}
