package com.sample.controllers;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

@Controller
public class WelcomeController {

	private static Logger log = (Logger) LoggerFactory.getLogger(WelcomeController.class);
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		log.info("Inside Welcome controller");
		log.info(this.message);
		return "welcome";
	}
	
	@RequestMapping("/welcomeerror")
	public String errors(Map<String, Object> model) throws Exception {
		log.info("Inside Errors controller");
		throw new Exception("test exception");
	}
	
}