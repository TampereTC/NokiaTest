package com.nokia.oss.cm.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.core.io.ClassPathResource;

import org.springframework.stereotype.Component;

import com.nokia.oss.cm.pojo.NEPojo;

/**
 * CSVReader that reads defined CSV format and returns {@link NEPojo} object list
 * 
 * @author msopanen
 *
 */
@Component
public class CSVReaderImpl implements CSVReader {

	private final static String DELIMITER = ";";

	/* (non-Javadoc)
	 * @see com.nokia.oss.cm.csv.CSVReader#read(java.lang.String)
	 */
	@Override
	public Collection<NEPojo> read(String path) throws IOException {

	InputStream stream = new ClassPathResource(path).getInputStream();

		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(stream))) {
		String collect = buffer.lines().collect(Collectors.joining("\n"));
		List<String> lst = Arrays.asList(collect.split("\n"));
	return createNEPojoList(lst);
	}
	}



	public Collection<NEPojo> read2(String path) throws IOException {

	InputStream stream = new ClassPathResource(path).getInputStream();

		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(stream))) {
		return null;
		}
	}


        public Collection<NEPojo> read3(String path) throws IOException {

		try (Stream<String> stream = getFileStream(path)) {
			return createNEPojoList(collectCsvFileStream(stream));
		}
	}

	private List<String> collectCsvFileStream(Stream<String> stream) {
		return stream.collect(Collectors.toList());
	}

	private Collection<NEPojo> createNEPojoList(List<String> csvLines) {
		List<NEPojo> nePojos = new ArrayList<>();
		for (String line : getCSVLinesWithoutHeader(csvLines)) {
			nePojos.add(createNEPojo(line));
		}
		return nePojos;
	}
	
	// Nice potential error if this method is not used 
	private List<String> getCSVLinesWithoutHeader(List<String> csvLines) {
		return csvLines.subList(1, csvLines.size());
	}

	private NEPojo createNEPojo(String line) {
		return new NEPojo(getColumns(line));
	}

	private String[] getColumns(String line) {
		return line.split(DELIMITER);
	}

	private Stream<String> getFileStream(String path) throws IOException {
		return Files.lines(Paths.get(path));
	}

}
