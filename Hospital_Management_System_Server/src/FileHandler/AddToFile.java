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

public class AddToFile extends Thread {


    private  File file;
    private  ObjectInputStream inStream;
    private  ObjectOutputStream outStream;

    public AddToFile(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        this.inStream = inStream;
        this.outStream = outStream;
        int id = (int) inStream.readObject();
        String d = (String) inStream.readObject();
        String[] i = (String[]) inStream.readObject();


        file = new File( "ID"+ " " + id + " " + "First Name" + " " + d + ".txt");
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

    }
}
