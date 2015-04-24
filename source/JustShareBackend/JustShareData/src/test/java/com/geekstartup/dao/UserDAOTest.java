/**
 * 
 */
package com.geekstartup.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geekstartup.dao.UserDAO;
import com.geekstartup.vo.User;

/**
 * @author tanmoy.banerjee
 *
 */
public class UserDAOTest {
	private static ApplicationContext context;
	private UserDAO userDAO;
	private User user;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("Spring-data-context.xml");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//nothing
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userDAO = (UserDAO)context.getBean("UserDAO");
		user = new User();
		user.setUserID("tbanerjee");
		user.setFirstName("Tanmoy");
		user.setLastName("Banerjee");
		user.setEmailID("tanmoybanerjee2003@gmail.com");
		user.setMobileNumber("9986661280");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		userDAO = null;
		user = null;
	}

	@Test
	public void testUserCreation() {
		Object id = userDAO.createUser(user);
		assertNotNull("User not created", id);
	}
	
	@Test
	public void testGetUserById() {
		String userId = "tbanerjee";
		User userFetched = userDAO.getUserById(userId);
		assertNotNull("User not fetched", userFetched);
		assertNotNull("User data is not correct", userFetched.getEmailID());
	}
	
	@Test
	public void testGetUserByNullId() {
		User userFetched = userDAO.getUserById(null);
		assertNull("User should not be fetched", userFetched);
	}

}
