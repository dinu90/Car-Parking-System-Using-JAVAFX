package itmd510.fp.model;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: ParkingCategoryModel
 * Source File Name	: ParkingCategoryModel.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * ParkingCategoryModel to store the parking category 
 * 
 */
public class ParkingCategoryModel {
	
	/* Private variables */
	
	private int parkingCategoryId;
	private String description;
	
	/**
	 * Gets the parking category
	 * @return int
	 */
	public int getParkingCategoryId() {
		return parkingCategoryId;
	}
	
	/**
	 * Sets the parkingCategoryId
	 * @param parkingCategoryId parkingCategoryId
	 */
	public void setParkingCategoryId(int parkingCategoryId) {
		this.parkingCategoryId = parkingCategoryId;
	}
	
	/**
	 * Gets the description
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
	
}
