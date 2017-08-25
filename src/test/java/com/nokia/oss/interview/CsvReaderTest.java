/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nokia.oss.interview;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author thakuli
 */
public class CsvReaderTest {
    private static final String CSV_FILE = "src/test/resources/testdata.csv";
    
    public CsvReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void readCsvFile() throws FileNotFoundException, IOException {        
        CsvReader csvr = new CsvReader(CSV_FILE);
        
        List<NetworkElement> nes = csvr.getNetworkElements();
        assertEquals(55,nes.size());        
    }
}
