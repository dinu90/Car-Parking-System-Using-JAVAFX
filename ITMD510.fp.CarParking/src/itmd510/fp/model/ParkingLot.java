package itmd510.fp.model;

import java.sql.Date;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: ParkingLot
 * Source File Name	: ParkingLot.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * ParkingLot to store the ParkingLot 
 * 
 */
public class ParkingLot {
	
	/* Private variables */
	private int parkingLotId;
	private String parkingCategoryDesc;
	private String parkingAddress;
	private String description;
	private int parkingCategoryId;
	private int addressId; 
	private int noOfSpace=0;
	private String status;
	private Date createdDate; 
	private Date updatedDate;
	
	/**
	 * Getes the Parking Lot id
	 * @return int
	 */
	public int getParkingLotId() {
		return parkingLotId;
	}
	
	/**
	 * Sets the parking lot id
	 * @param parkingLotId parkingLotId
	 */
	public void setParkingLotId(int parkingLotId) {
		this.parkingLotId = parkingLotId;
	}
	
	/**
	 * gets the parking category description
	 * @return String
	 */
	public String getParkingCategoryDesc() {
		return parkingCategoryDesc;
	}
	
	/**
	 * Sets the parking category desc
	 * @param parkingCategoryDesc parkingCategoryDesc
	 */
	public void setParkingCategoryDesc(String parkingCategoryDesc) {
		this.parkingCategoryDesc = parkingCategoryDesc;
	}
	
	/**
	 * gets the parking address
	 * @return String
	 */
	public String getParkingAddress() {
		return parkingAddress;
	}
	
	/**
	 * setParkingAddress
	 * @param parkingAddress parkingAddress
	 */
	public void setParkingAddress(String parkingAddress) {
		this.parkingAddress = parkingAddress;
	}
	
	/**
	 * gets the description
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description
	 * @param description description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * get ParkingCategoryId
	 * @return int
	 */
	public int getParkingCategoryId() {
		return parkingCategoryId;
	}
	
	/**
	 * sets the parking category id
	 * @param parkingCategoryId parkingCategoryId
	 */
	public void setParkingCategoryId(int parkingCategoryId) {
		this.parkingCategoryId = parkingCategoryId;
	}
	
	/**
	 * gets the address id
	 * @return int
	 */
	public int getAddressId() {
		return addressId;
	}
	
	/**
	 * sets the address id 
	 * @param addressId addressId
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * gets the number of space
	 * @return int
	 */
	public int getNoOfSpace() {
		return noOfSpace;
	}
	
	/**
	 * sets the no of space
	 * @param noOfSpace noOfSpace
	 */
	public void setNoOfSpace(int noOfSpace) {
		this.noOfSpace = noOfSpace;
	}
	
	/**
	 * gets the status
	 * @return String
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * set the status
	 * @param status status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * gets the created date
	 * @return Date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	
	/**
	 * sets the created date
	 * @param createdDate createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	/**
	 * gets updated date
	 * @return Date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	/**
	 * sets the updated date
	 * @param updatedDate updatedDate
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}
