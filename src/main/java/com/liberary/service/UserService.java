/**
 * 
 */
package com.liberary.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.liberary.Entity.User;

/**
 * @author malviyaa
 *
 */
@Repository
public interface UserService extends JpaRepository<User, Long> {

	@Modifying
	@Query("update Books b set b.bookQty = ?1 where b.id = ?2")
	public int updateBookQty(int bookQty,long id);
	
}
