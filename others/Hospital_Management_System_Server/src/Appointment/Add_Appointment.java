package Appointment;

import DataTypes.Appointment;
import app.database.models.appointment.AppointmentDao;
import app.database.models.employee.EmployeeDao;
import app.database.models.patient.PatientDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class Add_Appointment  {


    public static void add(Appointment appointment) throws IOException, ClassNotFoundException {
        AppointmentDao appointmentDao = new AppointmentDao();
        appointmentDao.addEntity(appointment);

    }


}

