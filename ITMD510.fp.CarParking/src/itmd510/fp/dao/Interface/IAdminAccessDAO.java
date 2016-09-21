package itmd510.fp.dao.Interface;

import java.util.List;

import itmd510.fp.model.UserProfileModel;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: IAdminAccessDAO
 * Source File Name	: IAdminAccessDAO.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Contains all the functionalities for AdminAccess  
 * 
 */
public interface IAdminAccessDAO {
	/**
	 * Loads the user details
	 * @return List of UserProfile
	 */
	public List<UserProfileModel> getUserDetails();
	
	/**
	 * Updates the user details
	 * @param userId userId
	 * @param role role
	 * @return true/false
	 */
	public boolean UpdateUserDetail(int userId, String role);
}
