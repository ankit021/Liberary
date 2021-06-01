/**
 * 
 */
package com.liberary.controller;

import java.text.ParseException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liberary.Entity.Books;
import com.liberary.Entity.User;
import com.liberary.service.BooksService;
import com.liberary.serviceimpl.UserServiceImpl;

/**
 * @author malviyaa
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	 private BooksService	 bookService;
	
	@Autowired 
	private UserServiceImpl userService;
	
	//issueing book to customers
	@PostMapping("/insert")
	ResponseEntity<Object> insertBooks(@Valid @RequestBody User user) throws ParseException {
		Optional<Books> b = bookService.findById(user.getId());
		//check for book stock
			if(b.get().getBookQty()==0) {
				return ResponseEntity.ok("Out of Stock ");
			}
		// check for continutions of issuing book
			if(b.get().getIsContinued().equalsIgnoreCase("N")) {
				return ResponseEntity.ok("Not for issueing ");

			}
		int qty=b.get().getBookQty()-1;
	return ResponseEntity.ok().body(userService.insert(user,qty));
	} 
	
}
