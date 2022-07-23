package Edit;

import DataTypes.Patient;
import DataTypes.Room;
import app.database.models.patient.PatientDao;
import app.database.models.room.RoomDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class UpdateRoom extends Thread {
    static ArrayList<String> edit_patient = new ArrayList<String>();

    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;
    private int id;
    private int patientId;

    public UpdateRoom(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        communication = socket;
        this.inStream= inStream;
        this.outStream = outStream;
        update_room();
    }
    public void update_room(){
        try {

            id = (int) inStream.readObject();
            RoomDao roomDao = new RoomDao();
            Room room = (Room) inStream.readObject();


            roomDao.updateById(id,room);



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
