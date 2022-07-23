package Appointment;

import Alert.ShowAlert;
import DataTypes.Appointment;
import Login.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.time.LocalDate;

public class Add_Appointment extends Stage {

    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    int id;
    ComboBox doctor_id = new ComboBox();
    DatePicker date = new DatePicker();
    JFXTextField description = new JFXTextField();
    public Add_Appointment(int patient_id, Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream)
    {

        id = patient_id;
        this.inStream = inStream;
        this.outStream = outStream;
        Group root = new Group();
        Scene scene = new Scene(root,300,300);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));


        doctor_id.setPromptText("DOCTOR'S ID");

        Login login = new Login();
        int doctor = login.counts[1];

        for(int i=1;i<=doctor; i++) {
            doctor_id.getItems().addAll(i);
        }
        doctor_id.setMinWidth(150);


       description.setPromptText("DESCRIPTION");
       date.setPromptText("Appointment Date");



        JFXButton add = new JFXButton("ADD");
        add.setOnAction(e->{
            try {
                add();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });


          GridPane gridPane = new GridPane();
          gridPane.setPadding(new Insets(10));
          gridPane.setVgap(10);
          gridPane.setHgap(10);
        gridPane.setHalignment(doctor_id, HPos.LEFT);
        gridPane.add(doctor_id,0,1);

        gridPane.setHalignment(description, HPos.LEFT);
        gridPane.add(description,0,3);

        gridPane.setHalignment(date, HPos.LEFT);
        gridPane.add(date,0,5);


        gridPane.setHalignment(add, HPos.LEFT);
        gridPane.add(add,1,6);

         root.getChildren().addAll(gridPane);
        this.setScene(scene);
        this.setTitle("Add to Appointment");
        this.show();


    }

    private void add() throws IOException {

        int d = (int) doctor_id.getSelectionModel().getSelectedItem();
        LocalDate localDate = date.getValue();
        Date sqlDate = Date.valueOf(localDate);
        Appointment appointment = new Appointment(
                0,
                id,
                d,
                description.getText(),
                sqlDate


        );

               outStream.writeObject("Add Appointment");


               outStream.writeObject(appointment);

        ShowAlert showAlert = new ShowAlert();
        this.close();
        showAlert.showSimpleAlert("Success","Appointment Successfully Added");

    }


}

