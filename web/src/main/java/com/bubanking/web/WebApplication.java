package com.bubanking.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@ComponentScan({
	"com.bubanking.web",
	"com.bubanking.common.configuration",
	"com.bubanking.common.repository"	
})
@EnableMongoRepositories(basePackages={"com.bubanking.common.repository"})
@PropertySource("classpath:application.properties")
public class WebApplication {
	
	private static Logger logger = Logger.getLogger(WebApplication.class);
	
	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {

			public void contextInitialized(ServletContextEvent sce) {
				logger.info("ServletContext initialized");
			}

			
			public void contextDestroyed(ServletContextEvent sce) {
				logger.info("ServletContext destroyed");
			}

		};
	}

		
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		
	}

}
