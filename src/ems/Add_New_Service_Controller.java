package ems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;

import model.ReceivingService;
import database.dbWriter;

public class Add_New_Service_Controller {

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
    private TextField serviceName;
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
        serviceName.clear();
    }

    // get user input and send to report a call controller to add to drop down list
    public void getType() throws IOException {
        // DATABASE STUFF
    	dbWriter writter =new dbWriter();
    	String input = serviceName.getText();
    	ReceivingService recvService = new ReceivingService(input);
    	try {
			writter.insertService(recvService);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        mainVar.showReportCallSceneWithPassedServiceData(input);

        // clear all the fields after submission
        clearFields();
    }

}
