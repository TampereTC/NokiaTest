package com.nokia.oss.jetty.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Jetty server {@link Runnable} class that can instantiate Jetty 
 * web server.
 * 
 * @author msopanen
 */
public class ServerRunnable implements Runnable {
	
	final int port;
	final String resourceBase;
	
	public ServerRunnable(int port, String resourceBase) {
		this.port = port;
		this.resourceBase = resourceBase;
	}
	
	@Override
	public void run() {
        Server server = new Server(port);
        
        WebAppContext cntx = new WebAppContext();
        cntx.setContextPath("/");
        cntx.setResourceBase(resourceBase);
        server.setHandler(cntx);
 
        try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
