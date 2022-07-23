/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigation;
//
//import Appointment.AppointmentStage;
//import Patient.ReadPatient;
//import Prescription.OrderPerscription;
//
//import Prescription.ReadPrescription;
import Appointment.AppointmentStage;
import Patient.ReadPatient;
import Prescription.OrderPerscription;
import Prescription.ReadPrescription;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.event.Event;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import room.RoomStage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Doctor_Access {

    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    private  Socket socket;
    GridPane gridPane = new GridPane();
    GridPane forDrawer = new GridPane();
    JFXHamburger hamburger = new JFXHamburger();
    JFXDrawer drawer = new JFXDrawer();
    public static BorderPane borderPane = new BorderPane();
    AnchorPane anchorPane = new AnchorPane();
    TreeItem<String> choice;
    VBox vBox = new VBox();
    private String searchChoice;
    private String searchData;
Stage primaryStage = new Stage();
    public void doctor_access_main()
    {
        Scene scene = new Scene(borderPane, 900, 600, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Doctors Access");
        primaryStage.show();
    }
    public Doctor_Access(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        this.socket = socket;
        this.inStream = inStream;
        this.outStream = outStream;
        initDrawer();

        borderPane.setPrefSize(1200, 900);
        anchorPane.setPrefSize(200, 600);
        //anchorPane.setMinWidth(400);

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        // gridPane.setPadding(new Insets(5));
        ColumnConstraints column1 = new ColumnConstraints(100);
        gridPane.getColumnConstraints().add(column1);


        GridPane.setHalignment(hamburger, HPos.LEFT);
        gridPane.add(hamburger, 0, 0);


        borderPane.setLeft(gridPane);
        HomePage homePage = new HomePage();


           anchorPane = homePage.anchorPane;


        borderPane.setCenter(new ScrollPane(anchorPane));

        anchorPane.setOnMouseClicked(e->{
            drawer.close();
            borderPane.setLeft(gridPane);
        });

    }



    private void initDrawer() {



        drawer.setOverLayVisible(false);
        drawer.setDefaultDrawerSize(250);


        VBox vBox1 = new VBox();
        HBox hBox = new HBox();
        Label l = new Label("  ~~~~~~~~~~~    Menu   ~~~~~~~~~~        ");
        JFXButton drawerCloseBtn = new JFXButton("X");
        drawerCloseBtn.setPadding(new Insets(10));

        drawerCloseBtn.setStyle("-fx-background-color:red; -fx-color:white;");
        drawerCloseBtn.setOnAction(e->{
            drawer.close();
            borderPane.setLeft(gridPane);
        });
        hBox.getChildren().addAll(l,drawerCloseBtn);


        JFXButton patients = new JFXButton("List of Patients");
        patients.setOnAction(e->{
            try {
                outStream.writeObject("Read Patient");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            ReadPatient readPatient = new ReadPatient(socket,inStream,outStream);
            readPatient.show();
        });



        JFXButton addPrescriptions = new JFXButton("Add Prescription");
        addPrescriptions.setOnAction(e->{

            OrderPerscription orderPerscription = new OrderPerscription(socket,inStream,outStream);
            orderPerscription.order_perscription_main();
        });

        JFXButton readPrescriptions = new JFXButton("List of Prescriptions");
        readPrescriptions.setOnAction(e->{
            try {
                outStream.writeObject("Read Prescription");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            ReadPrescription readPrescription = new ReadPrescription(socket,inStream,outStream);
            readPrescription.show();
        });


        JFXButton appointement = new JFXButton("Appointment");
        appointement.setOnAction(e->{
            System.out.println("show");
            try {
                outStream.writeObject("Read Appointment");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("show");
            AppointmentStage appointmentStage = new AppointmentStage(socket,inStream,outStream);
            appointmentStage.show();
        });

        JFXButton room = new JFXButton("List of Rooms");
        room.setOnAction(e->{
            try {
                outStream.writeObject("Read Room");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            RoomStage roomStage = new RoomStage(socket,inStream,outStream);
            roomStage.show();
        });



        forDrawer.setHgap(5);
        forDrawer.setVgap(5);
        // gridPane.setPadding(new Insets(5));

        ColumnConstraints column2 = new ColumnConstraints(200);
        forDrawer.getColumnConstraints().add(column2);


        GridPane.setHalignment(patients, HPos.LEFT);
        forDrawer.add(patients, 0, 0);


        GridPane.setHalignment(addPrescriptions, HPos.LEFT);
        forDrawer.add(addPrescriptions, 0, 3);


        GridPane.setHalignment(readPrescriptions, HPos.LEFT);
        forDrawer.add(readPrescriptions, 0, 6);

        GridPane.setHalignment(appointement, HPos.LEFT);
        forDrawer.add(appointement, 0, 9);

        GridPane.setHalignment(room, HPos.LEFT);
        forDrawer.add(room, 0, 12);


        forDrawer.setPadding( new Insets(20));

        vBox.getChildren().addAll(forDrawer);


        drawer.setSidePane(vBox);

        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(hamburger);
        task.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
            borderPane.setLeft(drawer);
            drawer.toggle();
        });
        drawer.setOnDrawerOpening((event) -> {
            task.setRate(task.getRate() * -1);
            task.play();
            drawer.toFront();

        });
        drawer.setOnDrawerClosed((event) -> {
            drawer.toBack();
            task.setRate(task.getRate() * -1);
            task.play();


        });
        drawer.setStyle("-fx-padding-top:20px;");

    }

}

