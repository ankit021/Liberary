package com.liberary.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liberary.Entity.Books;
import com.liberary.serviceimpl.BooksServiceImpl;

@RestController
@RequestMapping(value="/Books")
public class BookController {
		@Autowired
	 private BooksServiceImpl	 srviceImpl;
 
			//liberarian can add books
	@PostMapping("/insert")
	ResponseEntity<Object> insertBooks(@Valid @RequestBody Books newBooks) {
		return ResponseEntity.ok().body(this.srviceImpl.insertBooks(newBooks));
	}
	
	//get book by book name
	@GetMapping("/bookname")
	List<Books> getbyBookname(@RequestParam String bookName) {
		return srviceImpl.getByname(bookName); 
	}
	// get book by auther name
	@GetMapping("/authername")
	List<Books> getByAutherName(@RequestParam String autherName) {
		return srviceImpl.getByAutherName(autherName); 
	}
	
	//get list of books
	@GetMapping("/getall")
	public List<Books> getallBooks(){
		return srviceImpl.getallBooks();
	}
	
	// liberarian can update the book	
	@PutMapping("/update/id")
	public ResponseEntity<Object> updateBooks(@RequestBody Books Books) {
		return srviceImpl.update(Books);
	}
	
	// for continue and discontinue of books
	@PatchMapping("/update/status")
	public ResponseEntity<Object> updateContinueStatus(@RequestParam String isContinued,long id){
		return srviceImpl.updateContinueStatus(isContinued, id);
		
	}
	
	
	
}
	


