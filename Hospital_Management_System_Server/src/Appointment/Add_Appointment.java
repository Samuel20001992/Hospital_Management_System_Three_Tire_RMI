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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Add_Appointment  {

    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;


    public Add_Appointment(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) throws IOException, ClassNotFoundException {
        this.inStream= inStream;
        this.outStream = outStream;
        add();
    }

    public void add() throws IOException, ClassNotFoundException {

        Appointment appointment = (Appointment) inStream.readObject();
        AppointmentDao appointmentDao = new AppointmentDao();
        appointmentDao.addEntity(appointment);

    }


}

