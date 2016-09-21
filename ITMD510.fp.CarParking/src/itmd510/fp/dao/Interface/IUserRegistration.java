package itmd510.fp.dao.Interface;

import itmd510.fp.model.AddressModel;
import itmd510.fp.model.UserProfileModel;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: UserRegistrationDAO
 * Source File Name	: UserRegistrationDAO.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Contains all the functionalities for User Registration  
 * 
 */
public interface IUserRegistration {

	/**
	 * GetMaxAddressId
	 * @return int
	 */
	public int GetMaxAddressId();
	
	/**
	 * Add Address
	 * @param address address
	 * @return int
	 */
	public int AddAddress(AddressModel address);
	
	/**
	 * Update Address
	 * @param address address
	 * @return int
	 */
	public int UpdateAddress(AddressModel address);
	
	/**
	 * Add User Profile
	 * @param userProfile userProfile
	 * @return int
	 */
	public int AddUserProfile(UserProfileModel userProfile);
	
	/**
	 * Update User Profile
	 * @param userProfile userProfile
	 * @return int
	 */
	public int UpdateUserProfile(UserProfileModel userProfile);
}
