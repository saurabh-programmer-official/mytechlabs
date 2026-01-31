package com.example.demo;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class DemoRestController {

	@GetMapping("/hello/{name}")
	public 	Hello getHello(@PathVariable String name, HttpServletResponse response) throws IOException {
		
		Hello hello = new Hello(name,"saurabh@gmail.com");
		response.sendError(920);
		return hello;
	}
	
	@GetMapping("/hello1")
	public ResponseEntity getHello(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
		Enumeration<String> enms = request.getHeaderNames();
		List<String> headers = Collections.list(enms);
		
		for(String header:headers) {
			System.out.println("Headers: " + request.getHeader(header));
		}
		Hello responseBody = new Hello("saurabh","saurabh@gmail.com");
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		httpHeader.add("Trainer-Name", "Srinivas Dande");
		httpHeader.set("course-name", "Java full stack");
		httpHeader.add("Student-Name", "Radhika");
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity httpEntity = new HttpEntity<>(httpHeader);
		ResponseEntity<Hello> respEntity = new ResponseEntity<Hello>(responseBody , httpHeader, HttpStatus.OK);
		return respEntity;

	}
}

