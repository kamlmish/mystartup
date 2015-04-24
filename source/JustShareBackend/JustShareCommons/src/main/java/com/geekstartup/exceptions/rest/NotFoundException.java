/**
 * 
 */
package com.geekstartup.exceptions.rest;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author tanmoy.banerjee
 *
 */
public class NotFoundException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3801038573471053069L;
	
	public NotFoundException(String message) {
        super(Response.status(Response.Status.NOT_FOUND)
            .entity(message).type(MediaType.TEXT_PLAIN).build());
    }

}
