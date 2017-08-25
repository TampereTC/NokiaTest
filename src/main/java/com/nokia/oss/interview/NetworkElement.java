/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nokia.oss.interview;

/**
 *
 * @author thakuli
 */
class NetworkElement {
    // cellId;name;release;version;gen;country;city;operatorId
    // 1;amuri1;RL17A;12-111-11-12-11;4G;Finland;Tampere;1
    private int cellId;
    private String name;
    private String release;
    private String generation;
    private String country;
    private String city;
    private int operatorId;
    private String version;

    /**
     * @return the cellId
     */
    public int getCellId() {
        return cellId;
    }

    /**
     * @param cellId the cellId to set
     */
    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the release
     */
    public String getRelease() {
        return release;
    }

    /**
     * @param release the release to set
     */
    public void setRelease(String release) {
        this.release = release;
    }

    /**
     * @return the generation
     */
    public String getGeneration() {
        return generation;
    }

    /**
     * @param generation the generation to set
     */
    public void setGeneration(String generation) {
        this.generation = generation;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the operatorId
     */
    public int getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId the operatorId to set
     */
    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    void setVersion(String version) {
        this.version = version;        
    }

    String getVersion() {
        return this.version;
    }    
    
}
