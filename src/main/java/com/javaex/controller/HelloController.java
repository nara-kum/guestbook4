package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	// 필드

	// 생성자

	// 메소드-gs

	// 메소드 일반

	@RequestMapping(value="/hello", method= {RequestMethod.GET, RequestMethod.POST})
	public String select() {

		System.out.println("hello");

		return "hello";
	}
	
}