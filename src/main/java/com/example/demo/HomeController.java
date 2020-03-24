package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HomeController {

	@Autowired
	Repo repo;
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	@CrossOrigin
	public void submitBook(@RequestBody Books books) {
		String a=books.getBook_Name();
		
		System.out.println("Test");
		System.out.println(a);
		
	}

}
