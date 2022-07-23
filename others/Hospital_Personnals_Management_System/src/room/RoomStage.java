package room;

import Appointment.Add_Appointment;
import DataTypes.Patient;
import DataTypes.Room;
import Delete.DeleteAppointment;
import Edit.EmptyRoom;
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
import java.util.LinkedHashMap;
import java.util.List;


public class RoomStage extends Stage {

    TableView<Room> RoomTable;
    ObservableList<Room> Rooms;

    TextField txtSearch;
    Button btnSearch;
    private final ComboBox<String> comboBox;

    public RoomStage(){

        ContextMenu contextMenu = new ContextMenu();
        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(e->{
            ObservableList<Room> rooms = RoomTable.getSelectionModel().getSelectedItems();
            EmptyRoom emptyRoom = null;
            try {
                emptyRoom = new EmptyRoom(rooms.get(0).getId(),rooms.get(0).getPatientId());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                emptyRoom.edit();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });
//
        contextMenu.getItems().addAll(delete);


        VBox root = new VBox();
        comboBox = new ComboBox<>();
        txtSearch = new TextField();
        btnSearch = new Button("Search");
        RoomTable = new TableView<>();
        HBox form = new HBox();


//        comboBoxItems.put("","");
//        comboBoxItems.put("ID",COLUMN_ID);
//        comboBoxItems.put("ROOM NO",COLUMN_ROOM_NO);
//        comboBoxItems.put("PATIENT ID",COLUMN_PATIENT_ID);

        ComboBox comboBoxItems = new ComboBox();
        comboBoxItems.getItems().addAll("id","room_no","patient_id");

        createColumns();

        form.getChildren().addAll(comboBoxItems,txtSearch,btnSearch);

        Rooms = FXCollections.observableArrayList();
        RoomTable.setItems(Rooms);

        new Thread(()->{

            List<Room> RoomList = null;

            Rooms.addAll(RoomList);
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
                List<Room> roomList = null;

                Rooms.clear();
                Rooms.addAll(roomList);
            }).start();

        });

        root.getChildren().addAll(
                form, RoomTable
        );

        Scene scene = new Scene(root,1900,800);

        scene.getStylesheets().add("style.css");

        setResizable(false);

        this.setScene(scene);
        RoomTable.setContextMenu(contextMenu);

    }

    private void createColumns() {
        TableColumn<Room,Integer> idColumn = new TableColumn<>("Id");
        TableColumn<Room,Integer> roomNoColumn = new TableColumn<>("Room No");
        TableColumn<Room,Integer> patientIdColumn = new TableColumn<>("Patient Id");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        roomNoColumn.setCellValueFactory(new PropertyValueFactory<>("roomNo"));





        RoomTable.getColumns().addAll(
                idColumn,
                roomNoColumn,
                patientIdColumn


        );

        RoomTable.getColumns().forEach(col->{
            col.setMinWidth(130);
        });
    }
}
