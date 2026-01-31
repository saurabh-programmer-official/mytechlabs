package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Test1 {


	public static void main(String args[]) {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:1234/hello1";
		ResponseEntity<Hello> respEntity = restTemplate.getForEntity(url, Hello.class);
		System.out.println(respEntity.getBody());
		HttpHeaders httpHeaders = respEntity.getHeaders();
		System.out.println(httpHeaders);
		System.out.println(httpHeaders.get("Trainer-Name"));
		
	}
}
