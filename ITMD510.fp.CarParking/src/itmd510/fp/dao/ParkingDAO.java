package itmd510.fp.dao;

import java.sql.*;
import java.util.*;
import itmd510.fp.common.*;
import itmd510.fp.dao.Interface.*;
import itmd510.fp.model.*;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: ParkingDAO
 * Source File Name	: ParkingDAO.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Contains all the functionalities for Parking  
 * 
 */
public class ParkingDAO extends BaseDAO implements IParkingDAO{

	/**
	 * GetMaxParkingId
	 * @return int
	 */
	public int GetMaxParkingId() {
		try {
			CreateConnection();
			CreateStatement();
			ResultSet rs = ExecuteQuery(Constants.MAX_PARKING_CATEGORY_ID);
			while (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return -1;
	}

	/**
	 * AddCategory
	 * @param Category Category
	 * @return int
	 */
	public int AddCategory(ParkingCategoryModel Category){
		try {
			CreateConnection();
			PreparedStatement insertCategory = PrepareStatement(Constants.INSERT_PARKING_CATEGORY);
			insertCategory.setString(1, Category.getDescription());
			int result = insertCategory.executeUpdate();
			if (result > 0)
				return GetMaxParkingId();

		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return -1;
	}

	/**
	 * GetParkingCategory
	 * @return List of ParkingCategoryModel
	 */
	public List<ParkingCategoryModel> GetParkingCategory() {
		
		List<ParkingCategoryModel> category = new ArrayList<ParkingCategoryModel>();
		
		
		try {
			CreateConnection();
			PreparedStatement getAllCategory = PrepareStatement(Constants.GET_PARKING_CATEGORY);
			ResultSet rs = getAllCategory.executeQuery();
			while (rs.next())
				category.add(Map_ResultSet_To_ParkingCategory(rs));
			
			
			
		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return category;
	}
	
	/**
	 * GetCategoryId
	 * @param category category
	 * @return int
	 */
	public int GetCategoryId(String category){
		try {
			CreateConnection();
			PreparedStatement getCategory = PrepareStatement(Constants.GET_CATEGORY_ID);
			getCategory.setString(1, category);
			ResultSet result = getCategory.executeQuery();
			while (result.next())
				return result.getInt(1);

		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return -1;
	}
	
	/**
	 * AddParking
	 * @param parking parking
	 * @return int
	 */
	public int AddParking(ParkingLot parking){
		try {
			CreateConnection();
			PreparedStatement insertParkingLot = PrepareStatement(Constants.INSERT_PARKING_LOT);
			//(DESCRIPTION,PARKINGCATEGORYID,ADDRESSID,NOOFSPACE,STATUS,CREATEDDATE,UPDATEDDATE)
			insertParkingLot.setString(1, parking.getDescription());
			insertParkingLot.setInt(2, parking.getParkingCategoryId());
			insertParkingLot.setInt(3, parking.getAddressId());
			insertParkingLot.setInt(4, parking.getNoOfSpace());
			insertParkingLot.setString(5, parking.getStatus());
			insertParkingLot.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
			insertParkingLot.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
			int result = insertParkingLot.executeUpdate();
			if (result > 0)
				return result;

		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return -1;
	}
		
	/**
	 * GetParkingLot
	 * @return List of ParkingLot
	 */
	public List<ParkingLot> GetParkingLot(){
		List<ParkingLot> parkingLot = new ArrayList<ParkingLot>();
		try {
			CreateConnection();
			PreparedStatement getAllparkingLot = PrepareStatement(Constants.GET_PARKING_LOT);
			ResultSet rs = getAllparkingLot.executeQuery();
			while (rs.next())
				parkingLot.add(Map_ResultSet_To_ParkingLot(rs));
		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return parkingLot;
	}
	
	/**
	 * UpdateParkingLot
	 * @param parkingLot parkingLot
	 * @return boolean
	 */
	public boolean UpdateParkingLot(ParkingLot parkingLot){
		try {
			CreateConnection();
			PreparedStatement updateParkingLot = PrepareStatement(Constants.UPDATE_PARKING_LOT);
			updateParkingLot.setInt(1, parkingLot.getNoOfSpace());
			updateParkingLot.setInt(2, parkingLot.getParkingLotId());
			int result = updateParkingLot.executeUpdate();
			return (result > 0) ? true : false;

		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return false;
	}
	
	/**
	 * DeleteParkingLot
	 * @param parkingLot parkingLot
	 * @return boolean
	 */
	public boolean DeleteParkingLot(ParkingLot parkingLot){
		try {
			CreateConnection();
			PreparedStatement deleteParkingLot = PrepareStatement(Constants.DELETE_PARKING_LOT);
			deleteParkingLot.setInt(1, parkingLot.getParkingLotId());
			int result = deleteParkingLot.executeUpdate();
			return (result > 0) ? true : false;

		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return false;
	}
		
	/**
	 * GetParkingSpaceDetail
	 * @return List of ParkingModel
	 */
	public List<ParkingModel> GetParkingSpaceDetail(){
		List<ParkingModel> parkingLot = new ArrayList<ParkingModel>();
		try {
			CreateConnection();
			PreparedStatement getAllparkingLot = PrepareStatement(Constants.GET_PARKING_SPACE_Detail);
			ResultSet rs = getAllparkingLot.executeQuery();
			while (rs.next())
				parkingLot.add(Map_ResultSet_To_ParkingModel(rs));
		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return parkingLot;
		
	}
	
	/**
	 * GetParkingLog
	 * @return List of ParkingModel 
	 */
	public List<ParkingModel> GetParkingLog() {
		List<ParkingModel> parkingModel = new ArrayList<ParkingModel>();
		try {
			CreateConnection();
			PreparedStatement getAllCategory = PrepareStatement(Constants.GETPARKINGLOG);
			ResultSet rs = getAllCategory.executeQuery();
			while (rs.next())
				parkingModel.add(Map_ResultSet_To_ParkingModel_Log(rs));
		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return parkingModel;
	}

	/**
	 * AddParkingBooking
	 * @param parking parking
	 * @return int
	 */
	public int AddParkingBooking(ParkingModel parking){
		try {
			CreateConnection();
			PreparedStatement insertParkingLot = PrepareStatement(Constants.INSERT_PARKING_LOG);
			//PARKINGLOTID,USERID,FROMDATE,TODATE
			insertParkingLot.setInt(1, parking.getParkingLotId());
			insertParkingLot.setInt(2, parking.getUserId());
			insertParkingLot.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
			insertParkingLot.setDate(4, new java.sql.Date(parking.getToDate().getTime()));
			insertParkingLot.setInt(5, parking.getPrice());
			int result = insertParkingLot.executeUpdate();
			if (result > 0)
				return result;

		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
		return -1;
	}
		
}
