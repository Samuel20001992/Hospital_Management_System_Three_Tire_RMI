package Appointment;

import DataTypes.Appointment;
import DataTypes.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class AppointmentStage extends Stage {


    TableView<Appointment> appointmentTable;
    ObservableList<Appointment> appointments;

    TextField txtSearch;
    Button btnSearch;
    private final ComboBox<String> comboBox;

    public AppointmentStage() {

        ComboBox comboBoxItems = new ComboBox();
        comboBoxItems.getItems().addAll("id","patient_id","doctor_id","date");
        VBox root = new VBox();
        comboBox = new ComboBox<>();
        txtSearch = new TextField();
        btnSearch = new Button("Search");
        appointmentTable = new TableView<>();


        HBox form = new HBox();
        form.getChildren().addAll(comboBoxItems,txtSearch,btnSearch);

        appointments = FXCollections.observableArrayList();

        btnSearch.setOnAction((ActionEvent e) ->{
            String selectedItem = (String) comboBoxItems.getSelectionModel().getSelectedItem();
            String searchQuery = txtSearch.getText();
            String [] search = {selectedItem,searchQuery};
            if(selectedItem.equals("")) {
                return;
            }

            if(searchQuery.equals("")) {
                System.err.println("Please enter a search query");
                return;
            }


            new Thread(()->{
                List<Appointment> appointmentList = null;

                appointments.clear();
                appointments.addAll(appointmentList);
            }).start();

        });



        new Thread(()->{

            List<Appointment> appointmentList = null;
            try {
                appointmentList = (List<Appointment>) inStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            appointments.addAll(appointmentList);
        }).start();

        appointmentTable.setItems(appointments);


        createColumns();

        root.getChildren().addAll(form,appointmentTable);



        Scene scene = new Scene(root,800,500);
        scene.getStylesheets().add("style.css");

        setResizable(false);
        this.setScene(scene);

    }

    private void createColumns() {
        TableColumn<Appointment,Integer> idColumn = new TableColumn<>("Id");
        TableColumn<Appointment,Integer> patientIdColumn = new TableColumn<>("Patient ID");
        TableColumn<Appointment,Integer> doctorIdColumn = new TableColumn<>("Doctor ID");
        TableColumn<Appointment,String> descriptionColumn = new TableColumn<>("Description");
        TableColumn<Appointment,Date> dateColumn = new TableColumn<>("Date");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        doctorIdColumn.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        appointmentTable.getColumns().addAll(
                idColumn,
                patientIdColumn,
                doctorIdColumn,
                descriptionColumn,dateColumn
        );
    }
}
