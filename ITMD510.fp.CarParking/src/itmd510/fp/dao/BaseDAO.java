package itmd510.fp.dao;

import java.sql.ResultSet;
//import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import itmd510.fp.dao.Connection;
import itmd510.fp.model.*;
/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: BaseDAO
 * Source File Name	: BaseDAO.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Contains all the functionalities for Basic DAO  
 * 
 */
public class BaseDAO {
	/* Private Variable */
	private Statement statement;
	private java.sql.Connection connection;

	/**
	 * Prepared Statement
	 * @param query query
	 * @return query
	 * @throws SQLException SQLException
	 */
	protected java.sql.PreparedStatement PrepareStatement(String query) throws SQLException {
		return this.connection.prepareStatement(query);
	}

	/**
	 * Create Statement
	 * @throws SQLException SQLException
	 */
	protected void CreateStatement() throws SQLException {
		this.statement = this.connection.createStatement();
	}

	/**
	 * Used to Create a connection and statement
	 */
	protected void CreateConnection() {
		try {
			this.connection = Connection.getInstance().getConnection();
		} catch (SQLException e) {
			if (e.getMessage().equalsIgnoreCase("Too many connections"))
				System.out.println("Please ask the administrator to close the connection!!");
		} catch (ClassNotFoundException e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
	}

	/**
	 * closes the connection and the statement
	 */
	protected void CloseConnectionStatement() {
		try {
			this.statement.close();
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Something Went Wrong!! Please contact the administrator");
		}
	}

	/**
	 * ExecuteQuery
	 * @param query query
	 * @return ResultSet
	 * @throws SQLException SQLException
	 */
	protected ResultSet ExecuteQuery(String query) throws SQLException {
		return this.statement.executeQuery(query);
	}

	/**
	 * Map_ResultSet_To_UserProfileModel
	 * @param rs rs
	 * @return UserProfileModel
	 * @throws SQLException SQLException
	 */
	protected UserProfileModel Map_ResultSet_To_UserProfileModel(ResultSet rs) throws SQLException {
		UserProfileModel returnValue = new UserProfileModel();
		returnValue.setUserId(Integer.parseInt(rs.getString("USERID")));
		returnValue.setPassword(rs.getString("PASSWORD"));
		returnValue.setRole(rs.getString("ROLE").charAt(0));
		returnValue.setFirstName(rs.getString("FIRSTNAME"));
		returnValue.setLastName(rs.getString("LASTNAME"));
		returnValue.setUserName(rs.getString("USERNAME"));
		returnValue.setRole(rs.getString("ROLE").charAt(0));
		returnValue.setStudentId(rs.getString("STUDENTID"));
		returnValue.setEmailId(rs.getString("EMAILID"));
		AddressModel add = new AddressModel();
		add.setAddressId(rs.getInt("ADDRESSID"));
		returnValue.setAddress(add);
		return returnValue;
	}
	
	/**
	 * Map_ResultSet_To_Address
	 * @param rs rs
	 * @return AddressModel
	 * @throws SQLException SQLException
	 */
	public AddressModel Map_ResultSet_To_Address(ResultSet rs) throws SQLException{
		AddressModel returnValue = new AddressModel();
		returnValue.setAddressId(rs.getInt(1));
		returnValue.setLine1(rs.getString(2));
		returnValue.setLine2(rs.getString(3));
		returnValue.setCity(rs.getString(4));
		returnValue.setState(rs.getString(5));
		returnValue.setZip(rs.getInt(6));
		return returnValue;
	}

	/**
	 * Map_ResultSet_To_ParkingLot
	 * @param rs rs
	 * @return ParkingLot
	 * @throws SQLException SQLException
	 */
	public ParkingLot Map_ResultSet_To_ParkingLot(ResultSet rs) throws SQLException {
		ParkingLot returnValue = new ParkingLot();
		returnValue.setParkingLotId(rs.getInt(1));
		returnValue.setDescription(rs.getString(2));
		returnValue.setParkingCategoryDesc(rs.getString(3));
		returnValue.setParkingAddress(rs.getString(4));
		returnValue.setNoOfSpace(rs.getInt(5));
		return returnValue;
	}
	
	/**
	 * Map_ResultSet_To_ParkingModel
	 * @param rs rs
	 * @return ParkingModel
	 * @throws SQLException SQLException
	 */
	public ParkingModel Map_ResultSet_To_ParkingModel(ResultSet rs) throws SQLException {
		ParkingModel returnValue = new ParkingModel();
		returnValue.setParkingLotId(rs.getInt(1));
		returnValue.setDescription(rs.getString(2));
		returnValue.setCategoryDescription(rs.getString(3));
		returnValue.setNoOfSpace(rs.getInt(4));
		return returnValue;
	}

	/**
	 * Map_ResultSet_To_ParkingCategory
	 * @param rs rs
	 * @return ParkingCategoryModel
	 * @throws SQLException SQLException
	 */
	protected ParkingCategoryModel Map_ResultSet_To_ParkingCategory(ResultSet rs) throws SQLException {
		ParkingCategoryModel returnValue = new ParkingCategoryModel();
		returnValue.setDescription(rs.getString("DESCRIPTION"));
		returnValue.setParkingCategoryId(rs.getInt("PARKINGCATEGORYID"));
		return returnValue;
	}
	
	/**
	 * Map_ResultSet_To_ParkingModel_Log
	 * @param  rs rs
	 * @return ParkingModel
	 * @throws SQLException SQLException
	 */
	public ParkingModel Map_ResultSet_To_ParkingModel_Log(ResultSet rs) throws SQLException {
		ParkingModel returnValue = new ParkingModel();
		returnValue.setUserId(rs.getInt(1));
		returnValue.setUserName(rs.getString(2));
		returnValue.setDescription(rs.getString(3));
		returnValue.setFromDate(rs.getDate(4));
		returnValue.setToDate(rs.getDate(5));
		return returnValue;
	}
}
