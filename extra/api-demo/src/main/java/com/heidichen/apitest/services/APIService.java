package com.heidichen.apitest.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.heidichen.apitest.models.People;

@Service
public class APIService {

	
	public People getPerson(String uri, Long id) {
		RestTemplate restTemplate = new RestTemplate();
		People person = restTemplate.getForObject(uri + id, People.class);		
		return person;
	}
}
