package itmd510.fp.dao;
import java.sql.*;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: Connection
 * Source File Name	: Connection.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Contains all the functionalities for Connection  
 * 
 */
public class Connection {

	//Private variables for username, password etc
	private static Connection instance = null;
	private static final String PASSWORD = "510";
	private static final String USERNAME = "fpuser";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://www.papademas.net:3306/dbfp";

	/**
	 * private constructor used for singleton pattern
	 */
	private Connection() {
	}

	/**
	 * get the single instance of the Connection Object
	 * @return Connection Object
	 */
	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}

	/**
	 * Used to create a JDBC connection
	 * @return returns the Connection Created
	 * @throws Exception Throws SQLException and other exceptions
	 */
	public java.sql.Connection getConnection() throws Exception {
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
