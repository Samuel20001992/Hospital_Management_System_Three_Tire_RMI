package Patient;

import Alert.ShowAlert;
import DataTypes.Patient;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddPatient {
    public static AnchorPane anchorPane;
   public static GridPane gridPane = new GridPane();
    static Stage stage = new Stage();
    private static JFXTextField firstNameFld = new JFXTextField();
    private static JFXTextField middleNameFld = new JFXTextField();
    private static JFXTextField lastNameFld = new JFXTextField();
    private static JFXTextField sexFld = new JFXTextField();
    private static JFXTextField ageFld = new JFXTextField();
    private static JFXTextField phoneNumberFld = new JFXTextField();
    private static JFXTextField addressFld = new JFXTextField();
    private static JFXButton submitBtn = new JFXButton("ADD");
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    private Socket socket;

    ShowAlert showAlert = new ShowAlert();
    public static void add_patient_main()
{


    VBox vBox = new VBox(gridPane);
    Scene scene = new Scene(vBox, 450, 530);
    stage.setScene(scene);
    scene.getStylesheets().add("style.css");
    stage.setTitle("Add Patient");
    stage.show();
}
    public AddPatient(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
      if( stage.isShowing())
      {
          stage.close();
      }
        this.socket = socket;
        this.inStream = inStream;
        this.outStream = outStream;

        GridPane root = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints(150);
        root.getColumnConstraints().addAll(column1);
        root.setPadding(new Insets(20));
        root.setHgap(30);
        root.setVgap(10);


        firstNameFld.setPromptText("FIRST NAME");
        root.setHalignment(firstNameFld, HPos.LEFT);
        root.add(firstNameFld,0,3);
        firstNameFld.setLabelFloat(true);
        firstNameFld.setMinWidth(400);

        middleNameFld.setPromptText("MIDDLE NAME");
        root.setHalignment(middleNameFld, HPos.LEFT);
        root.add(middleNameFld,0,5);
        middleNameFld.setLabelFloat(true);
        middleNameFld.setMinWidth(400);

        lastNameFld.setPromptText("LAST NAME");
        root.setHalignment(lastNameFld, HPos.LEFT);
        root.add(lastNameFld,0,7);
        lastNameFld.setLabelFloat(true);
        lastNameFld.setMinWidth(400);

        sexFld.setPromptText("SEX");
        root.setHalignment(sexFld, HPos.LEFT);
        root.add(sexFld,0,9);
        sexFld.setLabelFloat(true);
        sexFld.setMinWidth(400);

        ageFld.setPromptText("AGE");
        root.setHalignment(ageFld, HPos.LEFT);
        root.add(ageFld,0,11);
        ageFld.setLabelFloat(true);
        ageFld.setMinWidth(400);

        phoneNumberFld.setPromptText("PHONE NUMBER");
        root.setHalignment(phoneNumberFld, HPos.LEFT);
        root.add(phoneNumberFld,0,13);
        phoneNumberFld.setLabelFloat(true);
        phoneNumberFld.setMinWidth(400);

        addressFld.setPromptText("HOME ADDRESS");
        root.setHalignment(addressFld, HPos.LEFT);
        root.add(addressFld,0,17);
        addressFld.setLabelFloat(true);
        addressFld.setMinWidth(400);



        root.setHalignment(submitBtn, HPos.LEFT);
        root.add(submitBtn,0,21);
        submitBtn.setPadding(new Insets(10));
        submitBtn.setMinWidth(200);

        submitBtn.setOnAction(e->{
            try {
                add_patient();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        JFXButton cancel = new JFXButton("Cancel");
        root.setHalignment(cancel, HPos.LEFT);
        root.add(cancel,1,21);
        cancel.setMinWidth(200);
        cancel.setPadding(new Insets(10));
        cancel.setOnAction(event -> {
            stage.close();
        });



        VBox vBox = new VBox(root);
        vBox.setMaxWidth(600);
        vBox.setPadding(new Insets(10));




        gridPane.addColumn(0,vBox);

    }
          private void reset()
          {
              firstNameFld.setText("");
              middleNameFld.setText("");
              lastNameFld.setText("");
              sexFld.setText("");
              ageFld.setText("");
              phoneNumberFld.setText("");
              addressFld.setText("");



          }
    private void add_patient() throws IOException {
        if(firstNameFld.getText()==""||lastNameFld.getText()==""
                ||sexFld.getText() == ""||ageFld.getText()==""||phoneNumberFld.getText()==""||addressFld.getText()==""
        )
        {
            ShowAlert showAlert = new ShowAlert();
            showAlert.showErrorMessage("Error","Error while adding patient","one or more empty fileds");
            return;
        }




        Pattern pattern = Pattern.compile("[A-z]+");
        Pattern pattern1 = Pattern.compile("[0-9]+");
        Pattern pattern2 = Pattern.compile("[A-z 0-9]");

        Matcher fname = pattern.matcher(firstNameFld.getText());
        Matcher mname = pattern.matcher(middleNameFld.getText());
        Matcher lname = pattern.matcher(lastNameFld.getText());
        Matcher s_e_x = pattern.matcher(sexFld.getText());
        Matcher a_g_e = pattern1.matcher(ageFld.getText());
        Matcher pnumber = pattern1.matcher(phoneNumberFld.getText());

        if(fname.matches()) {
                if(lname.matches()) {
                    if(s_e_x.matches()) {
                        if(a_g_e.matches()) {
                            if(pnumber.matches()) {

                            }
                            else {
                                showAlert.showErrorMessage("Error", "Wrong data entry!","First name entry");
                                return;
                            }
                        }
                        else {
                            showAlert.showErrorMessage("Error", "Wrong data entry!","First name entry");
                            return;
                        }
                    }
                    else {
                        showAlert.showErrorMessage("Error", "Wrong data entry!","First name entry");
                        return;
                    }
                }
                else {
                    showAlert.showErrorMessage("Error", "Wrong data entry!","First name entry");
                    return;
                }

        }
        else {
            showAlert.showErrorMessage("Error", "Wrong data entry!","First name entry");
            return;
        }


        String firstName = firstNameFld.getText();
        String middleName = middleNameFld.getText();
        String lastName = lastNameFld.getText();
        String   sex = sexFld.getText();
        int age = Integer.parseInt(ageFld.getText());
        int phoneNumber = Integer.parseInt(phoneNumberFld.getText());
        String address = addressFld.getText();
        Date regDate =null;
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
        try {
            outStream.writeObject("Add Patient");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        outStream.writeObject(patient);
          reset();
    }
}