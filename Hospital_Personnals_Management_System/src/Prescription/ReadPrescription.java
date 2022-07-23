package Prescription;


import DataTypes.Patient;
import DataTypes.Prescription;
import Delete.DeletePerscription;
import Edit.EditPerscription;
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


public class ReadPrescription extends Stage {

    private  ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    TableView<Prescription> PrescriptionTable;
    ObservableList<Prescription> Prescriptions;

    TextField txtSearch;
    Button btnSearch;
    private final ComboBox<String> comboBox;

    public ReadPrescription(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {


     //   this.socket = socket;
        this.inStream = inStream;
        this.outStream = outStream;

        ContextMenu contextMenu = new ContextMenu();
        MenuItem edit = new MenuItem("Edit");
        edit.setOnAction(e->{
            ObservableList<Prescription> prescription = PrescriptionTable.getItems();
            System.out.println(prescription.get(0).getId());
            EditPerscription edit_perscription = new EditPerscription(
                    prescription.get(0).getId(),
                    prescription.get(0).getPatient_id(),
                    prescription.get(0).getDoctor_id(),
                    prescription.get(0).getMedicines(),
                    prescription.get(0).getIssuedDate(),
                    prescription.get(0).getDeadline(), socket,  inStream,  outStream

            );
            edit_perscription.edit_prescription_main();
        });
        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(e->{
            ObservableList<Prescription> prescription = PrescriptionTable.getItems();
            DeletePerscription deletePerscription = new DeletePerscription(prescription.get(0).getId(), socket,  inStream,  outStream);
            try {
                deletePerscription.delete_prescripiton_main();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

       contextMenu.getItems().addAll(edit,delete);




        VBox root = new VBox();
        comboBox = new ComboBox<>();
        txtSearch = new TextField();
        btnSearch = new Button("Search");
        PrescriptionTable = new TableView<>();
        HBox form = new HBox();



      ComboBox comboBoxItems = new ComboBox();
        comboBoxItems.getItems().addAll("id","patient_id","doctor_id","medicines","issued_date","deadline");

        createColumns();

        form.getChildren().addAll(comboBoxItems,txtSearch,btnSearch);

        Prescriptions = FXCollections.observableArrayList();
        PrescriptionTable.setItems(Prescriptions);

        new Thread(()->{

            List<Prescription> PrescriptionList = null;
            try {
                PrescriptionList = (List<Prescription>) inStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Prescriptions.addAll(PrescriptionList);
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
                List<Prescription> prescriptionList = null;
                try {
                    outStream.writeObject("Search Prescription");
                    outStream.writeObject(search);
                    prescriptionList = (List<Prescription>) inStream.readObject();
                    prescriptionList.forEach(System.out::println);
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }
                Prescriptions.clear();
                Prescriptions.addAll(prescriptionList);
            }).start();





        });

        root.getChildren().addAll(
                form, PrescriptionTable
        );

        Scene scene = new Scene(root,780,600);
        PrescriptionTable.setContextMenu(contextMenu);

        setResizable(false);
        scene.getStylesheets().add("style.css");
        this.setTitle("List of Prescriptions");
        this.setScene(scene);


    }

    private void createColumns() {
        TableColumn<Prescription,Integer> idColumn = new TableColumn<>("Id");
        TableColumn<Prescription,Integer> patientIdColumn = new TableColumn<>("Patient Id");
        TableColumn<Prescription,Integer> doctorColumn = new TableColumn<>("Doctor Id");
        TableColumn<Prescription,String> medicinesColumn = new TableColumn<>("Medicines");
        TableColumn<Prescription,Date> deadlineColumn = new TableColumn<>("Deadline");
        TableColumn<Prescription,Date> issuedDateColumn = new TableColumn<>("Issued Date");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
        doctorColumn.setCellValueFactory(new PropertyValueFactory<>("doctor_id"));
        medicinesColumn.setCellValueFactory(new PropertyValueFactory<>("medicines"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        issuedDateColumn.setCellValueFactory(new PropertyValueFactory<>("issuedDate"));






        PrescriptionTable.getColumns().addAll(
                idColumn,
                patientIdColumn,
                doctorColumn,
                medicinesColumn,

                issuedDateColumn,
                deadlineColumn
        );

        PrescriptionTable.getColumns().forEach(col->{
            col.setMinWidth(130);
        });
    }
}
