package ems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Staff;
import util.DateConverter;
import database.dbReader;
import database.dbWriter;

public class Edit_Crew_Member_Controller {
	
	private List<Staff> staffList = new ArrayList<>();

    @FXML
    private MenuItem reportCallMenu;
    @FXML
    private MenuItem uploadFileMenu;
    @FXML
    private MenuItem analyticsMenu;
    @FXML
    private MenuItem newServiceMenu;
    @FXML
    private MenuItem newHospitalMenu;
    @FXML
    private MenuItem newCrewMenu;
    @FXML
    private MenuItem quitMenu;
    @FXML
    private MenuItem editCrewMenu;

    @FXML
    private TextField nameLookUp;
    @FXML
    private TextField dobLookUp;
    @FXML
    private Button submitLookUpButton;
    @FXML
    private Button clearLookUpButton;
    @FXML
    private TextField nameEdit;
    @FXML
    private TextField dobEdit;
    @FXML
    private TextField badgeIDEdit;
    @FXML
    private TextField staffIDEdit;
    @FXML
    private Button submitEditButton;
    @FXML
    private Button deleteEditButton;
    @FXML
    private ListView<String> listView;
    @FXML
    private Button selectLookupButton;


    // to access methods in main class
    private Main mainVar = new Main();

    // open the edit crew scene
    public void goReportCall() throws IOException {
        mainVar.showReportCallScene();
    }

    // open the edit crew scene
    public void goEditCrew() throws IOException {
        mainVar.showEditCrewScene();
    }

    // open the add new crew scene
    public void goNewCrew() throws IOException {
        mainVar.showNewCrewScene();
    }

    // open the add new hospital scene
    public void goNewHospital() throws IOException {
        mainVar.showNewHospitalScene();
    }

    // open the add new service scene
    public void goNewService() throws IOException {
        mainVar.showNewServiceScene();
    }

    public void goQuit() {
        mainVar.quitAction();
    }

    public void goUploadFile() throws IOException {
        mainVar.showUploadFileScene();
    }

    public void goAnalytics() throws IOException {
        mainVar.showAnalyticsScene();
    }

    public void clearLookUpFields() {
        nameLookUp.clear();
        dobLookUp.clear();
    }

    public void clearEditFields() {
        nameEdit.clear();
        dobEdit.clear();
        badgeIDEdit.clear();
        staffIDEdit.clear();
    }

    // called when look up submit button is clicked
    public void addLookUpToDatabase() {
        // DATABASE STUFF

        // This shows how to add things to the selectable list view
        //Note, these will be set by whatever is in the database
    	dbReader reader = new dbReader();
    	String name = nameLookUp.getText();
    	String temp = dobLookUp.getText();
    	Timestamp sdob = DateConverter.converBod(temp);
    	
    	try {
    		staffList = reader.getStaff(name, sdob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(Staff staff:staffList){
    		listView.getItems().add(staff.toString());
    	}

    }

    // called when look up submit button is clicked
    public void selectLookUpToDatabase() {
        // DATABASE STUFF

    	int selectedIndex = listView.getSelectionModel().getSelectedIndex();
    	Staff selectstaff = staffList.get(selectedIndex);
        // This shows how to populate the edit textboxes
        //Note, these will be set by whatever is the database
        nameEdit.setText(selectstaff.getName());
        dobEdit.setText(""+DateConverter.converBodtoString(selectstaff.getDateofBirth()));
        badgeIDEdit.setText(""+selectstaff.getBadgeID());
        staffIDEdit.setText(""+selectstaff.getStaffID());

    }

    // called when edit submit button is clicked
    public void addEditToDatabase() {
        // DATABASE STUFF
        // clear all the fields after submission
    	String name = nameEdit.getText();
    	String dob_string = dobEdit.getText();
    	Timestamp dateofBirth = DateConverter.converBod(dob_string);
    	int badgeID = Integer.parseInt(badgeIDEdit.getText());
    	int staffID = Integer.parseInt(staffIDEdit.getText());
    	Staff updateStaff = new Staff(staffID, name,  badgeID,  dateofBirth);
    	dbWriter writer = new dbWriter();
    	try {
			writer.updateStaff(updateStaff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        clearEditFields();
        clearLookUpFields();
        listView.getItems().clear();
    }

    // called when delete button is clicked
    public void deleteFromDatabase() {
        // DATABASE STUFF
     	String name = nameEdit.getText();
    	String dob_string = dobEdit.getText();
    	Timestamp dateofBirth = DateConverter.converBod(dob_string);
    	int badgeID = Integer.parseInt(badgeIDEdit.getText());
    	int staffID = Integer.parseInt(staffIDEdit.getText());
    	Staff updateStaff = new Staff(staffID, name,  badgeID,  dateofBirth);
    	dbWriter writer = new dbWriter();
    	try {
			writer.deleteStaff(updateStaff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // clear all the fields after deletion
        clearEditFields();
        clearLookUpFields();
        listView.getItems().clear();
    }

}
