package itmd510.fp.model;

import java.sql.Date;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: AddressModel
 * Source File Name	: AddressModel.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * AddressModel to store the address 
 * 
 */
public class AddressModel {

	/* Variables */
	private int addressId;
	private String line1;
	private String line2;
	private String city;
	private String State;
	private int zip;
	private char status;
	private Date createdDate;
	private Date updatedDate;
	
	/**
	 * Gets the address id
	 * @return int
	 */
	public int getAddressId() {
		return addressId;
	}
	
	/**
	 * Sets the address id
	 * @param addressId addressId
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * Gets the Line1 
	 * @return String
	 */
	public String getLine1() {
		return line1;
	}
	
	/**
	 * Sets the Line1
	 * @param line1 line1
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	
	/**
	 * Gets the line 2
	 * @return String
	 */
	public String getLine2() {
		return line2;
	}
	
	/**
	 * Sets the line2
	 * @param line2 line2
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	
	/**
	 * Gets the city
	 * @return String
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city
	 * @param city city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the state
	 * @return String
	 */
	public String getState() {
		return State;
	}
	
	/**
	 * Sets the state
	 * @param state state
	 */
	public void setState(String state) {
		State = state;
	}
	
	/**
	 * Gets the ziop
	 * @return int
	 */
	public int getZip() {
		return zip;
	}
	
	/**
	 * Sets the zip
	 * @param zip zip
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	/**
	 * Gets the status
	 * @return char
	 */
	public char getStatus() {
		return status;
	}
	
	/**
	 * Sets the status
	 * @param status status
	 */
	public void setStatus(char status) {
		this.status = status;
	}
	
	/**
	 * Gets the CreatedDate
	 * @return Date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	
	/**
	 * Sets the CreatedDate
	 * @param createdDate CreatedDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
	 * Gets the UpdatedDate
	 * @return Date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	/**
	 * Sets the UpdatedDate
	 * @param updatedDate UpdatedDate
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	    
}
