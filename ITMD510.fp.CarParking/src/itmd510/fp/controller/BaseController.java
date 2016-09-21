package itmd510.fp.controller;

import java.io.IOException;
import itmd510.fp.common.Common;
import itmd510.fp.common.Constants;
import itmd510.fp.model.UserProfileModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Name : Dinesh Ganesan Date : 05/05/2016 File Name : BaseController Source
 * File Name : BaseController.java Lab Number : Final Project
 * 
 * @author Dinesh_Ganesan
 * 
 *         Contains all the functionalities common to all the controller
 * 
 */
public class BaseController {

	/* Private variables */
	private char role;
	private UserProfileModel loginUser;
	protected String SuccessMsg;

	/**
	 * Set Role
	 * 
	 * @param role
	 *            role
	 */
	public void setRole(char role) {
		this.role = role;
	}

	/**
	 * Get Role
	 * 
	 * @return role
	 */
	public char getRole() {
		return this.role;
	}

	/**
	 * Sets the logged in user
	 * 
	 * @param loginUser
	 *            loginUser
	 */
	public void setLoginUser(UserProfileModel loginUser) {
		this.loginUser = loginUser;
	}

	/**
	 * Get the logged in user
	 * 
	 * @return UserProfileModel
	 */
	public UserProfileModel getLoginUser() {
		return this.loginUser;
	}

	/**
	 * Sets the Error message
	 * 
	 * @param inputField
	 *            inputField
	 * @param errField
	 *            errField
	 * @param errorMsg
	 *            errorMsg
	 */
	public void SetErrorMessage(String inputField, Text errField, String errorMsg) {
		if (Common.IsNullOrEmpty(inputField))
			errField.setText(errorMsg);
		else
			errField.setText(null);
	}

	/**
	 * Sets the Error Message Function over loading - Static polymorphism
	 * 
	 * @param errField
	 *            errField
	 * @param errMsg
	 *            errMsg
	 */
	public void SetErrorMessage(Text errField, String errMsg) {
		errField.setText(errMsg);
	}

	/**
	 * Validates the input field with regex
	 * 
	 * @param inputField
	 *            inputField
	 * @param errField
	 *            errField
	 * @param regexExpression
	 *            regexExpression
	 * @param errorMsg
	 *            errorMsg
	 * @param regexErrorMsg
	 *            regexErrorMsg
	 */
	public void ValidateRegex(String inputField, Text errField, String regexExpression, String errorMsg,
			String regexErrorMsg) {
		if (Common.IsNullOrEmpty(inputField))
			errField.setText(errorMsg);
		else if (!inputField.matches(regexExpression))
			SetErrorMessage(errField, regexErrorMsg);
		else
			errField.setText(null);
	}

