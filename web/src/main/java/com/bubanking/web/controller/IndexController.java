package com.bubanking.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {
	
	
	@RequestMapping("/")
	public String home() {
		return "index";
		
	}

}
