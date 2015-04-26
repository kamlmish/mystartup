/**
 * 
 */
package com.geekstartup.service.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author tanmoy.banerjee
 *
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rootResources = new HashSet<Class<?>>();
		rootResources.add(UserServiceImpl.class);
		return rootResources;
	}

}
