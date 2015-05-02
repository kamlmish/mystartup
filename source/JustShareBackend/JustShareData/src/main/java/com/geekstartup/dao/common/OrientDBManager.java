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
    private static OrientDBManager dBManager;

    private OrientDBManager() {
        factory = new OrientGraphFactory("remote:localhost/dbdb").setupPool(1, 10);
    }

    public static OrientDBManager dBManagerInstance() {
        synchronized (OrientDBManager.class) {
            if (dBManager == null) {
                dBManager = new OrientDBManager();
            }
        }
        return dBManager;
    }

//	static {
//		//change pool size later
//		factory = new OrientGraphFactory("remote:localhost/justShareGrap").setupPool(1,10);
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
	public OrientGraph getGraph() {
		return factory.getTx();
	}
//	
//	/**
//	 * 
//	 * @param graph
//	 */
	public void close(OrientGraph graph) {
		if(graph != null) {
			graph.shutdown();
		}
	}
}
