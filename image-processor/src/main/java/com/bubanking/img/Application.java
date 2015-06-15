package com.bubanking.img;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bubanking.common.configuration.RabbitConfiguration;


@SpringBootApplication
@ComponentScan({
	"com.bubanking.common",
	"com.bubanking.img"
})
@EnableMongoRepositories(basePackages={"com.bubanking.common.repository"})
@PropertySource("classpath:application.properties")
@Import(RabbitConfiguration.class)
public class Application {
	
	public static void main(String[] args) throws InterruptedException {
	
		SpringApplication.run(Application.class, args);
	}

}
