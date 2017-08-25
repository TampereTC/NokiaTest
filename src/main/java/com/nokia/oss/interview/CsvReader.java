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
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author thakuli
 */
class CsvReader {
    private String csvFile;
    CsvReader(String csvFile) {
        this.csvFile = csvFile;

    }

    List<NetworkElement> getNetworkElements() throws FileNotFoundException, IOException {
        // cellId;name;release;version;gen;country;city;operatorId
        List<NetworkElement> nes = new ArrayList<>();
        
        Reader in = new FileReader(csvFile);        
        Iterable<CSVRecord> records = CSVFormat.newFormat(';').withHeader().parse(in);
        for (CSVRecord record : records) {
            NetworkElement ne = new NetworkElement();
            ne.setCellId(Integer.parseInt(record.get("cellId")));
            ne.setName(record.get("name"));
            ne.setRelease(record.get("release"));
            ne.setVersion(record.get("version"));
            ne.setGeneration(record.get("gen"));
            ne.setCountry(record.get("country"));
            ne.setCity(record.get("city"));
            ne.setOperatorId(Integer.parseInt(record.get("operatorId")));
            
            nes.add(ne);
        }
        return nes;
    }
    
}
