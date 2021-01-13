package com.nitin.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//i have to tell spring boot to use controller
@RestController
public class HelloWorldController {
	
    @Autowired
	private MessageSource messageSource;
	//GET
	//URI="/hello-world"
	//method=HelloWorld
	@GetMapping(path="/hello-world")
	public String HelloWorld() {
		return "Hello-World";
	}
	
	//creating a BEAN 
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello-World");
	}
	//creating a BEAN 
    @GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorlPathVariable(@PathVariable String name) 
    {
		return new HelloWorldBean(String.format("Hello-World, %s",name));
	}	
    
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
}
