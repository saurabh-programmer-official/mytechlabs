package com.example.demo;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class DemoRestController {

	@GetMapping("/hello/{name}")
	public 	Hello getHello(@PathVariable String name, HttpServletResponse response) throws IOException {
		
		Hello hello = new Hello(name,"saurabh@gmail.com");
		response.sendError(920);
		return hello;
	}
}
