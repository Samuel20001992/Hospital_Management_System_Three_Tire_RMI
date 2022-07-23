package FileHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class AddToFile extends Stage {
    JFXTextField patientId ;
    JFXTextField date ;
    JFXTextField doctorId;
    JFXTextArea newTextArea;

    public AddToFile(String d)
    {



            Group root = new Group();

            patientId = new JFXTextField();
            patientId.setPromptText("patient");
            doctorId = new JFXTextField();
            doctorId.setPromptText("doctor");
            date = new JFXTextField();
            date.setPromptText("date");
            newTextArea = new JFXTextArea();
            newTextArea.setPromptText("new dignosis");
            JFXButton submit = new JFXButton("Add");
            submit.setOnAction(e->{
                try {
                    String pId = patientId.getText();
                    String dId = doctorId.getText();
                    String dateString = date.getText();
                    String dignosis =  newTextArea.getText();

                    String array[] =  {pId,dId,dateString,dignosis};


                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            });
            GridPane gridPane = new GridPane();
            gridPane.setVgap(10);
            gridPane.setHgap(10);
            gridPane.setPadding(new Insets(10));
            GridPane.setHalignment(patientId, HPos.LEFT);
            gridPane.add(patientId, 0, 0);

            GridPane.setHalignment(doctorId, HPos.LEFT);
            gridPane.add(doctorId, 0, 3);

            GridPane.setHalignment(date, HPos.LEFT);
            gridPane.add(date, 0, 6);

            GridPane.setHalignment(newTextArea, HPos.LEFT);
            gridPane.add(newTextArea, 0, 9);

            GridPane.setHalignment(submit, HPos.LEFT);
            gridPane.add(submit, 0, 12);


            root.getChildren().add(gridPane);
            Scene scene = new Scene(root,500,500);
            scene.getStylesheets().add("style.css");
            this.setScene(scene);

    }

}
