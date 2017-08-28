package com.nokia.oss.cm.csv;

import java.io.IOException;
import java.util.Collection;

import com.nokia.oss.cm.pojo.NEPojo;

public interface CSVReader {

	Collection<NEPojo> read(String path) throws IOException;

}