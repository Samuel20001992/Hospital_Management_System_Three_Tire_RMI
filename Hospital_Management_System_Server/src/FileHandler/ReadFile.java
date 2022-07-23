package FileHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReadFile extends Thread {
    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    File file;
    int id ;
    String x;
    public ReadFile(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        this.inStream = inStream;
        this.outStream = outStream;

        String[] data = new String[0];
        try {
            id = (int) inStream.readObject();
            x = (String) inStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        file = new File( "ID"+ " " + id + " " + "First Name" + " " + x + ".txt");

        if(file.exists()){
            System.out.println("file exists");
            try {
                Scanner input = new Scanner(file);
                int i=0;
                while (input.hasNextLine())
                {
                    data[i] = input.nextLine();
                  i++;

                }
                outStream.writeObject(data);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("file not found");
        }
    }
}
