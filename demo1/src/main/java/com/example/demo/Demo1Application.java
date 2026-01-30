package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		System.out.println("Start");

		SpringApplication.run(Demo1Application.class, args);
		RestTemplate restTemp = new RestTemplate();
		String url = "http://localhost:1234/hello/savio";
		Hello hello = restTemp.getForObject(url, Hello.class);
		System.out.println(hello);
		ResponseEntity<Hello> responseEntity = restTemp.getForEntity(url, Hello.class);
		int scode= responseEntity.getStatusCode().value();
		if(scode == 200) {
			System.out.println("Success");
			HttpHeaders httpHeaders = responseEntity.getHeaders();
			String content = httpHeaders.getContentType().toString();
			System.out.println("Content Type: "+ content);
			hello = responseEntity.getBody();
		}else
			System.out.println("Failure");
		System.out.println("Error Code: "+scode);


	}

}
