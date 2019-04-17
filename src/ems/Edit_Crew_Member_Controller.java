package ems;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Edit_Crew_Member_Controller {

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
        listView.getItems().addAll("Rachel Hahn, 07/15/1997, 01, 15", "Rachel Hahn, 08/10/1996, 02, 16");

    }

    // called when look up submit button is clicked
    public void selectLookUpToDatabase() {
        // DATABASE STUFF

        // This shows how to populate the edit textboxes
        //Note, these will be set by whatever is the database
        nameEdit.setText("Rachel Hahn");
        dobEdit.setText("07/15/1997");
        badgeIDEdit.setText("01");
        staffIDEdit.setText("15");

    }

    // called when edit submit button is clicked
    public void addEditToDatabase() {
        // DATABASE STUFF

        // clear all the fields after submission
        clearEditFields();
        clearLookUpFields();
        listView.getItems().clear();
    }

    // called when delete button is clicked
    public void deleteFromDatabase() {
        // DATABASE STUFF

        // clear all the fields after deletion
        clearEditFields();
        clearLookUpFields();
        listView.getItems().clear();
    }

}
