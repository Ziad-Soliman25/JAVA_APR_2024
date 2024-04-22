package com.heidichen.apitest.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.heidichen.apitest.models.People;
import com.heidichen.apitest.services.APIService;

@RestController
public class APIController {
	
	@Autowired
	APIService apiService;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello world";
	}

	
	@GetMapping("/api/countries")
	public List<Object> getCountries(){
		String url = "https://restcountries.com/v3.1/all";
		RestTemplate restTemplate = new RestTemplate();
		
		Object[] countries = restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(countries);
	}
	
	@GetMapping("/api/people/{id}")
	public People getPeople(@PathVariable("id")Long id) {
		String uri = "https://swapi.dev/api/people/";
		People p = apiService.getPerson(uri, id);
		
		return p;
	}
	
	
	
}
