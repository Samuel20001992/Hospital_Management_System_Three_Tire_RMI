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

public class ReadFile extends Stage {

    File file;

    public ReadFile() {

        String id = null;
        String[] data = new String[0];

        file = new File(id + ".txt");

        if (file.exists()) {
            try {
                Scanner input = new Scanner(file);
                int i = 0;
                while (input.hasNextLine()) {
                    data[i] = input.nextLine();
                    i++;

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();


            }
        }
    }
}