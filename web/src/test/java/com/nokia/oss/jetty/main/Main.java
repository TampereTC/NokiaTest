/*
 * Copyright (C) 2015 Nokia Solutions and Networks. All rights reserved.
 */
package com.nokia.oss.jetty.main;


/**
 * Simple Jetty based web server implementation that allows starting of the multiple 
 * web servers on different ports for testing of widgets. 
 *  
 * @author msopanen
 *
 */
public class Main {

	final static Thread[] THs = new Thread[] {
		new Thread(new ServerRunnable(8080, "src/main/webapp")),
		new Thread(new ServerRunnable(8081, "src/main/webapp-2"))
	};
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		for(int i=0; i<THs.length; i++) {
			THs[i].start();
		}
		
		for(int i=0; i<THs.length; i++) {
			THs[i].join();
		}		
	}

}
