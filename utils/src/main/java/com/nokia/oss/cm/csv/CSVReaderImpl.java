package com.nokia.oss.cm.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		try (Stream<String> stream = getStringStream(path)) {
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

	private Stream<String> getStringStream(String path) throws IOException {
		BufferedReader buffer = getBufferedReader(getClasspathResourceStream(path));
		return buffer.lines();
	}

	private BufferedReader getBufferedReader(final InputStream stream) {
		return new BufferedReader(new InputStreamReader(stream));
	}

	private InputStream getClasspathResourceStream(String path) throws IOException {
		return new ClassPathResource(path).getInputStream();
	}
	
}
