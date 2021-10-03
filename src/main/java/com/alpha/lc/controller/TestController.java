package com.alpha.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	//@ResponseBody//when return view page then no need thsi response body
	@RequestMapping("/test")
	public String sayHello()
	{
		System.out.println("sayHello method calling.......");
		return "test";
		
	}
	
}
