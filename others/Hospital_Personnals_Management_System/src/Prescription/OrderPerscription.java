package Prescription;


import Alert.ShowAlert;
import DataTypes.Prescription;
import Login.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderPerscription  {

    private ComboBox idfld = new ComboBox();
    private ComboBox dIdfld = new ComboBox();
    private JFXTextField medicinefld = new JFXTextField();
    private JFXTextField issuedDatefld = new JFXTextField();
    private DatePicker expiryDatefld = new DatePicker();
    private JFXButton cancelBtn;
    private JFXButton perscribeBtn;

public static   GridPane gridPane = new GridPane();
  static Stage stage = new Stage();


    public void order_perscription_main(){
 if (stage.isShowing()) { stage.close();}
      VBox vBox = new VBox(gridPane);
      Scene scene = new Scene(vBox, 450, 450);
      stage.setScene(scene);
        scene.getStylesheets().add("style.css");
      stage.setTitle("Order Prescription");
      stage.show();
  }
 public OrderPerscription(){

      ColumnConstraints column1 = new ColumnConstraints(400);
      gridPane.getColumnConstraints().add(column1);
        gridPane.setHgap(20);
        gridPane.setVgap(10);



        GridPane root = new GridPane();
        ColumnConstraints column2 = new ColumnConstraints(400);
        root.setVgap(10);
        root.getColumnConstraints().add(column2);


        GridPane root1 = new GridPane();
        ColumnConstraints column3 = new ColumnConstraints(200);
        root1.getColumnConstraints().add(column3);

        root1.setVgap(10);
        //root1.setHgap(10);

     idfld.setPromptText("DOCTOR'S ID");

     Login login = new Login();
     int patient = login.counts[4];

     for(int i=1;i<=patient; i++) {
         idfld.getItems().addAll(i);
     }
     idfld.setMinWidth(150);


        dIdfld.setPromptText("Doctor id");
     dIdfld.setPromptText("DOCTOR'S ID");


     int doctor = login.counts[1];

     for(int i=1;i<=doctor; i++) {
         dIdfld.getItems().addAll(i);
     }
     dIdfld.setMinWidth(150);


     dIdfld.setPromptText("Doctor's Id");
     root.add(dIdfld,0,2);

     idfld.setPromptText("Patient's Id");
     root.add(idfld,0,6);

        medicinefld.setLabelFloat(true);
        medicinefld.setPromptText("Medicine");
        root.add(medicinefld,0,10);


        expiryDatefld.setPromptText("Expiry Date");
        root.add(expiryDatefld,0,14);

        perscribeBtn = new JFXButton("Perscribe");
        perscribeBtn.setMinWidth(150);
        perscribeBtn.setMinHeight(40);
        GridPane.setHalignment(perscribeBtn,HPos.CENTER);
        root1.add(perscribeBtn,0,0);
        perscribeBtn.setOnAction(e->{
            try {
                order_prescription();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        cancelBtn = new JFXButton("Cancel");
        cancelBtn.setMinWidth(150);
        cancelBtn.setMinHeight(40);
        cancelBtn.setOnAction(event -> {
            stage.close();
        });
        GridPane.setHalignment(cancelBtn,HPos.LEFT);
        root1.add(cancelBtn,1,0);


        VBox vBox2 = new VBox(root1);
        vBox2.setMaxWidth(600);
        vBox2.setPadding(new Insets(3));


        root.add(vBox2,0,18);

        VBox vBox = new VBox(root);
        vBox.setMaxWidth(600);
        vBox.setPadding(new Insets(10));



        gridPane.addColumn(0,vBox);


    }

    private void order_prescription() throws IOException {

        if(idfld.getSelectionModel().getSelectedItem()==""||dIdfld.getSelectionModel().getSelectedItem()==""||medicinefld.getText()=="")
        {
            ShowAlert showAlert = new ShowAlert();
            showAlert.showErrorMessage("Error","Error while adding perscription","one or more empty fileds");
            return;
        }


         int patient_id = (int) idfld.getSelectionModel().getSelectedItem();
         int doctor_id = (int) dIdfld.getSelectionModel().getSelectedItem();
         String medicines = medicinefld.getText();

        LocalDate localDate = expiryDatefld.getValue();
        Date sqlDate = Date.valueOf(localDate);

        System.out.println(patient_id + doctor_id + medicines);
        Prescription prescription = new Prescription(
                0,
                patient_id,
                doctor_id,
                medicines,
                sqlDate,
                null
        );


        stage.close();
        ShowAlert showAlert = new ShowAlert();
        showAlert.showSimpleAlert("Success","Prescription Successfully Added");

    }
}