	/**
	 * Redirects based on the role
	 * 
	 * @param ev
	 *            ev
	 * @param resource
	 *            resource
	 * @param role
	 *            role
	 * @param heading
	 *            heading
	 */
	protected void RedirectBasedOnRole(ActionEvent ev, String resource, char role, String heading) {
		try {
			Parent root = null;
			Stage stage = (Stage) ((Node) ev.getSource()).getScene().getWindow();
			if (resource.equals(Constants.LOGIN)) {
				root = LoginRedirection(role, heading);
			} else if (resource.equals(Constants.ADMINHOME)) {
				root = AdminHomeRedirection(role, heading);
			} else if (resource.equals(Constants.USERREGISTRATION)) {
				root = UserRegistrationRedirection(role, heading);
			} else if (resource.equals(Constants.LOGOUT)) {
				root = LogOutRedirection();
			} else if (resource.equals(Constants.ADMINACCESS)) {
				root = AdminAccessRedirection(role, heading);
			} else if (resource.equals(Constants.PARKINGLOTDETAILS)) {
				root = AdminAccessRedirection(role, heading);
			} else if (resource.equals(Constants.CUSTOMEMR)) {
				root = CustomerRedirect(role, heading);
			}
			stage.setTitle(heading);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Constants.CSS_URL);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * CustomerRedirect happens here
	 * 
	 * @param role
	 *            role
	 * @param heading
	 *            heading
	 * @return parent
	 * @throws IOException
	 *             IOException
	 */
	private Parent CustomerRedirect(char role, String heading) throws IOException {
		Parent root = null;
		FXMLLoader fxmlLoader;
		if (role == 'E') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.USER_REGISTRATION_URL));
			root = (Parent) fxmlLoader.load();
			UserRegistrationController controller = fxmlLoader.<UserRegistrationController> getController();
			controller.setLoginUser(loginUser);
			controller.setRole('X');
			controller.SetField();
			SuccessMsg = Constants.String_Empty;
		} else if (role == 'C') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.PARKING_LOT_DETAILS_URL));
			root = (Parent) fxmlLoader.load();
			ParkingLotDetailsController controller = fxmlLoader.<ParkingLotDetailsController> getController();
			controller.setLoginUser(loginUser);
			controller.CustomerView();
			controller.LoadParkingTable();
		} else if (role == 'B') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.BOOK_PARKING));
			root = (Parent) fxmlLoader.load();
			BookingController controller = fxmlLoader.<BookingController> getController();
			controller.setLoginUser(loginUser);
			controller.LoadUserDetails();
			controller.LoadCategoryText();
			controller.DatePickerValidation();
			if (getLoginUser().getRole() == 'C')
				controller.SetForCustomer();
		} else if (role == 'V') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.ViewLog));
			root = (Parent) fxmlLoader.load();
			BookingController controller = fxmlLoader.<BookingController> getController();
			controller.setLoginUser(loginUser);
			controller.LoadViewParkingLog();
		}
		return root;

	}

	/**
	 * AdminAccessRedirection happens here
	 * 
	 * @param role
	 *            role
	 * @param heading
	 *            heading
	 * @return Parent
	 * @throws IOException
	 *             IOException
	 */
	private Parent AdminAccessRedirection(char role, String heading) throws IOException {
		Parent root = null;
		FXMLLoader fxmlLoader;
		if (role == 'A') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.ADMINHOME_URL));
			root = (Parent) fxmlLoader.load();
			HomeController controller = fxmlLoader.<HomeController> getController();
			controller.setLoginUser(loginUser);
			controller.SetWelcome("Welcome " + loginUser.getFirstName() + " " + loginUser.getLastName() + ",",
					SuccessMsg);
			SuccessMsg = Constants.String_Empty;
		} else if (loginUser.getRole() == 'C') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.CUSTHOME_URL));
			root = (Parent) fxmlLoader.load();
			HomeController controller = fxmlLoader.<HomeController> getController();
			controller.setLoginUser(loginUser);
			controller.SetWelcome("Welcome " + loginUser.getFirstName() + " " + loginUser.getLastName() + ",",
					Constants.String_Empty);
		}
		return root;
	}

	/**
	 * LogOutRedirection happens here
	 * 
	 * @return Parent
	 * @throws IOException
	 *             IOException
	 */
	private Parent LogOutRedirection() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LOGIN_URL));
		Parent root = (Parent) fxmlLoader.load();
		return root;
	}

	/**
	 * UserRegistrationRedirection happens here
	 * 
	 * @param role
	 *            role
	 * @param heading
	 *            heading
	 * @return Parent
	 * @throws IOException
	 *             IOException
	 */
	private Parent UserRegistrationRedirection(char role, String heading) throws IOException {
		Parent root = null;
		FXMLLoader fxmlLoader;
		if (role == 'G') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.LOGIN_URL));
			root = (Parent) fxmlLoader.load();
			LoginController controller = fxmlLoader.<LoginController> getController();
			controller.SetSuccessMessage(SuccessMsg);
		} else if (role == 'A') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.ADMINHOME_URL));
			root = (Parent) fxmlLoader.load();
			HomeController controller = fxmlLoader.<HomeController> getController();
			controller.setLoginUser(loginUser);
			controller.SetWelcome("Welcome " + loginUser.getFirstName() + " " + loginUser.getLastName() + ",",
					SuccessMsg);
			SuccessMsg = Constants.String_Empty;
		} else if (role == 'E') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.ADMINHOME_URL));
			root = (Parent) fxmlLoader.load();
			HomeController controller = fxmlLoader.<HomeController> getController();
			controller.setLoginUser(loginUser);
			controller.SetWelcome("Welcome " + loginUser.getFirstName() + " " + loginUser.getLastName() + ",",
					SuccessMsg);
			SuccessMsg = Constants.String_Empty;
		}
		return root;
	}

	/**
	 * AdminHomeRedirection happens heres
	 * 
	 * @param role
	 *            role
	 * @param heading
	 *            heading
	 * @return Parent
	 * @throws IOException
	 *             IOException
	 */
	private Parent AdminHomeRedirection(char role, String heading) throws IOException {
		Parent root = null;
		FXMLLoader fxmlLoader;
		// Redirects to Customer & Employee
		if (role == 'C' || role == 'E') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.USER_REGISTRATION_URL));
			root = (Parent) fxmlLoader.load();
			UserRegistrationController controller = fxmlLoader.<UserRegistrationController> getController();
			controller.setRole(role);
			controller.setLoginUser(loginUser);
			controller.SetPageHeading(heading);
		} else if (role == 'G') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.ADMIN_ACCESS_URL));
			root = (Parent) fxmlLoader.load();
			AdminAccessController controller = fxmlLoader.<AdminAccessController> getController();
			controller.setLoginUser(loginUser);
			controller.LoadAdminUser();
			controller.LoadEmployeeUser();
		} else if (role == 'A') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.PARKING_LOT_DETAILS_URL));
			root = (Parent) fxmlLoader.load();
			ParkingLotDetailsController controller = fxmlLoader.<ParkingLotDetailsController> getController();
			controller.setLoginUser(loginUser);
			controller.SetAccordionOpen();
			controller.LoadCategory();
			controller.LoadParkingTable();
		} else if (role == 'V') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.ViewLog));
			root = (Parent) fxmlLoader.load();
			BookingController controller = fxmlLoader.<BookingController> getController();
			controller.setLoginUser(loginUser);
			controller.LoadViewParkingLog();
		}
		return root;
	}

	/**
	 * LoginRedirection happens here
	 * 
	 * @param role
	 *            role
	 * @param heading
	 *            heading
	 * @return Parent
	 * @throws IOException
	 *             IOException
	 */
	private Parent LoginRedirection(char role, String heading) throws IOException {
		FXMLLoader fxmlLoader;
		Parent root = null;
		if (role == 'F') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.USER_REGISTRATION_URL));
			root = (Parent) fxmlLoader.load();
			UserRegistrationController controller = fxmlLoader.<UserRegistrationController> getController();
			controller.setRole('G');
			controller.SetPageHeading(heading);
			controller.DisableLogoutLink();
		} else if (loginUser.getRole() == 'A') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.ADMINHOME_URL));
			root = (Parent) fxmlLoader.load();
			HomeController controller = fxmlLoader.<HomeController> getController();
			controller.setLoginUser(loginUser);
			controller.SetWelcome("Welcome " + loginUser.getFirstName() + " " + loginUser.getLastName() + ", (Admin)",
					Constants.String_Empty);
		} else if (loginUser.getRole() == 'C' || loginUser.getRole() == 'E') {
			fxmlLoader = new FXMLLoader(getClass().getResource(Constants.CUSTHOME_URL));
			root = (Parent) fxmlLoader.load();
			HomeController controller = fxmlLoader.<HomeController> getController();
			controller.setLoginUser(loginUser);
			controller.SetWelcome("Welcome " + loginUser.getFirstName() + " " + loginUser.getLastName() + ",",
					SuccessMsg);
		}
		return root;
	}
}
