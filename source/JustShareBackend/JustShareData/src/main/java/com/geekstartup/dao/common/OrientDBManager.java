/**
 * 
 */
package com.geekstartup.dao.common;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;

/**
 * @author tanmoy.banerjee
 *
 */
public class OrientDBManager {
	private static OrientGraphFactory factory;
	static {
		//change pool size later
		factory = new OrientGraphFactory("remote:localhost/justShareGraphDB").setupPool(1,10);
	}
	
	/**
	 * 
	 * @return
	 */
	public static OrientGraph getGraph() {
		return factory.getTx();
	}
	
	/**
	 * 
	 * @param graph
	 */
	public static void close(OrientGraph graph) {
		if(graph != null) {
			graph.shutdown();
		}
	}

}
