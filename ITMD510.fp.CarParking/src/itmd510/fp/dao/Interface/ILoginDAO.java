package itmd510.fp.dao.Interface;

import java.util.List;

import itmd510.fp.model.UserProfileModel;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: ILoginDAO
 * Source File Name	: ILoginDAO.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Contains all the functionalities for Login  
 * 
 */
public interface ILoginDAO {
	
	/**
	 * Gets the user list
	 * @return list of string
	 */
	public List<String> getUserNameList();
	
	/**
	 * getUserDetails deteails
	 * @param userName userName
	 * @return UserProfileModel
	 */
	public UserProfileModel getUserDetails(String userName);
}
