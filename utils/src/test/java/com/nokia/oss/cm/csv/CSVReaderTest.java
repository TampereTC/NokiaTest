package com.nokia.oss.cm.csv;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.nokia.oss.cm.pojo.NEPojo;

public class CSVReaderTest {

	private CSVReader reader;
	
	@Before
	public void setUp() throws Exception {
		this.reader = new CSVReaderImpl();
	}

	@Test(expected=FileNotFoundException.class)
	public void testFileNotFound_AndExpectNoSuchFileException() throws IOException {
		reader.read("foo");
	}
		
	@Test
	public void testReadCSVToNEPojosList_AndExpectCorrectAmountOfPojos() throws IOException {
		Collection<NEPojo> pojos = reader.read("test_data.csv");
		assertEquals(55,pojos.size());
	}
	
	

}
