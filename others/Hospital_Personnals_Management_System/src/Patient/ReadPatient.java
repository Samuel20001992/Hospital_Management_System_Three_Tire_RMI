package Patient;

//import Edit.EditPatient;
import Delete.DeletePatient;
import Edit.EditPatient;
import FileHandler.ReadFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
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
import DataTypes.*;
import Appointment.Add_Appointment;
import room.Add_Room;

public class ReadPatient extends Stage {

    TableView<Patient> patientTable;
    ObservableList<Patient> patients;
    TextField txtSearch;
    Button btnSearch;
    private final ComboBox<String> comboBox;

    public ReadPatient(){
        ContextMenu contextMenu = new ContextMenu();
        MenuItem edit = new MenuItem("Edit");
        edit.setOnAction(e->{

            ObservableList<Patient> patient = patientTable.getItems();
            System.out.println(patient.get(0).getId());
            EditPatient edit_patient = new EditPatient(
                    patient.get(0).getId(),
                    patient.get(0).getFirstName(),
                    patient.get(0).getMiddleName(),
                    patient.get(0).getLastName(),
                    patient.get(0).getSex(),
                    patient.get(0).getAge(),
                    patient.get(0).getPhoneNumber(),
                    patient.get(0).getAddress(),
                    patient.get(0).getRegistrationDate()
            );
            edit_patient.edit_patient_main();

        });
        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(e->{
            ObservableList<Patient> patient = patientTable.getItems();
            DeletePatient deletePatient = new DeletePatient(patient.get(0).getId());
            try {
                deletePatient.delete_patient_main();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        MenuItem dignosis = new MenuItem("Dignosis");
        dignosis.setOnAction(e->{
            ObservableList<Patient> patient = patientTable.getSelectionModel().getSelectedItems();
            ReadFile readFile = null;
            try {
                readFile = new ReadFile(patient.get(0).getId());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            readFile.show();
        });

        MenuItem room = new MenuItem("Add room");
        room.setOnAction(e->{
            ObservableList<Patient> patient = patientTable.getSelectionModel().getSelectedItems();

            Add_Room add_room = new Add_Room(patient.get(0).getId());
            add_room.show();

        });

        MenuItem add_appointment = new MenuItem("Add Appointment");
        add_appointment.setOnAction(e->{
            ObservableList<Patient> patient = patientTable.getSelectionModel().getSelectedItems();
Add_Appointment add_appointment1 = new Add_Appointment(patient.get(0).getId());
add_appointment1.show();

        });
//
        contextMenu.getItems().addAll(edit,delete,add_appointment,room);


        VBox root = new VBox();
        comboBox = new ComboBox<>();
        txtSearch = new TextField();
        btnSearch = new Button("Search");
        patientTable = new TableView<>();
        HBox form = new HBox();

        ComboBox comboBoxItems = new ComboBox();
        comboBoxItems.getItems().addAll("id","first_name","middle_name","last_name","sex","age","phone_number",
                "address","registration_date");


        createColumns();

        form.getChildren().addAll(comboBoxItems,txtSearch,btnSearch);

        patients = FXCollections.observableArrayList();
        patientTable.setItems(patients);

        new Thread(()->{
            List<Patient> patientList = null;

            patients.addAll(patientList);
        }).start();

        btnSearch.setOnAction(e->{
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
                List<Patient> patientList = null;

                patients.clear();
                patients.addAll(patientList);
            }).start();



        });

        root.getChildren().addAll(
                form, patientTable
        );

        Scene scene = new Scene(root,1180,800);
        scene.getStylesheets().add("style.css");
        patientTable.setContextMenu(contextMenu);

        setResizable(false);

        this.setScene(scene);


    }

    private void createColumns() {
        TableColumn<Patient,Integer> idColumn = new TableColumn<>("Id");
        TableColumn<Patient,String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Patient,String> middleNameColumn = new TableColumn<>("Middle Name");
        TableColumn<Patient,String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Patient,String> sexColumn = new TableColumn<>("Sex");
        TableColumn<Patient,Integer> ageColumn = new TableColumn<>("Age");
        TableColumn<Patient,Integer> phoneNumberColumn = new TableColumn<>("Phone Number");
        TableColumn<Patient,String> addressColumn = new TableColumn<>("Address");
        TableColumn<Patient, Date> registrationDateColumn = new TableColumn<>("Registration Date");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleNameColumn.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));






        patientTable.getColumns().addAll(
                idColumn,
                firstNameColumn,
                middleNameColumn,
                lastNameColumn,
                sexColumn,
                ageColumn,
                phoneNumberColumn,
                addressColumn,
                registrationDateColumn

        );

        patientTable.getColumns().forEach(col->{
            col.setMinWidth(130);
        });
    }
}
