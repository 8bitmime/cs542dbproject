package ems;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import database.dbWriter;
import util.DateConverter;
import model.Call;
import model.Location;
import model.Outcome;
import model.ReceivingHospital;
import model.ReceivingService;
import model.Staff;
import model.TTime;

public class Report_A_Call_Controller implements Initializable {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
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
    private DatePicker staffDispatchedDate;
    @FXML
    private ComboBox<String> staffDispatchedHour;
    @FXML
    private ComboBox<String> staffDispatchedMin;
    @FXML
    private DatePicker staffArrivedDate;
    @FXML
    private ComboBox<String> staffArrivedHour;
    @FXML
    private ComboBox<String> staffArrivedMin;
    @FXML
    private DatePicker staffClearedDate;
    @FXML
    private ComboBox<String> staffClearedHour;
    @FXML
    private ComboBox<String> staffClearedMin;

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
    private MenuItem addServiceMenu;
    @FXML
    private MenuItem addHospitalMenu;
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

        staffDispatchedHour.setValue("00");
        staffDispatchedHour.setItems(hourList);

        staffDispatchedMin.setValue("00");
        staffDispatchedMin.setItems(minList);

        staffArrivedHour.setValue("00");
        staffArrivedHour.setItems(hourList);

        staffArrivedMin.setValue("00");
        staffArrivedMin.setItems(minList);

        staffClearedHour.setValue("00");
        staffClearedHour.setItems(hourList);

        staffClearedMin.setValue("00");
        staffClearedMin.setItems(minList);

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
        nameField1.clear();
        badgeIDField1.clear();

        nameField2.clear();
        badgeIDField2.clear();

        nameField3.clear();
        badgeIDField3.clear();

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

        staffDispatchedDate.setValue(null);
        staffDispatchedHour.setValue("00");
        staffDispatchedMin.setValue("00");
        staffArrivedDate.setValue(null);
        staffArrivedHour.setValue("00");
        staffArrivedMin.setValue("00");
        staffClearedDate.setValue(null);
        staffClearedHour.setValue("00");
        staffClearedMin.setValue("00");
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
    	List<Staff> crewList = new ArrayList<>();
    	List<TTime> timeList = new ArrayList<TTime>();
    	
    	String name1 = nameField1.getText();
        int badgeID1 = Integer.parseInt(badgeIDField1.getText());
        Staff staff1 = new Staff(name1,badgeID1);
        
        String name2 = nameField2.getText();
        int badgeID2 = Integer.parseInt(badgeIDField2.getText());
        Staff staff2 = new Staff(name2,badgeID2);
        
        String name3 = nameField3.getText();
        int badgeID3 = Integer.parseInt(badgeIDField3.getText());
        Staff staff3 = new Staff(name3,badgeID3);
        crewList.add(staff1);
        crewList.add(staff2);
        crewList.add(staff3);
        
        LocalDate callDatet =  callTimeDate.getValue();        
        Timestamp callDate = dateMerg(callDatet,callTimeHour.getValue(),callTimeMin.getValue());
        System.out.println(callDate);
        TTime calltime = new TTime(callDate,"Date Available");

        
        String locType = callLocationType.getValue();
        String locName = callLocationName.getText();
        String locAddr = callLocationAddress.getText();
        Location callLocation = new Location(locType, locName, locAddr);
        
        String dispatchAs = dispatchedAs.getValue();
        String impress = impression.getValue();
        String outResult = outcome.getValue();
        String recvService = receivingService.getValue();
        String recvHospital = receivingHospital.getValue();
        Outcome outcome = null;
        if(!recvService.equalsIgnoreCase("Not Applicable")){
        	ReceivingService service = new ReceivingService(recvService);
        	 outcome = new Outcome( outResult,service,
        			null);
        }
        if(!recvHospital.equalsIgnoreCase("Not Applicable")){
        	Location hospLoc = new Location("Hospital","","");
        	ReceivingHospital hospital = new ReceivingHospital(recvHospital, hospLoc);
        	 outcome = new Outcome(outResult, null,
        			hospital);
        }
        
        
        
        Timestamp eaDispatch = dateMerg(ambDispatchedDate.getValue(),ambDispatchedHour.getValue(),ambDispatchedMin.getValue());
        TTime aDispatch = new TTime(eaDispatch,"EA-Dispatch");
        
        Timestamp eaArrived = dateMerg(ambArrivedDate.getValue(),ambArrivedHour.getValue(),ambArrivedMin.getValue());
        TTime aArrived = new TTime(eaArrived,"EA-Arrived");
        
        Timestamp eaClear = dateMerg(ambClearedDate.getValue(),ambClearedHour.getValue(),ambClearedMin.getValue());
        TTime aClear = new TTime(eaClear,"EA-Clear");
        
        Timestamp staffDispatch = dateMerg(staffDispatchedDate.getValue(),staffDispatchedHour.getValue(),staffDispatchedMin.getValue());
        TTime sDispatch = new TTime(staffDispatch,"Date Dispatched");
        
        Timestamp staffArrived = dateMerg(staffDispatchedDate.getValue(),staffDispatchedHour.getValue(),staffDispatchedMin.getValue());
        TTime sArrived = new TTime(staffArrived,"Date Enroute");    
        
        Timestamp staffClear = dateMerg(staffClearedDate.getValue(),staffClearedHour.getValue(),staffClearedMin.getValue());
        TTime sClear = new TTime(staffClear,"Date Enroute");  
        
        timeList.add(sDispatch);
		timeList.add(sArrived);
		timeList.add(sClear);
		timeList.add(calltime);
		timeList.add(aDispatch);
		timeList.add(aArrived);
		timeList.add(aClear);
        
        Call  call = new Call(dispatchAs,impress, outcome, timeList, crewList, callLocation);
        
        dbWriter writer = new dbWriter();
        try {
			writer.inserCall(call);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // clear all the fields after submission
        clearFields();
    }
    
    private Timestamp dateMerg(LocalDate callDate, String hour, String min){
    	return DateConverter.converDate(callDate.format(formatter)+" "+hour +":"+min);
    }
}
