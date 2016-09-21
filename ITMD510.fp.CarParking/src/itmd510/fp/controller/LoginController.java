package itmd510.fp.controller;

import itmd510.fp.common.Common;
import itmd510.fp.common.Constants;
import itmd510.fp.dao.LoginDAO;
import itmd510.fp.dao.Interface.ILoginDAO;
import itmd510.fp.model.UserProfileModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: LoginController
 * Source File Name	: LoginController.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Contains all the functionalities for Login  
 * 
 */
public class LoginController extends BaseController {

	/* private variables */
	@FXML
	private TextField txtUserName;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Text errUserName;
	@FXML
	private Text errPassword;
	@FXML
	private Button btnLogin;
	@FXML
	private Button btnReset;
	@FXML
	private Text txtLoginMsg;

	private ILoginDAO loginDAO = new LoginDAO();


	/**
	 * Sets success message
	 * @param msg msg
	 */
	public void SetSuccessMessage(String msg) {
		this.txtLoginMsg.setText(msg);
	}

	/**
	 * checks whether a valid user name
	 * @return true for valid and false for not valid
	 */
	public boolean IsUserNameValid() {
		return loginDAO.getUserNameList().contains(txtUserName.getText());
	}
	
	/**
	 * ValidateUserName
	 * @param ev ev
	 */
	public void ValidateUserName(KeyEvent ev) {
		SetErrorMessage(txtUserName.getText(), errUserName, Constants.errUserName);
	}

	/**
	 * ValidatePassword
	 * @param ev ev
	 */
	public void ValidatePassword(KeyEvent ev) {
		SetErrorMessage(txtPassword.getText(), errPassword, Constants.errPassword);
	}

	/**
	 * login click button 
	 * @param ev ev
	 */
	public void btnLogin_Click(ActionEvent ev) {
		SetErrorMessage(txtUserName.getText(), errUserName, Constants.errUserName);
		SetErrorMessage(txtPassword.getText(), errPassword, Constants.errPassword);
		if (!defaultCheck()) {
			if (IsUserNameValid()) {
				UserProfileModel userDetail = loginDAO.getUserDetails(txtUserName.getText());
				if (userDetail.getPassword().equals(txtPassword.getText())) {
					try {

						setLoginUser(userDetail);
						switch (userDetail.getRole()) {
						case 'A':				
							RedirectBasedOnRole(ev, Constants.LOGIN, 'A', "Admin Home");
							break;
						case 'C':
							RedirectBasedOnRole(ev, Constants.LOGIN,'C', userDetail.getUserName() + " Home");
							break;
						case 'E':
							RedirectBasedOnRole(ev, Constants.LOGIN,'E', "Employee " + userDetail.getUserName() + " Home");
							break;
						default:
							break;
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				} else {
					SetErrorMessage(errPassword, Constants.errIncorrectPassword);
					txtPassword.setText(Constants.String_Empty);
				}

			} else {
				SetErrorMessage(errUserName, Constants.errUserNameNotFound);
				txtPassword.setText(Constants.String_Empty);
				errPassword.setText(Constants.String_Empty);
			}
		}
	}

	/**
	 * checks for default checking
	 * @return boolean
	 */
	public boolean defaultCheck() {
		return (Common.IsNullOrEmpty(txtUserName.getText()) || Common.IsNullOrEmpty(txtPassword.getText())) ? true
				: false;
	}

	/**
	 * Reset Button 
	 * @param ev ev
	 */
	public void btnReset_Click(ActionEvent ev) {
		txtUserName.setText(Constants.String_Empty);
		txtPassword.setText(Constants.String_Empty);
		errUserName.setText(Constants.String_Empty);
		errPassword.setText(Constants.String_Empty);
	}

	/**
	 * Redirects to registrations
	 * @param ev ev
	 */
	public void RedirectToRegistration(ActionEvent ev) {
		try {
			RedirectBasedOnRole(ev, Constants.LOGIN, 'F', "Customer Registration");

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
