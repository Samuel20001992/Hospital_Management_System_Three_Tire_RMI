package Employee;


import Alert.ShowAlert;
import DataTypes.Employee;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.plugin.dom.html.HTMLBodyElement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEmployee   {


    public static GridPane gridPane = new GridPane();

    private static JFXPasswordField password = new JFXPasswordField();

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

    JFXTextField imageAddressFld = new JFXTextField();
    private InetAddress host;
    static Stage stage = new Stage();

    ShowAlert showAlert = new ShowAlert();
    public static void add_employee_main() {


        VBox vBox = new VBox(gridPane);
        Scene scene = new Scene(new ScrollPane(vBox), 450, 700);
        stage.setScene(scene);
        stage.setTitle("Add Employee");
        System.out.println("add employee before");
        stage.show();
        System.out.println("add employee after");
    }

    public AddEmployee() {

        gridPane.setPadding(new Insets(20));
        System.out.println("add employee");
        ColumnConstraints column1 = new ColumnConstraints(300);
        gridPane.getColumnConstraints().add(column1);
        gridPane.setVgap(10);
        gridPane.setHgap(10);


        firstNameFld.setPromptText("FIRST NAME");
        gridPane.setHalignment(firstNameFld, HPos.LEFT);
        gridPane.add(firstNameFld, 0, 3);
        firstNameFld.setLabelFloat(true);
        firstNameFld.setMinWidth(400);

        middleNameFld.setPromptText("MIDDLE NAME");
        gridPane.setHalignment(middleNameFld, HPos.LEFT);
        gridPane.add(middleNameFld, 0, 5);
        middleNameFld.setLabelFloat(true);
        middleNameFld.setMinWidth(400);


        lastNameFld.setPromptText("LAST NAME");
        gridPane.setHalignment(lastNameFld, HPos.LEFT);
        gridPane.add(lastNameFld, 0, 7);
        lastNameFld.setLabelFloat(true);
        lastNameFld.setMinWidth(400);


        sexFld.setPromptText("SEX");
        gridPane.setHalignment(sexFld, HPos.LEFT);
        gridPane.add(sexFld, 0, 9);
        sexFld.setLabelFloat(true);
        sexFld.setMinWidth(400);


        ageFld.setPromptText("AGE");
        gridPane.setHalignment(ageFld, HPos.LEFT);
        gridPane.add(ageFld, 0, 11);
        ageFld.setLabelFloat(true);
        ageFld.setMinWidth(400);


        phoneNumberFld.setPromptText("PHONE NUMBER");
        gridPane.setHalignment(phoneNumberFld, HPos.LEFT);
        gridPane.add(phoneNumberFld, 0, 13);
        phoneNumberFld.setLabelFloat(true);
        phoneNumberFld.setMinWidth(400);


        emailFld.setPromptText("EMAIL ADDRESS");
        gridPane.setHalignment(emailFld, HPos.LEFT);
        gridPane.add(emailFld, 0, 15);
        emailFld.setLabelFloat(true);
        emailFld.setMinWidth(400);


        addressFld.setPromptText("HOME ADDRESS");
        gridPane.setHalignment(addressFld, HPos.LEFT);
        gridPane.add(addressFld, 0, 17);
        addressFld.setLabelFloat(true);
        addressFld.setMinWidth(400);





        jobStatusFld.setPromptText("JOB STATUS");
        jobStatusFld.getItems().addAll("Adminstration","Doctor","Nurse","Pharmacist","Registration");
        gridPane.setHalignment(jobStatusFld, HPos.LEFT);
        gridPane.add(jobStatusFld, 0, 19);
        jobStatusFld.setMinWidth(400);


        salaryFld.setPromptText("SALARY");
        gridPane.setHalignment(salaryFld, HPos.LEFT);
        gridPane.add(salaryFld, 0, 21);
        salaryFld.setLabelFloat(true);
        salaryFld.setMinWidth(400);


        departmentFld.setPromptText("DEPARTMENT");
        gridPane.setHalignment(departmentFld, HPos.LEFT);
        gridPane.add(departmentFld, 0, 23);
        departmentFld.setLabelFloat(true);
        departmentFld.setMinWidth(400);


        imageAddressFld.setPromptText("IMAGE ADDRESS");
        gridPane.setHalignment(imageAddressFld, HPos.LEFT);
        gridPane.add(imageAddressFld, 0, 25);
        imageAddressFld.setLabelFloat(true);
        imageAddressFld.setMinWidth(400);


        password.setPromptText("PASSWORD");
        gridPane.setHalignment(password, HPos.LEFT);
        gridPane.add(password, 0, 27);
        password.setLabelFloat(true);
        password.setMinWidth(400);

        GridPane root = new GridPane();
        ColumnConstraints column2 = new ColumnConstraints(100);
        root.getColumnConstraints().add(column2);
        root.setHgap(120);
        root.setVgap(10);

        JFXButton submit = new JFXButton("ADD");
        GridPane.setHalignment(submit, HPos.LEFT);
        root.add(submit, 0, 0);
        submit.setPadding(new Insets(10));
        submit.setMinWidth(180);

        submit.setOnAction(e -> {
            try {
                add_employee();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        JFXButton cancel = new JFXButton("CANCEL");
        GridPane.setHalignment(cancel, HPos.LEFT);
        root.add(cancel, 1, 0);
        cancel.setMinWidth(180);
        cancel.setPadding(new Insets(10));
        cancel.setOnAction(event -> {
            stage.close();
        });


        gridPane.add(root, 0, 30);

    }

    private void add_employee() throws IOException {

        if(firstNameFld.getText()==""||middleNameFld.getText()==""||lastNameFld.getText()==""
                ||sexFld.getText() == ""||ageFld.getText()==""||phoneNumberFld.getText()==""||addressFld.getText()==""
                ||salaryFld.getText()==""||jobStatusFld.getSelectionModel().getSelectedItem() ==""||password.getText()==""
        )
        {
            ShowAlert showAlert = new ShowAlert();
            showAlert.showErrorMessage("Error","Error while adding employee","one or more empty fileds");
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
        Date hiredDate = null;
        int salary = Integer.parseInt(salaryFld.getText());
        String jobType = String.valueOf(jobStatusFld.getSelectionModel().getSelectedItem());
        int departmentId = Integer.parseInt(departmentFld.getText());
        String imageAddress = imageAddressFld.getText();
        String passwordd = password.getText();



        if() {
                if() {
                    if() {
                        if() {
                            if() {
                                if() {
                                    if(){
                                        if (){
                                            if ()){
                                                if(){
                                                if() {

                                                }
                                                else {
                                                    showAlert.showErrorMessage("Error", "Wrong data entry!","Middlename entry");
                                                    return;
                                                }
                                                }

                                            }
                                            else {
                                                showAlert.showErrorMessage("Error", "Wrong data entry!","Department entry");
                                                return;
                                            }
                                        }
                                        else {
                                            showAlert.showErrorMessage("Error", "Wrong data entry!","Salary entry");
                                            return;
                                        }
                                    }
                                    else {
                                        showAlert.showErrorMessage("Error", "Wrong data entry!","Email entry");
                                        return;
                                    }
                                }
                                else {
                                    showAlert.showErrorMessage("Error", "Wrong data entry!","Address entry");
                                    return;
                                }
                            }
                            else {
                                showAlert.showErrorMessage("Error", "Wrong data entry!","Phone number entry");
                                return;
                            }
                        }
                        else {
                            showAlert.showErrorMessage("Error", "Wrong data entry!","Age entry");
                            return;
                        }
                    }
                    else {
                        showAlert.showErrorMessage("Error", "Wrong data entry!","Sex entry");
                        return;
                    }
                }
                else {
                    showAlert.showErrorMessage("Error", "Wrong data entry!","Last name entry");
                    return;
                }
        }
        else {
            showAlert.showErrorMessage("Error", "Wrong data entry!","First name entry");
            return;
        }




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


        stage.close();
        ShowAlert showAlert = new ShowAlert();
        showAlert.showSimpleAlert("Success","Employee Successfully Added");

    }
}
