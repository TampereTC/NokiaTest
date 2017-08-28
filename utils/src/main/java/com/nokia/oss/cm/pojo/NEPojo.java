package com.nokia.oss.cm.pojo;

/**
 * NE data  pojo that models Network element data 
 * 
 * @author msopanen
 *
 */
public class NEPojo {

	private int cellId;
	private String name;
	private String release;
	private String version;
	private String gen;
	private String country;
	private String city;
	private int operatorId;
	
	public NEPojo(String[] columns) {
		this.cellId = Integer.valueOf(columns[0]);
		this.name = columns[1];
		this.release = columns[2];
		this.version = columns[3];
		this.gen = columns[4];
		this.country = columns[5];
		this.city = columns[6];
		this.operatorId = Integer.valueOf(columns[7]);
	}
	public int getCellId() {
		return cellId;
	}
	public void setCellId(int cellId) {
		this.cellId = cellId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
}
