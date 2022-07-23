package room;

import Alert.ShowAlert;
import DataTypes.Room;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Add_Room extends Stage {
    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    ComboBox room = new ComboBox();
    int id;
    public Add_Room(int patient_id, Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream)
    {

        this.inStream = inStream;
        this.outStream = outStream;
        id = patient_id;
        Group root = new Group();
        Scene scene = new Scene(root,200,300);
        scene.getStylesheets().add("style.css");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));


        room.setPromptText("ROOM NUMBER");
        room.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        room.setMinWidth(150);



        JFXButton add = new JFXButton("ADD");
        add.setMinWidth(150);
         vBox.getChildren().addAll(room,add);
        root.getChildren().addAll(vBox);
        this.setScene(scene);
        this.setTitle("Add to Room");
        this.show();


        add.setOnAction(e->{
            try {
                add();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });


    }

    private void add() throws IOException {
        int room_id = Integer.parseInt(String.valueOf(room.getSelectionModel().getSelectedItem())) ;
        Room room1 = new Room(
                0,
                room_id,
                id
        );
        outStream.writeObject("Add Room");
        outStream.writeObject(room_id);
        outStream.writeObject(room1);
        this.close();
        ShowAlert showAlert = new ShowAlert();
        showAlert.showSimpleAlert("Success","Patient Successfully Added To A Room");
    }

}
