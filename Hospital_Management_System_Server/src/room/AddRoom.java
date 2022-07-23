package room;

import DataTypes.Prescription;
import DataTypes.Room;
import app.database.models.room.RoomDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AddRoom extends Thread {
    static ArrayList<Prescription> add_prescription= new ArrayList<Prescription>();
    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;
    private int id;

    public AddRoom(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {
        this.inStream= inStream;
        this.outStream = outStream;

        add_Room();
    }

    private void add_Room() {   try {
        this.id = (int) inStream.readObject();
       RoomDao roomDao= new RoomDao();
        Room room = (Room) inStream.readObject();
        roomDao.updateById(id,room);




    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    }

}
