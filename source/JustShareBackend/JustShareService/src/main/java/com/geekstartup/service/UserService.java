/**
 * 
 */
package com.geekstartup.service;

import javax.ws.rs.WebApplicationException;

import com.geekstartup.vo.User;

/**
 * RESTFul Service to manage users
 * 
 * @author tanmoy.banerjee
 *
 */
public interface UserService {
	/**
	 * Create a new user
	 * 
	 * @param user
	 */
	public void createUser(User user) throws WebApplicationException;
	
	/**
	 * Get a user by ID
	 * 
	 * @param userID
	 * @return User if found, else HTTP 404
	 */
	public User getUserByID(String userID) throws WebApplicationException;
}
