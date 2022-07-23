package FileHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReadFile extends  Stage{
    private  String x;
    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    File file;
    JFXTextArea previousDignosis;
    private int id;

    public ReadFile(int id, String x, Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        this.inStream = inStream;
        this.outStream = outStream;
       this.id = id;
       this.x = x;

        String d = String.valueOf(id);
        previousDignosis =  new JFXTextArea();
        previousDignosis.setMinHeight(200);
        previousDignosis.setMinWidth(200);

        new Thread(()->{
            try {
                outStream.writeObject("Read Dignosis");
                outStream.writeObject(id);
                outStream.writeObject(x);
                String file[] = (String[]) inStream.readObject();
                for (int i = 0; i < file.length; i++) {
                    System.out.println(file[i]);
                }
                if(file!=null) {
                    Platform.runLater(()->{
                        for (int i = 0; i < file.length; i++) {
                            previousDignosis.appendText(file[i] + "\n");
                        }
                    });
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


        Group root = new Group();
        JFXButton add = new JFXButton("Add Dignosis");

        add.setOnAction(e->{

           AddToFile addToFile = new AddToFile(id,x,inStream,outStream);
           addToFile.show();
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
