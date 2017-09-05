package com.nokia.oss.cm.ne.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nokia.oss.cm.csv.CSVReader;
import com.nokia.oss.cm.pojo.NEPojo;
import java.util.logging.Logger;

/**
 * Controller that reads CSVData from given file path and return JSON
 * representation about collected data.
 * 
 * @author msopanen
 *
 */
@Controller
@RequestMapping("/cm")
public class CSVController {
        private static final Logger logger = Logger.getLogger(CSVController.class.getName());
	@Autowired
	CSVReader reader;

	/**
	 * Call example POST -> http://localhost:8080/rest/cm/ne
	 * 
	 * @param file - csv file
	 * @return Collection<NEPojo>
	 * @throws IOException
	 */
	@RequestMapping(value = "/ne", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<NEPojo> getNe(@RequestBody String file) throws IOException {
                logger.info(String.format("File %s in POST", file));
		return new ArrayList<NEPojo>();				
	}

}
