/**
 * 
 */
package com.liberary.serviceimpl;

import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liberary.Entity.User;
import com.liberary.service.UserService;

/**
 * @author malviyaa
 *
 */
@Service
public class UserServiceImpl {

	@Autowired
	UserService service;
	@Transactional
	public User insert(User user, int bookQty) throws ParseException {
		 service.updateBookQty(bookQty, user.getId());
		 if(user.getReturnDate()==null) {
			 Date d = user.getIssueDate();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currentDate = sf.format(d);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 Calendar c = Calendar.getInstance();
			 c.setTime(sdf.parse(currentDate));
			 c.add(Calendar.DATE, 7);  // number of days to add
			 currentDate = sdf.format(c.getTime());
			 Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
			 		user.setReturnDate(d1);
		 }
		 User u=service.save(user);
		 return u;
	}
	
	
	
	
}
