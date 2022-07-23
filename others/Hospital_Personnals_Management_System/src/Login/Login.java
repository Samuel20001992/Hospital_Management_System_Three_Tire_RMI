package Login;

//import Navigation.Doctor_Access;
import Alert.ShowAlert;
//import Navigation.Adminstrator_Access;
//import Navigation.Doctor_Access;
//import Navigation.Nurse_Access;
//import Navigation.Pharmacist_Access;
import Navigation.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Optional;


public class Login extends Application {

    String[] array = new String[5];
    private JFXTextField userNamefld;
    private JFXPasswordField passwordfld;
    private JFXButton login;
    private static String pass[];

    public static int []counts;
    public static List doctorsList;

    public static void main(String[] args) {
        launch(args);
    }

    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 400, 250);

        userNamefld = new JFXTextField();
        userNamefld.setMinWidth(250);
        userNamefld.setMinHeight(30);
        userNamefld.setPromptText("User Name");
        userNamefld.setTranslateX(70);
        userNamefld.setTranslateY(80);
        userNamefld.setLabelFloat(true);
        userNamefld.setStyle("-fx-background-color: white");

        passwordfld = new JFXPasswordField();
        passwordfld.setMinWidth(250);
        passwordfld.setMinHeight(30);
        passwordfld.setPromptText("Password");
        passwordfld.setTranslateX(70);
        passwordfld.setTranslateY(140);
        passwordfld.setLabelFloat(true);
        passwordfld.setStyle("-fx-background-color: white");

        login = new JFXButton("Login");
        login.setStyle("-fx-background-color: white");
        login.setMinWidth(70);
        login.setMaxHeight(30);
        login.setTranslateX(160);
        login.setTranslateY(210);
        login.setOnAction(e -> {
            connect();
        });


        root.setStyle("-fx-background-color: indigo");
        root.getChildren().addAll(userNamefld, passwordfld, login);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        primaryStage.setTitle("Login");
        primaryStage.show();


    }

    private void connect() {
        array[0] = userNamefld.getText();
        array[1] = passwordfld.getText();

        switch (pass[0]) {
            case "Success":
                switch (pass[1]) {

                    case "Adminstration":
                        Adminstrator_Access adminstrator_access = new Adminstrator_Access();
                        adminstrator_access.adminstrator_access_main();

                        break;
                       case "Doctor":
                           Doctor_Access doctor_access = new Doctor_Access();
                           doctor_access.doctor_access_main();
                           System.out.println("he is a doctor");
                           break;
                       case "Nurse":
                           Nurse_Access nurse_access = new Nurse_Access();
                           nurse_access.nurse_Access_main();
                           break;
                       case "Pharmacist":
                           Pharmacist_Access pharmacist_access = new Pharmacist_Access();
                           pharmacist_access.pharmacist_access_main();
                           break;
                    case "Registration":
                        Registration_Acess registration_acess = new Registration_Acess();
                        registration_acess.registration_access_main();
                        break;
                    default:
                        break;
                }
                break;
            case "Fail":

                    ShowAlert alert = new ShowAlert();
                    alert.showErrorMessage("ERROR", "PASSWORD OR USER NAME", "WRONG PASSWORD OR USER NAME!");

                    primaryStage.close();
                    break;
               default:
                        System.out.println("something wrong with the connection");
                }


        }
    }

