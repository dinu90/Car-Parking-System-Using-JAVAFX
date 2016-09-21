package itmd510.fp.controller;

import java.util.List;
import java.util.stream.Collectors;

import itmd510.fp.common.Constants;
import itmd510.fp.dao.AdminAccessDAO;
import itmd510.fp.dao.Interface.IAdminAccessDAO;
import itmd510.fp.model.UserProfileModel;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;


/**
 * Name				: Dinesh Ganesan
 * Date				: 05/05/2016
 * File Name		: AdminAccessController
 * Source File Name	: AdminAccessController.java
 * Lab Number		: Final Project
 * @author Dinesh_Ganesan
 * 
 * Contains all the functionalities for admin access page 
 * 
 */
public class AdminAccessController extends BaseController {
	/* Private variables */
	
	@FXML
	private Hyperlink hlinkBack;
	@FXML
	private Hyperlink hlinkLogout;
	@FXML
	private Text txtMsg;
	@FXML
	private Text txtMsgRevoke;
	@FXML
	private TableView<UserProfileModel> tblEmployeeAccessView;
	@FXML
	private TableView<UserProfileModel> tblAdminAccessView;
	@FXML
	private Button btnGrandAccess;
	@FXML
	private Button btnRevokeAccess;

	private IAdminAccessDAO adminAccessDAO = new AdminAccessDAO();

	/**
	 * Loads the Admin type user
	 */
	public void LoadAdminUser() {
		List<UserProfileModel> adminUser = adminAccessDAO.getUserDetails().stream().filter(u -> u.getRole() == 'A')
				.collect(Collectors.toList());
		adminUser.removeIf(u -> u.getUserName().equals(getLoginUser().getUserName()));
		if (adminUser.size() == 0){
			txtMsgRevoke.setText("No Admin to Load");
			txtMsgRevoke.getStyleClass().add("validationError");
			btnRevokeAccess.setVisible(false);
			tblAdminAccessView.setItems(null);
		}
		else{
			tblAdminAccessView.setItems(FXCollections.observableArrayList(adminUser));
			txtMsgRevoke.setText(Constants.String_Empty);
			btnRevokeAccess.setVisible(true);
		}
	}

	/**
	 * Loads the Employee Type user
	 */
	public void LoadEmployeeUser() {
		List<UserProfileModel> employeeList = adminAccessDAO.getUserDetails().stream().filter(u -> u.getRole() == 'E')
				.collect(Collectors.toList());
		if (employeeList.size() == 0){
			txtMsg.setText("No Admin to Load");
			txtMsg.getStyleClass().add("validationError");
			btnGrandAccess.setVisible(false);
			tblEmployeeAccessView.setItems(null);
		}
		else{
			tblEmployeeAccessView.setItems(FXCollections.observableArrayList(employeeList));
			txtMsg.setText(Constants.String_Empty);
			btnGrandAccess.setVisible(true);
		}
	}

	/** 
	 * Action method for back link
	 * @param ev event
	 */
	public void hlinkBack_Click(ActionEvent ev) {
		RedirectBasedOnRole(ev, Constants.ADMINACCESS, 'A', "Admin Home");
	}

	/**
	 * Action for logout button
	 * @param ev event
	 */
	public void hlinkLogout_Click(ActionEvent ev) {
		setLoginUser(null);
		RedirectBasedOnRole(ev, Constants.LOGOUT, '\0', "Login");
	}

	/**
	 * Funtion for granting acces to employee and user
	 * @param ev event
	 */
	public void btnGrantAccess_Click(ActionEvent ev) {
		UserProfileModel selectedUser = this.tblEmployeeAccessView.getSelectionModel().getSelectedItem();
		if (selectedUser == null) {
			txtMsg.setText("Select an User");
			txtMsg.getStyleClass().add("validationError");
		}
		else{
			if(adminAccessDAO.UpdateUserDetail(selectedUser.getUserId(), "A")){
				LoadAdminUser();
				LoadEmployeeUser();
			}
			else{
				txtMsg.setText("Access didn't get updated. Try again later");
				txtMsg.getStyleClass().add("validationError");
			}
		}
	}
	
	/**
	 * Function to revoke the access
	 * @param ev event
	 */
	public void btnRevokeAccess_Click(ActionEvent ev) {
		UserProfileModel selectedUser = this.tblAdminAccessView.getSelectionModel().getSelectedItem();
		if (selectedUser == null) {
			txtMsgRevoke.setText("Select an User");
			txtMsgRevoke.getStyleClass().add("validationError");
		}
		else{
			if(adminAccessDAO.UpdateUserDetail(selectedUser.getUserId(), "E")){
				LoadAdminUser();
				LoadEmployeeUser();
			}
			else{
				txtMsgRevoke.setText("Access didn't get updated. Try again later");
				txtMsgRevoke.getStyleClass().add("validationError");
			}
		}
	}
}
