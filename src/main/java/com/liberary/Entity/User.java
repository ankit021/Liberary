/**
 * 
 */
package com.liberary.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author malviyaa
 *
 */
@Entity
@Table(name="customer")
public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5614174608387210316L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long issueid;
	
	 private String isbn;
	 private String userName;
	 private Date issueDate;
	 private Date returnDate;
	 
	 
	public Long getId() {
		return issueid;
	}
	public void setId(Long issueid) {
		this.issueid = issueid;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	 
	 
}
