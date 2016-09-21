package itmd510.fp.common;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: Constants
 * Source File Name	: Constants.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Contains all the constants 
 * 
 */
public class Constants {
	public final static String String_Empty = "";
	public final static String CSS_URL = "itmd510/fp/application.css";
	public final static String USER_REGISTRATION_URL = "/itmd510/fp/view/UserRegistration.fxml";
	public final static String ADMINHOME_URL = "/itmd510/fp/view/AdminHome.fxml";
	public final static String CUSTHOME_URL = "/itmd510/fp/view/CustomerHome.fxml";
	public final static String LOGIN_URL = "/itmd510/fp/view/Login.fxml";
	public final static String ADMIN_ACCESS_URL = "/itmd510/fp/view/AdminAccess.fxml";
	public final static String PARKING_LOT_DETAILS_URL = "/itmd510/fp/view/ParkingLotDetails.fxml";
	public final static String BOOK_PARKING = "/itmd510/fp/view/BookParking.fxml";
	public final static String ViewLog = "/itmd510/fp/view/ViewBooking.fxml";

	public final static String ADMINHOME = "ADMIN";
	public final static String CUSTOMEMR = "CUSTOMER";
	public final static String LOGIN = "LOGIN";
	public final static String USERREGISTRATION = "USERREGISTRATION";
	public final static String LOGOUT = "LOGOUT";
	public final static String ADMINACCESS = "ADMINACCESS";
	public final static String PARKINGLOTDETAILS = "PARKINGLOTDETAILS";

	public final static String errUserName = "User Name can't be empty";
	public final static String errUserNameNotAvailable = "User Name not available";
	public final static String errUserNameNotFound = "User Name not found";
	public final static String errIncorrectPassword = "Incorrect Password!!!";
	public final static String errFirstName = "First Name can't be empty";
	public final static String errLastName = "Last Name can't be empty";
	public final static String errAddressLine1 = "Address Line 1 can't be empty";
	public final static String errCity = "City can't be empty";
	public final static String errState = "State can't be empty";
	public final static String errZipCode = "Zip code can't be empty";
	public final static String errZipCode_Should_Be_Number = "Zip code should be number";
	public final static String errPassword = "Password can't be empty";
	public final static String errPassword_MisMatch = "Password didn't match";
	public final static String errPassword_Min_Length = "Character, number, !,@,#,$,% are only allowed";
	public final static String passwordStrength_Bad = "Password Strength : Bad";
	public final static String passwordStrength_Fair = "Password Strength : Fair";
	public final static String passwordStrength_Good = "Password Strength : Good";
	public final static String passwordStrength_Strong = "Password Strength : Strong";
	public final static String errEmailAddress = "Email can't be empty";
	public final static String errEmailAddress_Invalid = "Email address is invalid";
	public final static String errCategoryEmpty = "Category can't be empty";
	public final static String onlyNumberAllowed = "Only Number Allowed";
	public final static String errCategory_NoSpecial = "No Special Character allowed";
	public final static String descriptionEmpty = "Description can't be empty";
	public final static String noOfSpaceEmpty = "No of Space can't be empty";
	public final static String zip_regex = "^\\d{5}$";
	public final static String ParkingSpace_regex = "^\\d+$";
	public final static String Parking_regex = "^([a-z]+|[A-z]+|[0-9]+)+ *([a-z]*[A-z]*[0-9]*)*$";
	public final static String password_regex = "^(?=[^\\d_].*?\\d)\\w(\\w|[!@#$%]){7,14}$";
	public final static String email_regex = "^([a-z][A-Z][0-9]){5,20}@([a-z][A-Z][0-9]){4,10}\\.[a-z]{3,4}$";

	public final static String INSERT_ADDRESS = "INSERT INTO dbfp.D_GANE_ADDRESS"
			+ "(LINE1,LINE2,CITY,STATE,ZIP,STATUS,CREATEDDATE,UPDATEDDATE)" + "VALUES(?,?,?,?,?,?,?,?)";
	public final static String UPDATE_ADDRESS = "UPDATE dbfp.d_gane_address SET LINE1=?, LINE2=?, CITY=?, STATE=?, ZIP=?, UPDATEDDATE=? where ADDRESSID=?";

	public final static String INSERT_USER = "INSERT INTO dbfp.D_GANE_USERPROFILE"
			+ "(FIRSTNAME,LASTNAME,ADDRESSID,USERNAME,PASSWORD,ROLE, STUDENTID,EMAILID,AUTHORIZED,CREATEDDATE,UPDATEDDATE)"
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	public final static String GET_PARKING_SPACE_Detail = "select dbfp.d_gane_parkinglot.PARKINGLOTID,dbfp.d_gane_parkinglot.DESCRIPTION,dbfp.d_gane_parkingcategory.DESCRIPTION,dbfp.d_gane_parkinglot.NOOFSPACE from dbfp.d_gane_parkinglot join dbfp.d_gane_parkingcategory on dbfp.d_gane_parkinglot.PARKINGCATEGORYID=dbfp.d_gane_parkingcategory.PARKINGCATEGORYID";

