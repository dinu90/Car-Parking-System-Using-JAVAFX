package itmd510.fp.model;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: UserProfileModel
 * Source File Name	: UserProfileModel.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * UserProfileModel to store the User Profile 
 * 
 */
public class UserProfileModel {
	
	/* Private variables */
	private int userId;
	private String firstName;
	private String lastName;
	private AddressModel address;
	private String userName;
	private String password;
	private char role;
	private String studentId;
	private String emailId;
	private char authorized;
	
	/**
	 * Default Constructors
	 */
	public UserProfileModel(){
	
	}
	
	/**
	 * gets the user id
	 * @return int
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * sets the user ids
	 * @param userId userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * gets the first name
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * sets the first name
	 * @param firstName  firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * gets the last name
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * sets the last name
	 * @param lastName lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * gets Address model
	 * @return AddressModel
	 */
	public AddressModel getAddress() {
		return address;
	}
	
	/**
	 * sets the address model
	 * @param address address
	 */
	public void setAddress(AddressModel address) {
		this.address = address;
	}
	
	/**
	 * gets the user name 
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * sets the user name
	 * @param userName userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * gets the password
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * set the password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * gets the role
	 * @return char
	 */
	public char getRole() {
		return role;
	}
	
	/**
	 * set the role 
	 * @param role role
	 */
	public void setRole(char role) {
		this.role = role;
	}
	
	/**
	 * gets the student id
	 * @return String 
	 */
	public String getStudentId() {
		return studentId;
	}
	
	/**
	 * sets the student id
	 * @param studentId studentId
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * gets the email
	 * @return String
	 */
	public String getEmailId() {
		return emailId;
	}
	
	/**
	 * Sets the email id
	 * @param emailId  emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * get the authorization
	 * @return char
	 */
	public char getAuthorized() {
		return authorized;
	}
	
	/**
	 * sets the authorization
	 * @param authorized authorized
	 */
	public void setAuthorized(char authorized) {
		this.authorized = authorized;
	}	
}
