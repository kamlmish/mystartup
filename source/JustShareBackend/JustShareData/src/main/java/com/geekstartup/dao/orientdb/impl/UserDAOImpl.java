/**
 * 
 */
package com.geekstartup.dao.orientdb.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.geekstartup.dao.UserDAO;
import com.geekstartup.dao.common.DataType;
import com.geekstartup.dao.common.OrientDBManager;
import com.geekstartup.vo.User;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

/**
 * @author tanmoy.banerjee
 *
 */
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

	/* (non-Javadoc)
	 * @see com.geekstartup.dao.UserDAO#createUser(com.geekstartup.vo.User)
	 */
	public Object createUser(User user) {
		OrientGraph graph = null;
		Object id = null;
		
		try {
			graph = OrientDBManager.getGraph();
			//TODO: 1) userID and email are mandatory 2) check for userID duplication
			
			Vertex userVertex = graph.addVertex(null);
			userVertex.setProperty("type", DataType.USER);
			userVertex.setProperty("userId", user.getUserID());
			userVertex.setProperty("firstName", user.getFirstName());
			userVertex.setProperty("lastName", user.getLastName());
			userVertex.setProperty("emailID", user.getEmailID());
			userVertex.setProperty("mobileNumber", user.getMobileNumber());
			graph.commit();
			
			id = userVertex.getId();
			System.out.println("User has been created with ID: " + id);
		} catch(Exception ex) {
			ex.printStackTrace();
			graph.rollback();
		} finally {
			OrientDBManager.close(graph);
		}
		return id;
	}

	/*
	 * (non-Javadoc)
	 * @see com.geekstartup.dao.UserDAO#getUserById(java.lang.String)
	 */
	public User getUserById(String userId) {
		User user = null;
		OrientGraph graph = null;
		if(!StringUtils.isEmpty(userId)) {
			try {
				graph = OrientDBManager.getGraph();
				String sqlQuery = "select from v where type = '" + DataType.USER + "' and userId = '" + userId + "'";
				System.out.println("sqlQuery: " + sqlQuery);
				Iterable<Vertex> userVertices = graph.command(new OCommandSQL(sqlQuery)).execute();
				if(userVertices != null) {
					for(Vertex userVertex : userVertices) {
						user = new User();
						user.setUserID(userId);
						user.setFirstName((String)userVertex.getProperty("firstName"));
						user.setLastName((String)userVertex.getProperty("lastName"));
						user.setEmailID((String)userVertex.getProperty("emailID"));
						user.setMobileNumber((String)userVertex.getProperty("mobileNumber"));
						
						break;//should have only one record, or return the first one
					}
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				OrientDBManager.close(graph);
			}
		} else {
			System.err.println("userId is null or empty !");
		}
		System.out.println("User: " + user);
		return user;
	}

}
