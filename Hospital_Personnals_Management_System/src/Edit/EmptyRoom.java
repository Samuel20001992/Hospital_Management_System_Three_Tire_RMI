package Edit;

import Alert.ShowAlert;
import DataTypes.Employee;
import DataTypes.Room;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;

public class EmptyRoom {

    private  int patientId;
    private  int id;
    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    private Socket socket;

    public EmptyRoom(int i, int id, ObjectInputStream inStream, ObjectOutputStream outStream) throws IOException {

        this.socket = socket;
        this.inStream = inStream;
        this.outStream = outStream;
        this.patientId =  id;
        this.id =  i;
        edit();
    }

    public void edit() throws IOException {

        Room room = new Room(
                0,
                id,
                0
        );
        outStream.writeObject("Update Room");
        outStream.writeObject(id);
        outStream.writeObject(room);

        ShowAlert showAlert = new ShowAlert();
        showAlert.showSimpleAlert("Success","Room Successfully Editted");

    }
}
