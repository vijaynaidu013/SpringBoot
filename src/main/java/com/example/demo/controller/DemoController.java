package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/")

public class DemoController {
@GetMapping(path="/hello")
	public String hello()
	{
		return "Hello Java";
	}
	
}
