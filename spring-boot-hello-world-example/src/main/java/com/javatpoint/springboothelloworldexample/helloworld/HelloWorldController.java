package com.javatpoint.springboothelloworldexample.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class HelloWorldController   
{  
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/helloworld")  
	public String helloWorld()   
	{  
		return "Hello Zeinab, welcome to javaTpoint";  
	}  
	
	@GetMapping(path="/helloworld-bean")  
	public HelloWorldBean helloWorldBean()   
	{  
		return new HelloWorldBean("hello world");  
	}
	
	@GetMapping(path="/helloworld/path-variable/{name}")  
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)   
	{  
		return new HelloWorldBean(String.format("hello world, %s", name));  
	}
	
	@GetMapping(path="/hello-world-internationalized")  
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale)   
	{  
		return messageSource.getMessage("good.morning.message", null, locale);  
	}
}  
