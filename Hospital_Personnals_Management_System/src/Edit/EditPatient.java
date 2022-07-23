package Edit;

import Alert.ShowAlert;
import DataTypes.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;

public class EditPatient {
    private  int id;
    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    GridPane gridPane = new GridPane();
    Stage primaryStage = new Stage();
    JFXTextField firstNameFld = new JFXTextField();
    JFXTextField middleNameFld = new JFXTextField();
    JFXTextField lastNameFld = new JFXTextField();
    JFXTextField sexFld = new JFXTextField();
    JFXTextField ageFld = new JFXTextField();
    JFXTextField phoneNumberFld = new JFXTextField();
    JFXTextField email = new JFXTextField();
    JFXTextField addressFld = new JFXTextField();
    JFXTextField regDateFld = new JFXTextField();

   public void edit_patient_main()
   {
       if(primaryStage.isShowing()){
           primaryStage.close();
       }
       Scene scene = new Scene(gridPane,600,600);
       primaryStage.setTitle("Update Patient");
       primaryStage.setScene(scene);
       scene.getStylesheets().add("style.css");
       primaryStage.show();
   }


    public EditPatient(int id, String firstName, String middleName, String lastName, String sex, int age, int phoneNumber, String address, Date registrationDate, Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream){
        System.out.println(id);
        this.id = id;
        System.out.println(this.id);
        this.inStream = inStream;
        this.outStream = outStream;

        GridPane root = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints(150);
        root.getColumnConstraints().addAll(column1);
        root.setPadding(new Insets(20));
        root.setHgap(30);
        root.setVgap(10);


        JFXButton back = new JFXButton("<< Back");
        root.add(back,0,0);

        firstNameFld.setPromptText("FIRST NAME");
        root.setHalignment(firstNameFld, HPos.LEFT);
        root.add(firstNameFld,0,3);
        firstNameFld.setLabelFloat(true);
        firstNameFld.setMinWidth(400);
        firstNameFld.setText(firstName);

        middleNameFld.setPromptText("MIDDLE NAME");
        root.setHalignment(middleNameFld, HPos.LEFT);
        root.add(middleNameFld,0,5);
        middleNameFld.setLabelFloat(true);
        middleNameFld.setMinWidth(400);
        middleNameFld.setText(middleName);

        lastNameFld.setPromptText("LAST NAME");
        root.setHalignment(lastNameFld, HPos.LEFT);
        root.add(lastNameFld,0,7);
        lastNameFld.setLabelFloat(true);
        lastNameFld.setMinWidth(400);
        lastNameFld.setText(lastName);

        sexFld.setPromptText("sexFld");
        root.setHalignment(sexFld, HPos.LEFT);
        root.add(sexFld,0,9);
        sexFld.setLabelFloat(true);
        sexFld.setMinWidth(400);
        sexFld.setText(sex);

        ageFld.setPromptText("ageFld");
        root.setHalignment(ageFld, HPos.LEFT);
        root.add(ageFld,0,11);
        ageFld.setLabelFloat(true);
        ageFld.setMinWidth(400);
        ageFld.setText(String.valueOf(age));

        phoneNumberFld.setPromptText("PHONE NUMBER");
        root.setHalignment(phoneNumberFld, HPos.LEFT);
        root.add(phoneNumberFld,0,13);
        phoneNumberFld.setLabelFloat(true);
        phoneNumberFld.setMinWidth(400);
        phoneNumberFld.setText(String.valueOf(phoneNumber));

        addressFld.setPromptText("HOME addressFld");
        root.setHalignment(addressFld, HPos.LEFT);
        root.add(addressFld,0,17);
        addressFld.setLabelFloat(true);
        addressFld.setMinWidth(400);
        addressFld.setText(address);


        regDateFld.setPromptText("REGISTERED DATE");
        root.setHalignment(regDateFld, HPos.LEFT);
        root.add(regDateFld,0,19);
        regDateFld.setLabelFloat(true);
        regDateFld.setMinWidth(400);
        regDateFld.setText(String.valueOf(registrationDate));


        JFXButton submit = new JFXButton("ADD");
        root.setHalignment(submit, HPos.LEFT);
        root.add(submit,0,21);
        submit.setPadding(new Insets(10));
        submit.setMinWidth(200);
        submit.setOnAction(e->{
            try {
                edit();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        JFXButton cancel = new JFXButton("CANCEL");
        root.setHalignment(cancel, HPos.LEFT);
        root.add(cancel,1,21);
        cancel.setMinWidth(200);
        cancel.setPadding(new Insets(10));

        VBox vBox = new VBox(root);
        vBox.setMaxWidth(600);
        vBox.setPadding(new Insets(10));

        gridPane.addColumn(0,vBox);


    }

    private void edit() throws IOException {
        if(firstNameFld.getText()==""||middleNameFld.getText()==""||lastNameFld.getText()==""
                ||sexFld.getText() == ""||ageFld.getText()==""||phoneNumberFld.getText()==""||addressFld.getText()==""
        )
        {
            ShowAlert showAlert = new ShowAlert();
            showAlert.showErrorMessage("Error","Error while editing patient","one or more empty fileds");
            return;
        }
        String firstName = firstNameFld.getText();
        String middleName = middleNameFld.getText();
        String lastName = lastNameFld.getText();
        String   sex = sexFld.getText();
        int age = Integer.parseInt(ageFld.getText());
        int phoneNumber = Integer.parseInt(phoneNumberFld.getText());
        String address = addressFld.getText();
        Date regDate = Date.valueOf(regDateFld.getText());

        Patient patient = new Patient(
                0,
                firstName,
                middleName,
                lastName,
                sex,
                age,
                phoneNumber,
                address,
                regDate
        );

        outStream.writeObject("Edit Patient");
        outStream.writeObject(this.id);
        outStream.writeObject(patient);

        primaryStage.close();
        ShowAlert showAlert = new ShowAlert();
        showAlert.showSimpleAlert("Success","Patient Successfully Editted");


    }
}
