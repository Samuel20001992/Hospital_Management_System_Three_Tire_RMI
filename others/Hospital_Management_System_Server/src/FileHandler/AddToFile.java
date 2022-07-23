package FileHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class AddToFile extends Stage {




    public AddToFile() throws IOException, ClassNotFoundException {

        File file = new File(d + ".txt");
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            try {
                fileWriter.write("Date: " + i[0] + "\n");
                fileWriter.write("Patient Id: "+ i[1] + "\n");
                fileWriter.write("Doctor Id: " + i[2] + "\n");
                fileWriter.write("Dignosis: " + i[3] + "\n");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();

        }
    }
}
