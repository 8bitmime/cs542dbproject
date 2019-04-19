package ems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Timestamp;

import database.dbWriter;
import util.DateConverter;
import model.Staff;

public class Add_New_Crew_Controller {

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
    private TextField nameBox;
    @FXML
    private TextField dobBox;
    @FXML
    private TextField badgeIDBox;
    @FXML
    private Button submitButton;
    @FXML
    private Button clearButton;

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

    public void clearFields() {
        nameBox.clear();
        dobBox.clear();
        badgeIDBox.clear();
    }

    // called when submit button is clicked
    public void addToDatabase() {
        // DATABASE STUFF
    	String name = nameBox.getText();
    	String dob = dobBox.getText();
    	int badgeID =Integer.parseInt(badgeIDBox.getText());
    	Timestamp dobTime = DateConverter.converBod(dob);
    	Staff staff = new Staff(name,badgeID,dobTime);
    	dbWriter writter =new dbWriter();
    	try {
			writter.insertStaff(staff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // clear all the fields after submission
        clearFields();
    }

}
