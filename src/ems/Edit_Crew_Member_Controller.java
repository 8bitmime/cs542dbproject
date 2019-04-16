package ems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Staff;
import util.DateConverter;
import database.dbReader;

public class Edit_Crew_Member_Controller {

    @FXML
    private MenuItem reportCallMenu;
    @FXML
    private MenuItem uploadFileMenu;
    @FXML
    private MenuItem analyticsMenu;
    @FXML
    private MenuItem newLocationMenu;
    @FXML
    private MenuItem newOutcomeMenu;
    @FXML
    private MenuItem newServiceMenu;
    @FXML
    private MenuItem newHospitalMenu;
    @FXML
    private MenuItem newCallTypeMenu;
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
    private Button clearEditButton;
    @FXML
    private Button deleteEditButton;


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

    // open the add new call type scene
    public void goNewCall() throws IOException {
        mainVar.showNewCallScene();
    }

    // open the add new crew scene
    public void goNewCrew() throws IOException {
        mainVar.showNewCrewScene();
    }

    // open the add new hospital scene
    public void goNewHospital() throws IOException {
        mainVar.showNewHospitalScene();
    }

    // open the add new location scene
    public void goNewLocation() throws IOException {
        mainVar.showNewLocationScene();
    }

    // open the add new outcome scene
    public void goNewOutcome() throws IOException {
        mainVar.showNewOutcomeScene();
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
    	dbReader reader = new dbReader();
    	List<Staff> result = new ArrayList<>();
    	Timestamp bod = DateConverter.converBod(dobLookUp.getText());
    	try {
			result = reader.getStaff(nameLookUp.getText(), bod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("look up failed "+e);
		}
		System.out.println("look up success "+result.size());

    }

    // called when edit submit button is clicked
    public void addEditToDatabase() {
        // DATABASE STUFF
    }

    // called when delete button is clicked
    public void deleteFromDatabase() {
        // DATABASE STUFF
    }

}
