package com.liberary.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.liberary.Entity.Books;
import com.liberary.service.BooksService;

@Service
public class BooksServiceImpl {
	@Autowired
	private BooksService booksService;

	public Books insertBooks(Books Books) {
		return booksService.save(Books);
	}

	public Books getbookbyid(Long id) {
		Books stu = booksService.findById(id).get();
		if (stu == null)
			throw new EntityNotFoundException();
		return stu;
	}

	public List<Books> getallBooks() {
		return booksService.findAll();
	}

	public ResponseEntity<Object> update(Books books) {
		Optional<Books> BooksOptional = booksService.findById(books.getId());

		if (!BooksOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			booksService.save(books);
		}
		return ResponseEntity.status(200).build();
	}

	public List<Books> getByname(String bookName) {
		List<Books> bks = booksService.findByBookName(bookName);
		if (bks == null)
			throw new EntityNotFoundException();
		System.out.println(bks);
		return bks;

	}

	public List<Books> getByAutherName(String autherName) {
		List<Books> bks = booksService.findByAutherName(autherName);
		if (bks == null)
			throw new EntityNotFoundException();
		System.out.println(bks);
		return bks;

	}

	public ResponseEntity<Object> updateContinueStatus(String isContinued, long id) {
		int status = booksService.updateStatus(isContinued, id);

		if (status==0) {
			return ResponseEntity.status(500).body("failed");
		} 
		return ResponseEntity.status(200).body("status Updated ");
	}
	
	
}
