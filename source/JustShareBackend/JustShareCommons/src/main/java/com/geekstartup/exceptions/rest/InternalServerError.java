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
public class InternalServerError extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3801269364545517765L;
	
	public InternalServerError(String message) {
        super(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(message).type(MediaType.TEXT_PLAIN).build());
    }

}
