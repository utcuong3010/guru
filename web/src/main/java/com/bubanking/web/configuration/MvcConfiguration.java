package com.bubanking.web.configuration;

import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
public class MvcConfiguration extends SpringBootServletInitializer {

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		
//		
//		registry.addViewController("/").setViewName("index");
//		registry.addViewController("/login").setViewName("login");
//		registry.addViewController("/logout").setViewName("login");
//		
//	}
//	
//	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}
	
}
