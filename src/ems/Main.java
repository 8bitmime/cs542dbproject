package ems;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import database.dbReader;
import database.dbWriter;

public class Main extends Application {
    private static Stage primaryStage;
    private static BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("Report_A_Call.fxml"));
        primaryStage.setTitle("EMS Program");
        primaryStage.setScene(new Scene(root, 640, 430));
        primaryStage.show();*/

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EMS Program");
        showMainView();
    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Report_A_Call.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void quitAction() {
        System.out.println("Exiting...");
        dbReader reader =new dbReader();
        try {
			reader.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dbWriter writer =new dbWriter();
        try {
			reader.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        primaryStage.close();
    }

    // open report call UI
    public static void showReportCallScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Report_A_Call.fxml"));
        BorderPane reportCall = loader.load();
        mainLayout.setCenter(reportCall);
    }

    // open edit crew UI
    public static void showEditCrewScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Edit_Crew_Member.fxml"));
        BorderPane editCrew = loader.load();
        mainLayout.setCenter(editCrew);
    }

    // open add new crew UI
    public static void showNewCrewScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Add_New_Crew.fxml"));
        BorderPane newCrew = loader.load();
        mainLayout.setCenter(newCrew);
    }

    // open add new hospital UI
    public static void showNewHospitalScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Add_New_Hospital.fxml"));
        BorderPane newHospital = loader.load();
        mainLayout.setCenter(newHospital);
    }

    // open add new service UI
    public static void showNewServiceScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Add_New_Service.fxml"));
        BorderPane newService = loader.load();
        mainLayout.setCenter(newService);
    }

    // open upload file UI
    public static void showUploadFileScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Upload_File.fxml"));
        BorderPane uploadFile = loader.load();
        mainLayout.setCenter(uploadFile);
    }

    // open analytics UI
    public static void showAnalyticsScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Analytics.fxml"));
        BorderPane analytics = loader.load();
        mainLayout.setCenter(analytics);
    }

    // add new location from user input and open report call UI
    public static void showReportCallSceneWithPassedLocationData(String input) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Report_A_Call.fxml"));
        BorderPane reportCall = loader.load();
        mainLayout.setCenter(reportCall);

        Report_A_Call_Controller controller = loader.getController();
        controller.getLocationTypeData(input);
    }

    // add new outcome from user input and open report call UI
    public static void showReportCallSceneWithPassedOutcomeData(String input) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Report_A_Call.fxml"));
        BorderPane reportCall = loader.load();
        mainLayout.setCenter(reportCall);

        Report_A_Call_Controller controller = loader.getController();
        controller.getOutcomeData(input);
    }

    // add new service from user input and open report call UI
    public static void showReportCallSceneWithPassedServiceData(String input) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Report_A_Call.fxml"));
        BorderPane reportCall = loader.load();
        mainLayout.setCenter(reportCall);

        Report_A_Call_Controller controller = loader.getController();
        controller.getServiceData(input);
    }

    // add new hospital from user input and open report call UI
    public static void showReportCallSceneWithPassedHospitalData(String input) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Report_A_Call.fxml"));
        BorderPane reportCall = loader.load();
        mainLayout.setCenter(reportCall);

        Report_A_Call_Controller controller = loader.getController();
        controller.getHospitalData(input);
    }

    // add new call type from user input and open report call UI
    public static void showReportCallSceneWithPassedCallTypeData(String input) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("Report_A_Call.fxml"));
        BorderPane reportCall = loader.load();
        mainLayout.setCenter(reportCall);

        Report_A_Call_Controller controller = loader.getController();
        controller.getCallTypeData(input);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
