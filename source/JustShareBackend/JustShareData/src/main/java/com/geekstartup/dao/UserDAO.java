/**
 * 
 */
package com.geekstartup.dao;

import com.geekstartup.vo.User;

/**
 * @author tanmoy.banerjee
 *
 */
public interface UserDAO {
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Object createUser(User user);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public User getUserById(String userId);

}
