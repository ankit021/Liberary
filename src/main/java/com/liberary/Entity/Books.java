package com.liberary.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Books", uniqueConstraints = {
	       @UniqueConstraint(columnNames = {"isbn"}) })
public class Books implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		 private Long id;
		
		 private String isbn;
		
		 private String bookName;
		 
		 private String autherName;
		 
	     private int bookQty;
	     @Column(columnDefinition = "varchar(1) default 'Y' ")
		private String isContinued;
		
		
	     @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ")
	     private Date createdDate;
		 
		 
		
		public Date getCreatedDate() {
			return createdDate;
		}
		
		public String getIsContinued() {
			return isContinued;
		}
		public void setIsContinued(String isContinued) {
			this.isContinued = isContinued;
		}
		public int getBookQty() {
			return bookQty;
		}
		public void setBookQty(int bookQty) {
			this.bookQty = bookQty;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getAutherName() {
			return autherName;
		}
		public void setAutherName(String autherName) {
			this.autherName = autherName;
		}
		
	
		
}
