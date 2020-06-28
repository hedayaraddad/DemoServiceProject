package com.webservices.demo.webservice.rest.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping("/hello-World")
	public String helloWorld() {
			return "Hello World";
	}
	
	
	@RequestMapping("/hello-World-Bean")
	public HelloWorldBean helloWorldBean() {
			return new HelloWorldBean("Hello World");
	}
	
	@RequestMapping("/hello-World/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name ) {
			return new HelloWorldBean(String.format("Hello World %s", name));
	}

}
