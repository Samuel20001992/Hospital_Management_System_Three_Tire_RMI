package Edit;

import Alert.ShowAlert;
import DataTypes.Prescription;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;

public class EditPerscription {
    private final int id;
    private final Date issuedDate;
    private final Date deadline;
    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;
    private JFXTextField idfld = new JFXTextField();
    private JFXTextField dIdfld = new JFXTextField();
    private JFXTextField medicinefld = new JFXTextField();
    private JFXTextField issuedDatefld = new JFXTextField();
    private JFXTextField expiryDatefld = new JFXTextField();
    private JFXButton cancel;
    private JFXButton edit;
    GridPane gridPane = new GridPane();
    Stage primaryStage = new Stage();
public void edit_prescription_main()
{
    if(primaryStage.isShowing()){
        primaryStage.close();
    }
    Scene scene = new Scene(gridPane,600,600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Update Prescription");
    scene.getStylesheets().add("style.css");
    primaryStage.show();
}


    public EditPerscription(int id, int patient_id, int doctor_id, String medicines, Date issuedDate, Date deadline, Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        this.inStream = inStream;
        this.outStream = outStream;
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

        idfld.setLabelFloat(true);
        idfld.setPromptText("Perscription id");
        root.add(idfld,0,1);
        idfld.setText(String.valueOf(patient_id));


        dIdfld.setPromptText("Doctor id");
        dIdfld.setLabelFloat(true);
        root.add(dIdfld,0,6);
        dIdfld.setText(String.valueOf(doctor_id));

        medicinefld.setLabelFloat(true);
        medicinefld.setPromptText("Medicine");
        root.add(medicinefld,0,10);
        medicinefld.setText(medicines);

        issuedDatefld.setPromptText("Issued Date");
        issuedDatefld.setLabelFloat(true);
        root.add(issuedDatefld,0,14);
        issuedDatefld.setText(String.valueOf(issuedDate));

        expiryDatefld.setPromptText("Expiry Date");
        expiryDatefld.setLabelFloat(true);
        root.add(expiryDatefld,0,18);
        expiryDatefld.setText(String.valueOf(deadline));

        edit = new JFXButton("Update");
        edit.setMinWidth(150);
        edit.setMinHeight(40);
        GridPane.setHalignment(edit, HPos.CENTER);
        root1.add(edit,0,0);
         edit.setOnAction(e->{
             try {
                 edit();
             } catch (IOException ioException) {
                 ioException.printStackTrace();
             }
         });

        cancel = new JFXButton("Cancel");
        cancel.setMinWidth(150);
        cancel.setMinHeight(40);
        GridPane.setHalignment(cancel,HPos.LEFT);
        root1.add(cancel,1,0);

        VBox vBox2 = new VBox(root1);
        vBox2.setMaxWidth(600);
        vBox2.setPadding(new Insets(3));


        root.add(vBox2,0,22);

        VBox vBox = new VBox(root);
        vBox.setMaxWidth(600);
        vBox.setPadding(new Insets(10));

        gridPane.addColumn(0,vBox);


            this.id= id;
        System.out.println(id);
            this.issuedDate= issuedDate;
            this.deadline = deadline;
    }

    private void edit() throws IOException {
        if(idfld.getText()==""||dIdfld.getText()==""||medicinefld.getText()=="")
        {
            ShowAlert showAlert = new ShowAlert();
            showAlert.showErrorMessage("Error","Error while editing perscription","one or more empty fileds");
            return;
        }
        int patient_id = Integer.parseInt(idfld.getText());
        int doctor_id = Integer.parseInt(dIdfld.getText());
        String medicines = medicinefld.getText();


        Prescription prescription = new Prescription(
                this.id,
                patient_id,
                doctor_id,
                medicines,
                this.issuedDate,
                this.deadline
        );
        outStream.writeObject("Edit Prescription");
        outStream.writeObject(id);
        outStream.writeObject(prescription);
        primaryStage.close();
        ShowAlert showAlert = new ShowAlert();
        showAlert.showSimpleAlert("Success","Prescription Successfully Editted");

    }
}
