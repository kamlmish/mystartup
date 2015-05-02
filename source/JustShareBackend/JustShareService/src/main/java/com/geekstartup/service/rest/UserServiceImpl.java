/**
 *
 */
package com.geekstartup.service.rest;

import com.geekstartup.dao.UserDAO;
import com.geekstartup.dao.orientdb.impl.UserDAOImpl;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.geekstartup.service.UserService;
import com.geekstartup.vo.User;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 * @author tanmoy.banerjee
 *
 */
@Path("user")
@Produces("application/json")
public class UserServiceImpl implements UserService {

    /*
     * (non-Javadoc)
     * @see com.geekstartup.service.UserService#createUser(com.geekstartup.vo.User)
     * 
     * for test, put post body as {"user": {"userID": "tbanerjee", "firstName": "tanmoy", "lastName": "banerjee", "emailID": "tanmoybanerjee2003@gmail.com", "mobileNumber": "9986661280"} }
     * test URL: http://localhost:8080/JustShareService/api/user/add
     */
    @POST
    @Path("add")
    public Response createUser(User user) throws WebApplicationException {
        System.out.println("createUser called...");
        UserDAO userDAO = new UserDAOImpl();
        user.setLoginTime(new Date());
        userDAO.createUser(user);
        return Response.status(Response.Status.OK)
                .entity(user.toString()).build();
    }

    /*
     * (non-Javadoc)
     * @see com.geekstartup.service.UserService#getUserByID(java.lang.String)
     * 
     * test URL: http://localhost:8080/JustShareService/api/user/userid/tbanerjee
     */
    @GET
    @Path("userid/{userId : [a-zA-Z_0-9]+}")
    public Response getUserByID(@PathParam("userId") String userID) throws WebApplicationException {
        System.out.println("getUserByID called...");
        return Response.status(Response.Status.OK)
                .entity("{\"status\": \"getUserByID is called, username : " + userID + "\"}").build();
    }

    @GET
    @Path("addUser")
    public Response createUser(@Context HttpServletRequest request) {

        User user = new User();
        user.setUserID(request.getParameter("userID"));
        user.setIpAdderss(request.getRemoteAddr());
        user.setLoginTime(new Date());
        user.setUserEmail(request.getParameter("userEmail"));
        user.setPassword(request.getParameter("password"));
        return Response.status(Response.Status.OK).entity(user.toString()).build();
    }

}
