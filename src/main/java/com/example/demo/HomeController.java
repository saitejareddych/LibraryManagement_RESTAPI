package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.dialect.SybaseAnywhereDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.Iterable;
import java.util.List;
import java.util.Optional;

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
		repo.save(books);
		System.out.println("Inside Post");
	}
	@RequestMapping(value="/remove", method=RequestMethod.DELETE)
	public void removeBook(@RequestParam int book_id){
		System.out.println("inside Delete"+book_id);
		repo.deleteById(book_id);
	}
	@RequestMapping(value = "/borrow", method=RequestMethod.PUT)
	public void borrowBook(int book_id){
		Optional<Books> books=repo.findById(book_id);
		Books book=books.isPresent()?books.get():new Books();
		System.out.print(book.getBook_ID());
	}

	@RequestMapping(value = "/test", method=RequestMethod.PUT)
	public String test() throws JsonProcessingException {
		List<Books> result= (List<Books>) repo.findAll();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(result);
	}

}
