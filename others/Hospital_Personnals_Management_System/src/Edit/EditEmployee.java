package Edit;

import Alert.ShowAlert;
import DataTypes.Employee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;

public class EditEmployee {
    private final int id;

    Stage primaryStage = new Stage();
    GridPane gridPane = new GridPane();
    VBox vBox = new VBox(gridPane);
    JFXTextField firstNameFld = new JFXTextField();
    JFXTextField middleNameFld = new JFXTextField();
    JFXTextField lastNameFld = new JFXTextField();
    JFXTextField sexFld = new JFXTextField();
    JFXTextField ageFld = new JFXTextField();
    JFXTextField phoneNumberFld = new JFXTextField();
    JFXTextField emailFld = new JFXTextField();
    JFXTextField addressFld = new JFXTextField();
    JFXTextField hiredDateFld = new JFXTextField();
    ComboBox jobStatusFld = new ComboBox();
    JFXTextField salaryFld = new JFXTextField();
    JFXTextField departmentFld = new JFXTextField();

    JFXTextField imageNameFld = new JFXTextField();

   public void edit_employee_main()
   {
       Scene scene = new Scene(new ScrollPane(vBox),600,600);
       primaryStage.setScene(scene);
       scene.getStylesheets().add("style.css");
       primaryStage.show();
   }
    public EditEmployee(int id, String firstName, String middleName, String lastName, String sex, int age, int phoneNumber,
                        String email, String address, Date hiredDate, int salary, String jobType, int departmentId,
                        String imageAddress){


        this.id =  id;

        gridPane.setPadding(new Insets(20));

        ColumnConstraints column1 = new ColumnConstraints(300);
        gridPane.getColumnConstraints().add(column1);
        gridPane.setVgap(10);
        gridPane.setHgap(10);


        JFXButton back = new JFXButton("<< Back");
        gridPane.add(back,0,0);

        firstNameFld.setPromptText("FIRST NAME");
        gridPane.setHalignment(firstNameFld, HPos.LEFT);
        gridPane.add(firstNameFld,0,3);
        firstNameFld.setLabelFloat(true);
        firstNameFld.setMinWidth(400);
        firstNameFld.setText(firstName);

        middleNameFld.setPromptText("MIDDLE NAME");
        gridPane.setHalignment(middleNameFld, HPos.LEFT);
        gridPane.add(middleNameFld,0,5);
        middleNameFld.setLabelFloat(true);
        middleNameFld.setMinWidth(400);
        middleNameFld.setText(middleName);

        lastNameFld.setPromptText("LAST NAME");
        gridPane.setHalignment(lastNameFld, HPos.LEFT);
        gridPane.add(lastNameFld,0,7);
        lastNameFld.setLabelFloat(true);
        lastNameFld.setMinWidth(400);
        lastNameFld.setText(lastName);

        sexFld.setPromptText("SEX");
        gridPane.setHalignment(sexFld, HPos.LEFT);
        gridPane.add(sexFld,0,9);
        sexFld.setLabelFloat(true);
        sexFld.setMinWidth(400);
        sexFld.setText(sex);

        ageFld.setPromptText("AGE");
        gridPane.setHalignment(ageFld, HPos.LEFT);
        gridPane.add(ageFld,0,11);
        ageFld.setLabelFloat(true);
        ageFld.setMinWidth(400);
        ageFld.setText(String.valueOf(age));

        phoneNumberFld.setPromptText("PHONE NUMBER");
        gridPane.setHalignment(phoneNumberFld, HPos.LEFT);
        gridPane.add(phoneNumberFld,0,13);
        phoneNumberFld.setLabelFloat(true);
        phoneNumberFld.setMinWidth(400);
        phoneNumberFld.setText(String.valueOf(phoneNumber));

        emailFld.setPromptText("EMAIL ADDRESS");
        gridPane.setHalignment(emailFld, HPos.LEFT);
        gridPane.add(emailFld,0,15);
        emailFld.setLabelFloat(true);
        emailFld.setMinWidth(400);
        emailFld.setText(email);

        addressFld.setPromptText("HOME ADDRESS");
        gridPane.setHalignment(addressFld, HPos.LEFT);
        gridPane.add(addressFld,0,17);
        addressFld.setLabelFloat(true);
        addressFld.setMinWidth(400);
        addressFld.setText(address);

        hiredDateFld.setPromptText("HIRED DATE");
        gridPane.setHalignment(hiredDateFld, HPos.LEFT);
        gridPane.add(hiredDateFld,0,19);
        hiredDateFld.setPromptText("Hired Date");
        hiredDateFld.setMinWidth(400);
        hiredDateFld.setText(String.valueOf(hiredDate));


        jobStatusFld.setPromptText("JOB STATUS");
        gridPane.setHalignment(jobStatusFld, HPos.LEFT);
        jobStatusFld.getItems().addAll("Adminstration","Doctor","Nurse","Pharmacist","Registration");
        gridPane.add(jobStatusFld,0,21);
        jobStatusFld.setMinWidth(400);


        salaryFld.setPromptText("SALARY");
        gridPane.setHalignment(salaryFld, HPos.LEFT);
        gridPane.add(salaryFld,0,23);
        salaryFld.setLabelFloat(true);
        salaryFld.setMinWidth(400);
        salaryFld.setText(String.valueOf(salary));

        departmentFld.setPromptText("DEPARTMENT");
        gridPane.setHalignment(departmentFld, HPos.LEFT);
        gridPane.add(departmentFld,0,25);
        departmentFld.setLabelFloat(true);
        departmentFld.setMinWidth(400);
        departmentFld.setText(String.valueOf(departmentId));

        imageNameFld.setPromptText("DEPARTMENT");
        gridPane.setHalignment(imageNameFld, HPos.LEFT);
        gridPane.add(imageNameFld,0,25);
        imageNameFld.setLabelFloat(true);
        imageNameFld.setMinWidth(400);
        imageNameFld.setText(imageAddress);

        GridPane root = new GridPane();
        ColumnConstraints column2 = new ColumnConstraints(100);
        root.getColumnConstraints().add(column2);
        root.setHgap(120);
        root.setVgap(10);

        JFXButton submit = new JFXButton("ADD");
        GridPane.setHalignment(submit, HPos.LEFT);
        root.add(submit,0,0);
        submit.setPadding(new Insets(10));
        submit.setMinWidth(180);
        submit.setOnAction(e->{
            try {
                edit();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        JFXButton cancel = new JFXButton("CANCEL");
        GridPane.setHalignment(cancel, HPos.LEFT);
        root.add(cancel,1,0);
        cancel.setMinWidth(180);
        cancel.setPadding(new Insets(10));

        gridPane.add(root,0,26);


    }

    public void edit() throws IOException {


        if(firstNameFld.getText()==""||middleNameFld.getText()==""||lastNameFld.getText()==""
                ||sexFld.getText() == ""||ageFld.getText()==""||phoneNumberFld.getText()==""||addressFld.getText()==""
                ||salaryFld.getText()==""||jobStatusFld.getSelectionModel().getSelectedItem() ==""
        )
        {
            ShowAlert showAlert = new ShowAlert();
            showAlert.showErrorMessage("Error","Error while editing employee","one or more empty fileds");
            return;
        }

        String firstName = firstNameFld.getText();
        String middleName = middleNameFld.getText();
        String lastName = lastNameFld.getText();
        String sex = sexFld.getText();
        int age = Integer.parseInt(ageFld.getText());
        int phoneNumber = Integer.parseInt(phoneNumberFld.getText());
        String email = emailFld.getText();
        String address = addressFld.getText();
        int salary = Integer.parseInt(salaryFld.getText());
        String jobType = String.valueOf(jobStatusFld.getSelectionModel().getSelectedItem());
        int departmentId = Integer.parseInt(departmentFld.getText());
        String imageAddress = imageNameFld.getText();
       Employee employee = new Employee(
               0,
               firstName,
               middleName,
               lastName,
               sex,
               age,
               phoneNumber,
               email,
               address,
               null,
               salary,
               jobType,
               departmentId,
               imageAddress
       );


       primaryStage.close();
        ShowAlert showAlert = new ShowAlert();
        showAlert.showSimpleAlert("Success","Employee Successfully Editted");

    }
}
