/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Navigation;

//import Appointment.AppointmentStage;
//import Diagram.Diagram;
//import Employee.AddEmployee;
//import Employee.ReadEmployee;
//import Patient.AddPatient;
//import Patient.ReadPatient;
//import Prescription.OrderPerscription;
//import Prescription.ReadPrescription;
import Appointment.AppointmentStage;
import Diagram.Diagram;
import Employee.AddEmployee;
import Employee.ReadEmployee;
import Patient.AddPatient;
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
//import room.RoomStage;


public class Adminstrator_Access {

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

    static Stage primaryStage = new Stage();

    public void adminstrator_access_main()
    {
        Scene scene = new Scene(borderPane, 900, 600, Color.WHITE);
        primaryStage.setScene(scene);

        //  primaryStage.setResizable(false);
        primaryStage.setTitle("Hospital Personal Information Management System");
        scene.getStylesheets().add("style.css");
        primaryStage.show();
    }

    public Adminstrator_Access() {


        System.out.println("adminstration access");
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
//       borderPane.setRight(gridPane);
//       borderPane.setBottom(gridPane);

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

        drawerCloseBtn.setStyle("-fx-background-color:#ff0000; -fx-color:#ffffff;");
       drawerCloseBtn.setOnAction(e->{
           drawer.close();
           borderPane.setLeft(gridPane);
       });
       hBox.getChildren().addAll(l,drawerCloseBtn);


        JFXButton addPatientBtn = new JFXButton("Add Patient");
        addPatientBtn.setOnAction(e->{


            AddPatient addPatient = new AddPatient();
            addPatient.add_patient_main();
        });

        JFXButton readPatientBtn = new JFXButton("List of Patient");
        readPatientBtn.setOnAction(e->{

            ReadPatient readPatient = new ReadPatient();
            readPatient.show();
        });



        JFXButton addEmployeeBtn = new JFXButton("Add Employee");
        addEmployeeBtn.setOnAction(e->{


            AddEmployee addEmployee = new AddEmployee();
            System.out.println("add employee a b");
            addEmployee.add_employee_main();
            System.out.println("add employee a a");
        });

        JFXButton readEmployeeBtn = new JFXButton("List of Employees");
        readEmployeeBtn.setOnAction(e->{
            ReadEmployee readEmployee = new ReadEmployee();
            readEmployee.show();
        });


        JFXButton addPrescriptionBtn = new JFXButton("Add Prescription");
        addPrescriptionBtn.setOnAction(e->{
            OrderPerscription orderPerscription = new OrderPerscription();
            orderPerscription.order_perscription_main();
        });

        JFXButton readPrescriptionBtn = new JFXButton("List of Prescription");
        readPrescriptionBtn.setOnAction(e->{
            ReadPrescription readPrescription = new ReadPrescription();
            readPrescription.show();
        });

        JFXButton readRoomBtn = new JFXButton("List of Rooms");
        readRoomBtn.setOnAction(e->{
            RoomStage roomStage = new RoomStage();
            roomStage.show();
        });


        JFXButton readAppointmentBtn = new JFXButton("List of Appointments");
        readAppointmentBtn.setOnAction(e->{
            System.out.println("show");
            System.out.println("show");
            AppointmentStage appointmentStage = new AppointmentStage();
            appointmentStage.show();
        });



        JFXButton diagram = new JFXButton("Diagram");


        diagram.setOnAction(e->{

                    Diagram diagram1 = new Diagram();
                    diagram1.show();
            }
            );



        forDrawer.setHgap(5);
        forDrawer.setVgap(5);
        // gridPane.setPadding(new Insets(5));

        ColumnConstraints column2 = new ColumnConstraints(200);
        forDrawer.getColumnConstraints().add(column2);


        GridPane.setHalignment(addPatientBtn, HPos.LEFT);
        forDrawer.add(addPatientBtn, 0, 0);

        GridPane.setHalignment(readPatientBtn, HPos.LEFT);
        forDrawer.add(readPatientBtn, 0, 3);

        GridPane.setHalignment(addEmployeeBtn, HPos.LEFT);
        forDrawer.add(addEmployeeBtn, 0, 6);


        GridPane.setHalignment(readEmployeeBtn, HPos.LEFT);
        forDrawer.add(readEmployeeBtn, 0, 9);

        GridPane.setHalignment(addPrescriptionBtn, HPos.LEFT);
        forDrawer.add(addPrescriptionBtn, 0, 12);

        GridPane.setHalignment(readPrescriptionBtn, HPos.LEFT);
        forDrawer.add(readPrescriptionBtn, 0, 15);

        GridPane.setHalignment(readAppointmentBtn, HPos.LEFT);
        forDrawer.add(readAppointmentBtn, 0, 18);

        GridPane.setHalignment(readRoomBtn, HPos.LEFT);
        forDrawer.add(readRoomBtn, 0, 21);

        GridPane.setHalignment(diagram, HPos.LEFT);
        forDrawer.add(diagram, 0, 24);




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