	public final static String GETPARKINGLOG ="SELECT  dbfp.d_gane_parkinglot_log.USERID,(select username from dbfp.d_gane_userprofile where USERID = dbfp.d_gane_parkinglot_log.USERID),(select description from dbfp.d_gane_parkinglot  where parkinglotid=dbfp.d_gane_parkinglot_log.parkingLotid),dbfp.d_gane_parkinglot_log.FROMDATE,dbfp.d_gane_parkinglot_log.TODATE from dbfp.d_gane_parkinglot_log";
	
	public final static String UPDATE_USER_WITHOUT_PASSWORD = "UPDATE dbfp.d_gane_userprofile SET FIRSTNAME=?, LASTNAME=?, STUDENTID=?, EMAILID=?,UPDATEDDATE=? WHERE USERID=?";
	public final static String UPDATE_USER_WITH_PASSWORD = "UPDATE dbfp.d_gane_userprofile SET FIRSTNAME=?, LASTNAME=?, PASSWORD=?, STUDENTID=?, EMAILID=?,UPDATEDDATE=? WHERE USERID=?";

	public final static String INSERT_PARKING_CATEGORY = "INSERT INTO dbfp.D_GANE_PARKINGCATEGORY"
			+ "(DESCRIPTION) VALUES(?)";

	public final static String INSERT_PARKING_LOG = "INSERT INTO dbfp.d_gane_parkinglot_log(PARKINGLOTID,USERID,FROMDATE,TODATE,"
			+ "PRICE) VALUE(?,?,?,?,?)";
	public final static String INSERT_PARKING_LOT = "INSERT INTO dbfp.D_GANE_PARKINGLOT"
			+ "(DESCRIPTION,PARKINGCATEGORYID,ADDRESSID,NOOFSPACE,STATUS,CREATEDDATE,UPDATEDDATE) "
			+ "VALUES(?,?,?,?,?,?,?)";
	public final static String GET_CATEGORY_ID = "SELECT * FROM dbfp.D_GANE_PARKINGCATEGORY WHERE DESCRIPTION= ?";
	public final static String GET_PARKING_LOT = "SELECT PARKINGLOTID, dbfp.D_GANE_PARKINGLOT.DESCRIPTION , dbfp.D_GANE_PARKINGCATEGORY.DESCRIPTION AS CATEGORY,"
			+ "CONCAT(dbfp.D_GANE_ADDRESS.LINE1,', ',dbfp.D_GANE_ADDRESS.CITY) AS ADDRESS,dbfp.D_GANE_PARKINGLOT.NOOFSPACE FROM dbfp.D_GANE_PARKINGLOT "
			+ "INNER JOIN dbfp.D_GANE_PARKINGCATEGORY INNER JOIN dbfp.D_GANE_ADDRESS "
			+ "ON  dbfp.D_GANE_PARKINGLOT.PARKINGCATEGORYID=dbfp.D_GANE_PARKINGCATEGORY.PARKINGCATEGORYID "
			+ "AND dbfp.D_GANE_PARKINGLOT.ADDRESSID=dbfp.D_GANE_ADDRESS.ADDRESSID";

	public final static String MAX_ADDRESS_ID = "SELECT MAX(ADDRESSID) FROM dbfp.D_GANE_ADDRESS";
	public final static String USERNAME_LIST = "SELECT USERNAME FROM dbfp.D_GANE_USERPROFILE";
	public final static String GET_USER_DETAIL = "SELECT * FROM dbfp.D_GANE_USERPROFILE WHERE USERNAME=?";
	public final static String GET_USER_ADDRESS = "SELECT * FROM dbfp.d_gane_address where ADDRESSID=?";
	public final static String GET_ALL_USER = "SELECT * FROM dbfp.D_GANE_USERPROFILE";
	public final static String UPDATE_USER_ROLE = "UPDATE dbfp.D_GANE_USERPROFILE SET ROLE=? WHERE USERID=?";
	public final static String MAX_PARKING_CATEGORY_ID = "SELECT MAX(PARKINGCATEGORYID) FROM dbfp.D_GANE_PARKINGCATEGORY";
	public final static String GET_PARKING_CATEGORY = "SELECT * FROM dbfp.D_GANE_PARKINGCATEGORY";
	public final static String UPDATE_PARKING_LOT = "UPDATE dbfp.D_GANE_PARKINGLOT SET NOOFSPACE=? WHERE PARKINGLOTID=?";
	public final static String DELETE_PARKING_LOT = "DELETE FROM dbfp.D_GANE_PARKINGLOT WHERE PARKINGLOTID=?";
}
