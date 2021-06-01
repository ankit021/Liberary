package com.liberary.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.liberary.Entity.Books;

@Repository
public interface BooksService extends JpaRepository<Books, Long> {

	public List<Books> findByBookName(String bookName);

	public List<Books> findByAutherName(String autherName);
	
	@Modifying
	@Query("update Books b set b.isContinued = ?1 where b.id = ?2")
	public int updateStatus(String isContinued,long id);
}
