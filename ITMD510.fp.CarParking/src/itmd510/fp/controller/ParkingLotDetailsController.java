package itmd510.fp.controller;

import java.util.Iterator;
import java.util.List;

import itmd510.fp.common.*;
import itmd510.fp.dao.*;
import itmd510.fp.dao.Interface.*;
import itmd510.fp.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 * Name : Dinesh Ganesan Date : 05/05/2016 File Name :
 * ParkingLotDetailsController Source File Name :
 * ParkingLotDetailsController.java Lab Number : Final Project
 * 
 * @author Dinesh_Ganesan
 * 
 *         Contains all the functionalities for Login
 * 
 */
public class ParkingLotDetailsController extends BaseController {

	/* Private Variables */
	@FXML
	private Accordion accordion;
	@FXML
	private TitledPane firstAccordion;
	@FXML
	private TitledPane secondAccordion;
	@FXML
	private TitledPane thirdAccordion;
	@FXML
	private Button btnAddCategory;
	@FXML
	private TextField txtCategory;
	@FXML
	private Text txtCategoryMsg;
	@FXML
	private TextField txtDescription;
	@FXML
	private TextField txtNoOfSpace;
	@FXML
	private Text errParking;
	@FXML
	private ComboBox<String> cbeCategory;
	@FXML
	private Button btnAddParkingSpace;
	@FXML
	private TableView<ParkingLot> tblParkingDetails;
	@FXML
	private RadioButton rbUpdate;
	@FXML
	private RadioButton rbDelete;
	@FXML
	private TextField txtUpdate;
	@FXML
	private Text txterror;
	@FXML
	private Button btnUpdateParking;

	public final ToggleGroup group = new ToggleGroup();

	private IParkingDAO parkingDAO = new ParkingDAO();

