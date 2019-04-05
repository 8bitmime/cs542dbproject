package ems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Add_New_Crew_Controller {

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
    private TextField nameBox;
    @FXML
    private TextField dobBox;
    @FXML
    private TextField badgeIDBox;
    @FXML
    private TextField staffIDBox;
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

    public void clearFields() {
        nameBox.clear();
        dobBox.clear();
        badgeIDBox.clear();
        staffIDBox.clear();
    }

    // called when submit button is clicked
    public void addToDatabase() {
        // DATABASE STUFF
        //
    }

}
