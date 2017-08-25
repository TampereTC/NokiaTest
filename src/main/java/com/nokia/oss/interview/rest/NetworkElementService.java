/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nokia.oss.interview.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author thakuli
 */
@Path("/hello")
class NetworkElementService {

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "koe koe" + "</title>"
        + "<body><h1>" + "I'm alive!" + "</body></h1>" + "</html> ";
  }    
}
