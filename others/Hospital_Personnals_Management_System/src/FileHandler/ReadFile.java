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
    JFXTextArea previousDignosis;
    public ReadFile(int x) throws IOException, ClassNotFoundException {

        String d = String.valueOf(x);
        previousDignosis =  new JFXTextArea();
        previousDignosis.setMinHeight(200);
        previousDignosis.setMinWidth(200);

        int i = 0;
       while(file!=null) {

           previousDignosis.appendText(file[i] + "\n");
           i++;
       }
        Group root = new Group();
        JFXButton add = new JFXButton("Add Dignosis");

        add.setOnAction(e->{

            AddToFile addToFileDignosis = new AddToFile(d);
            addToFileDignosis.show();
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        GridPane.setHalignment(previousDignosis, HPos.LEFT);
        gridPane.add(previousDignosis, 0, 0);

        GridPane.setHalignment(add, HPos.LEFT);
        gridPane.add(add, 0, 13);

        root.getChildren().add(gridPane);
        Scene scene = new Scene(root,500,500);
        scene.getStylesheets().add("style.css");
        this.setScene(scene);
    }
}
