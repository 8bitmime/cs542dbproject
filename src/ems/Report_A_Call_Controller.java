package ems;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Report_A_Call_Controller implements Initializable {

    // Report A Call Dropdown Lists
    ObservableList<String> dispatchedAsImpressionsList = FXCollections.observableArrayList("Not Recorded","Abdominal Pain", "Allergies", "Animal Bite", "Assault",
            "Back Pain", "Breathing Problems", "Burns", "CO Poisoning/Hazmat", "Cardiac Arrest", "Chest Pain", "Choking", "Convulsions/Seizure", "Diabetic Problem", "Drowning",
            "Electrocution", "Eye Problem", "Fall Victim", "Headache", "Heart Problems", "Heat/Cold Exposure", "Hemorrhage/Laceration", "Industrial Accident", "Ingestion/Poisoning",
            "MCI", "Not Known", "Pain", "Pregnancy/Childbirth", "Psychiatric Problems", "Respiratory Arrest", "Sick Person", "Stab/Gunshot Wounds", "Stroke/CVA", "Traffic Accident",
            "Transfer/Infertility/Palliative Care", "Trauma/Arrest", "Traumatic Injury", "Unconscious/Fainting");
    ObservableList<String> hospitalsList = FXCollections.observableArrayList("Not Applicable", "UMass Memorial", "UMass University", "St. Vincent");
    ObservableList<String> emsList = FXCollections.observableArrayList("Not Applicable", "Vital", "WEMS", "Medstar");
    ObservableList<String> outcomeList = FXCollections.observableArrayList("Not Applicable", "Dead at Scene", "No Patient Found", "No Treatment Required", "Patient Refused Care",
            "Treated, Refused Transport", "Treated, Transported by Law Enforcement", "Treated, Transported by Private Vehicle", "Treated, Transported by other EMS");
    ObservableList<String> locationTypeList = FXCollections.observableArrayList("Residential", "Dormitory", "Campus Building", "Outside");
    ObservableList<String> hourList = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23");
    ObservableList<String> minList = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45",
            "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");


    // Report A Call
    @FXML
    private TextField nameField1;
    @FXML
    private TextField badgeIDField1;
    @FXML
    private TextField nameField2;
    @FXML
    private TextField badgeIDField2;
    @FXML
    private TextField nameField3;
    @FXML
    private TextField badgeIDField3;
    @FXML
    private DatePicker timeEnrouteDate1;
    @FXML
    private ComboBox<String> timeEnrouteHour1;
    @FXML
    private ComboBox<String> timeEnrouteMin1;
    @FXML
    private DatePicker timeEnrouteDate2;
    @FXML
    private ComboBox<String> timeEnrouteHour2;
    @FXML
    private ComboBox<String> timeEnrouteMin2;
    @FXML
    private DatePicker timeEnrouteDate3;
    @FXML
    private ComboBox<String> timeEnrouteHour3;
    @FXML
    private ComboBox<String> timeEnrouteMin3;
    @FXML
    private DatePicker timeArrivedDate1;
    @FXML
    private ComboBox<String> timeArrivedHour1;
    @FXML
    private ComboBox<String> timeArrivedMin1;
    @FXML
    private DatePicker timeArrivedDate2;
    @FXML
    private ComboBox<String> timeArrivedHour2;
    @FXML
    private ComboBox<String> timeArrivedMin2;
    @FXML
    private DatePicker timeArrivedDate3;
    @FXML
    private ComboBox<String> timeArrivedHour3;
    @FXML
    private ComboBox<String> timeArrivedMin3;

    @FXML
    private DatePicker callTimeDate;
    @FXML
    private ComboBox<String> callTimeHour;
    @FXML
    private ComboBox<String> callTimeMin;
    @FXML
    private ComboBox<String> callLocationType;
    @FXML
    private TextField callLocationName;
    @FXML
    private TextField callLocationAddress;
    @FXML
    private ComboBox<String> dispatchedAs;
    @FXML
    private ComboBox<String> impression;
    @FXML
    private ComboBox<String> outcome;
    @FXML
    private ComboBox<String> receivingService;
    @FXML
    private ComboBox<String> receivingHospital;
    @FXML
    private DatePicker ambDispatchedDate;
    @FXML
    private ComboBox<String> ambDispatchedHour;
    @FXML
    private ComboBox<String> ambDispatchedMin;
    @FXML
    private DatePicker ambArrivedDate;
    @FXML
    private ComboBox<String> ambArrivedHour;
    @FXML
    private ComboBox<String> ambArrivedMin;
    @FXML
    private DatePicker ambClearedDate;
    @FXML
    private ComboBox<String> ambClearedHour;
    @FXML
    private ComboBox<String> ambClearedMin;
    @FXML
    private Button submitButton;
    @FXML
    private Button clearButton;

    @FXML
    private MenuItem reportCallMenu;
    @FXML
    private MenuItem uploadMenu;
    @FXML
    private MenuItem analyticsMenu;
    @FXML
    private MenuItem addLocationTypeMenu;
    @FXML
    private MenuItem addOutcomeMenu;
    @FXML
    private MenuItem addServiceMenu;
    @FXML
    private MenuItem addHospitalMenu;
    @FXML
    private MenuItem addCallTypeMenu;
    @FXML
    private MenuItem addCrewMenu;
    @FXML
    private MenuItem quitMenu;
    @FXML
    private MenuItem editCrewMenu;


    // things to do on startup
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dispatchedAs.setValue("Not Recorded");
        dispatchedAs.setItems(dispatchedAsImpressionsList);

        impression.setValue("Not Recorded");
        impression.setItems(dispatchedAsImpressionsList);

        receivingService.setValue("Not Applicable");
        receivingService.setItems(emsList);

        receivingHospital.setValue("Not Applicable");
        receivingHospital.setItems(hospitalsList);

        outcome.setValue("Not Applicable");
        outcome.setItems(outcomeList);

        callLocationType.setValue("Residential");
        callLocationType.setItems(locationTypeList);

        timeEnrouteHour1.setValue("00");
        timeEnrouteHour1.setItems(hourList);

        timeEnrouteMin1.setValue("00");
        timeEnrouteMin1.setItems(minList);

        timeEnrouteHour2.setValue("00");
        timeEnrouteHour2.setItems(hourList);

        timeEnrouteMin2.setValue("00");
        timeEnrouteMin2.setItems(minList);

        timeEnrouteHour3.setValue("00");
        timeEnrouteHour3.setItems(hourList);

        timeEnrouteMin3.setValue("00");
        timeEnrouteMin3.setItems(minList);

        timeArrivedHour1.setValue("00");
        timeArrivedHour1.setItems(hourList);

        timeArrivedMin1.setValue("00");
        timeArrivedMin1.setItems(minList);

        timeArrivedHour2.setValue("00");
        timeArrivedHour2.setItems(hourList);

        timeArrivedMin2.setValue("00");
        timeArrivedMin2.setItems(minList);

        timeArrivedHour3.setValue("00");
        timeArrivedHour3.setItems(hourList);

        timeArrivedMin3.setValue("00");
        timeArrivedMin3.setItems(minList);

        callTimeHour.setValue("00");
        callTimeHour.setItems(hourList);

        callTimeMin.setValue("00");
        callTimeMin.setItems(minList);

        ambDispatchedHour.setValue("00");
        ambDispatchedHour.setItems(hourList);

        ambDispatchedMin.setValue("00");
        ambDispatchedMin.setItems(minList);

        ambArrivedHour.setValue("00");
        ambArrivedHour.setItems(hourList);

        ambArrivedMin.setValue("00");
        ambArrivedMin.setItems(minList);

        ambClearedHour.setValue("00");
        ambClearedHour.setItems(hourList);

        ambClearedMin.setValue("00");
        ambClearedMin.setItems(minList);

    }

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
        nameField1.clear();
        badgeIDField1.clear();
        timeEnrouteDate1.setValue(null);
        timeEnrouteHour1.setValue("00");
        timeEnrouteMin1.setValue("00");
        timeArrivedDate1.setValue(null);
        timeArrivedHour1.setValue("00");
        timeArrivedMin1.setValue("00");

        nameField2.clear();
        badgeIDField2.clear();
        timeEnrouteDate2.setValue(null);
        timeEnrouteHour2.setValue("00");
        timeEnrouteMin2.setValue("00");
        timeArrivedDate2.setValue(null);
        timeArrivedHour2.setValue("00");
        timeArrivedMin2.setValue("00");

        nameField3.clear();
        badgeIDField3.clear();
        timeEnrouteDate3.setValue(null);
        timeEnrouteHour3.setValue("00");
        timeEnrouteMin3.setValue("00");
        timeArrivedDate3.setValue(null);
        timeArrivedHour3.setValue("00");
        timeArrivedMin3.setValue("00");

        callTimeDate.setValue(null);
        callTimeHour.setValue("00");
        callTimeMin.setValue("00");
        callLocationType.setValue("Residential");
        callLocationName.clear();
        callLocationAddress.clear();
        dispatchedAs.setValue("Not Recorded");
        impression.setValue("Not Recorded");
        outcome.setValue("Not Applicable");
        receivingService.setValue("Not Applicable");
        receivingHospital.setValue("Not Applicable");

        ambDispatchedDate.setValue(null);
        ambDispatchedHour.setValue("00");
        ambDispatchedMin.setValue("00");
        ambArrivedDate.setValue(null);
        ambArrivedHour.setValue("00");
        ambArrivedMin.setValue("00");
        ambClearedDate.setValue(null);
        ambClearedHour.setValue("00");
        ambClearedMin.setValue("00");
    }

    // add new location from user input
    public void getLocationTypeData(String input) {
        locationTypeList.add(input);
    }

    // add new outcome from user input
    public void getOutcomeData(String input) {
        outcomeList.add(input);
    }

    // add new service from user input
    public void getServiceData(String input) {
        emsList.add(input);
    }

    // add new hospital from user input
    public void getHospitalData(String input) {
        hospitalsList.add(input);
    }

    // add new call type from user input
    public void getCallTypeData(String input) {
        dispatchedAsImpressionsList.add(input);
    }

    // called when submit button is clicked
    public void addToDatabase() {
        // DATABASE STUFF
    }

}
