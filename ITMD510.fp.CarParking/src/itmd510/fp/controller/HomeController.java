package itmd510.fp.controller;

import itmd510.fp.common.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;

/**
 * Name : Dinesh Ganesan Date : 05/05/2016 File Name : HomeController Source
 * File Name : HomeController.java Lab Number : Final Project
 * 
 * @author Dinesh_Ganesan
 * 
 *         Contains all the functionalities for Home Dash board
 * 
 */
public class HomeController extends BaseController {

	/* Private variables */
	@FXML
	private Text lblWelcome;
	@FXML
	private Text txtAdminSuccess;
	@FXML
	private Button btnAddCustomer;
	@FXML
	private Button btnAddEmployee;
	@FXML
	private Button btnAccessButton;
	@FXML
	private Button btnViewParkingSpace;
	@FXML
	private Button btnViewParkingLog;
	@FXML
	private Hyperlink hlinkLogout;

	/**
	 * Sets a welcome message
	 * @param msg msg
	 * @param successMsg successMsg
	 */
	public void SetWelcome(String msg, String successMsg) {
		lblWelcome.setText(msg);
		txtAdminSuccess.setText(successMsg);
	}

	/* Admin Related Functions */
	
	/**
	 * Add Customer event
	 * @param ev ev
	 */
	public void btnAddCustomer_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.ADMINHOME, 'C', "Customer Registration");
	}
	
	/**
	 * Add Employee event
	 * @param ev ev
	 */
	public void btnAddEmployee_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.ADMINHOME, 'E', "Employee Registration");
	}

	/**
	 * Access event
	 * @param ev ev
	 */
	public void btnAccessButton_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.ADMINHOME, 'G', "Grant / Revoke Access");
	}

	/**
	 * View Parking Space event
	 * @param ev ev
	 */
	public void btnViewParkingSpace_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.ADMINHOME, 'A', "Parking Lot Details");
	}

	/**
	 * Add parking Log event
	 * @param ev ev
	 */
	public void btnViewParkingLog_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.ADMINHOME, 'V', "Parking Lot History");
	}

	/* Customer Related Functions */
	
	/**
	 * Edit profile event
	 * @param ev ev
	 */
	public void btnEditProfile_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.CUSTOMEMR, 'E', "Edit Profile");
	}

	/**
	 * Customer view parking event
	 * @param ev ev
	 */
	public void btnCustViewParkingSpace_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.CUSTOMEMR, 'C', "View Parking");
	}

	/**
	 * Book parking space event
	 * @param ev ev
	 */
	public void btnBookParkingSpace_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.CUSTOMEMR, 'B', "Book Parking");
	}

	/**
	 * view parking event
	 * @param ev ev
	 */
	public void btnViewLog_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.CUSTOMEMR, 'V', "View History");
	}

	/**
	 * Action for logout button
	 * @param ev event
	 */
	public void Logout_Click(ActionEvent ev) {
		setLoginUser(null);
		RedirectBasedOnRole(ev, Constants.LOGOUT, '\0', "Login");
	}

}