	/**
	 * Set Accordion Open
	 */
	public void SetAccordionOpen() {
		accordion.setExpandedPane(firstAccordion);
		rbUpdate.setToggleGroup(group);
		rbDelete.setToggleGroup(group);
		rbUpdate.setSelected(true);

		group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
			if (rbDelete.isSelected()) {
				txtUpdate.setVisible(false);
				txterror.setText("");
			} else {
				txtUpdate.setVisible(true);
				txtUpdate.setPromptText("Value to update");
			}
		});
	}

	/**
	 * Set Customer view
	 */
	public void CustomerView() {
		firstAccordion.setVisible(false);
		secondAccordion.setVisible(false);
		accordion.setExpandedPane(thirdAccordion);
		thirdAccordion.setVisible(true);
		thirdAccordion.setDisable(false);
		thirdAccordion.setText("Paking Details");
		rbUpdate.setVisible(false);
		rbDelete.setVisible(false);
		txtUpdate.setVisible(false);
		btnUpdateParking.setVisible(false);
	}

	/**
	 * Load the Category
	 */
	public void LoadCategory() {
		cbeCategory.getItems().clear();
		List<ParkingCategoryModel> categoryList = parkingDAO.GetParkingCategory();
		for (ParkingCategoryModel m : categoryList) {
			cbeCategory.getItems().add(m.getDescription());
		}
	}

	/**
	 * Loading Parking Table
	 */
	public void LoadParkingTable() {
		tblParkingDetails.getItems().clear();
		tblParkingDetails.setItems(FXCollections.observableArrayList(parkingDAO.GetParkingLot()));
	}

	/**
	 * add category button
	 * 
	 * @param ev
	 *            ev
	 */
	public void btnAddCategory_Click(ActionEvent ev) {
		if (!Common.IsNullOrEmpty(txtCategory.getText())) {
			ParkingCategoryModel category = new ParkingCategoryModel();
			category.setDescription(txtCategory.getText());
			int result = parkingDAO.AddCategory(category);
			if (result > 0) {
				txtCategoryMsg.getStyleClass().removeAll();
				txtCategoryMsg.getStyleClass().add("successMsg");
				txtCategoryMsg.setText(txtCategory.getText() + " Category was successfully added!!!");
				txtCategory.setText(Constants.String_Empty);
				LoadCategory();
			} else {
				txtCategoryMsg.getStyleClass().add("validationError");
				txtCategoryMsg.setText(txtCategory.getText() + " was not added. Please try after some time.");
			}
		} else {
			txtCategoryMsg.getStyleClass().add("validationError");
			SetErrorMessage(txtCategory.getText(), txtCategoryMsg, Constants.errCategoryEmpty);
		}
	}

	/**
	 * validate category
	 * 
	 * @param ev
	 *            ev
	 */
	public void ValidateCategory(KeyEvent ev) {
		txtCategoryMsg.getStyleClass().add("validationError");
		ValidateRegex(txtCategory.getText(), txtCategoryMsg, Constants.Parking_regex, Constants.errCategoryEmpty,
				Constants.errCategory_NoSpecial);
	}

	/**
	 * Validate no of space
	 * 
	 * @param ev
	 *            ev
	 */
	public void ValidateNoOfSpace(KeyEvent ev) {
		ValidateRegex(txtNoOfSpace.getText(), errParking, Constants.ParkingSpace_regex, Constants.noOfSpaceEmpty,
				Constants.onlyNumberAllowed);
	}

	/**
	 * Action method for back link
	 * 
	 * @param ev
	 *            event
	 */
	public void hlinkBack_Click(ActionEvent ev) {
		if (getLoginUser().getRole() == 'C')
			RedirectBasedOnRole(ev, Constants.PARKINGLOTDETAILS, 'C', getLoginUser().getUserName() + " Home");
		else if (getLoginUser().getRole() == 'E')
			RedirectBasedOnRole(ev, Constants.LOGIN, 'E', "Employee " + getLoginUser().getUserName() + " Home");
		else
			RedirectBasedOnRole(ev, Constants.PARKINGLOTDETAILS, 'A', "Admin Home");
	}

	/**
	 * Action for logout button
	 * 
	 * @param ev
	 *            event
	 */
	public void hlinkLogout_Click(ActionEvent ev) {
		setLoginUser(null);
		RedirectBasedOnRole(ev, Constants.LOGOUT, '\0', "Login");
	}

	/**
	 * Add Parking Space
	 * 
	 * @param ev
	 *            ev
	 */
	public void btnAddParkingSpace_Click(ActionEvent ev) {
		if (!Common.IsNullOrEmpty(txtDescription.getText())) {
			if (!Common.IsNullOrEmpty(txtNoOfSpace.getText())) {
				ParkingLot parking = new ParkingLot();
				parking.setAddressId(getLoginUser().getAddress().getAddressId());
				parking.setDescription(txtDescription.getText());
				parking.setNoOfSpace(Integer.parseInt(txtNoOfSpace.getText()));
				parking.setParkingCategoryId(parkingDAO.GetCategoryId(cbeCategory.getValue()));
				parking.setStatus("A");

				int result = parkingDAO.AddParking(parking);
				if (result > 0) {
					errParking.getStyleClass().add("successMsg");
					errParking.setText(txtDescription.getText() + " parking lot was added.");
					LoadParkingTable();
				} else {
					errParking.setText("Parking Lot was not added. Pls try again later!!");
				}
			} else
				SetErrorMessage(txtDescription.getText(), errParking, Constants.noOfSpaceEmpty);
		} else
			SetErrorMessage(txtDescription.getText(), errParking, Constants.descriptionEmpty);
	}

	/**
	 * Update Parking Lot Space
	 */
	public void UpdateParkingLotSpace() {
		if (rbUpdate.isSelected()) {
			int updateValue;
			if (this.tblParkingDetails.getSelectionModel().getSelectedItem() == null) {
				txterror.setText("Select a Parking Lot");
				txterror.getStyleClass().add("validationError");
			} else if (Common.IsNullOrEmpty(txtUpdate.getText())) {
				txterror.setText("Enter Value");
				txterror.getStyleClass().add("validationError");
			} else {
				try {
					updateValue = Integer.parseInt(txtUpdate.getText());
					ParkingLot parkingLot = new ParkingLot();
					parkingLot.setNoOfSpace(updateValue);
					parkingLot.setParkingLotId(
							this.tblParkingDetails.getSelectionModel().getSelectedItem().getParkingLotId());
					if (parkingDAO.UpdateParkingLot(parkingLot)) {
						LoadParkingTable();
						txterror.setText("");
					} else {
						txterror.setText("Something went wrong! try again later");
						txterror.getStyleClass().add("validationError");
					}
				} catch (NumberFormatException ex) {
					txterror.setText("Enter Value");
					txterror.getStyleClass().add("validationError");
				}
			}
		} else if (rbDelete.isSelected()) {
			if (this.tblParkingDetails.getSelectionModel().getSelectedItem() == null) {
				txterror.setText("Select a Parking Lot");
				txterror.getStyleClass().add("validationError");
			} else {
				try {
					ParkingLot parkingLot = new ParkingLot();
					parkingLot.setParkingLotId(
							this.tblParkingDetails.getSelectionModel().getSelectedItem().getParkingLotId());
					if (parkingDAO.DeleteParkingLot(parkingLot)) {
						LoadParkingTable();
						txterror.setText("");
					} else {
						txterror.setText("Something went wrong! try again later");
						txterror.getStyleClass().add("validationError");
					}
				} catch (NumberFormatException ex) {
					txterror.setText("Enter Value");
					txterror.getStyleClass().add("validationError");
				}
			}
		}
	}
}
