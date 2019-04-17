package ems;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Upload_File_Controller {

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
    private Label filePath;
    @FXML
    private Button chooseFileButton;
    @FXML
    private Button uploadButton;
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
        filePath.setText("<path>");
    }

    public void chooseFile() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Worksheets", "*.csv"));
        File f = fc.showOpenDialog(null);

        if (f != null) {
            filePath.setText(f.getAbsolutePath());
        }
    }

    // called when upload button is clicked
    public void addToDatabase() {
        // DATABASE STUFF

        // clear all the fields after upload
        clearFields();
    }
}
