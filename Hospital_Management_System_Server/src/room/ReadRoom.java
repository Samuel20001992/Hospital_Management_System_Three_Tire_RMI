package room;

import DataTypes.Room;
import app.database.models.room.RoomDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ReadRoom extends Thread{
    static ArrayList<String> read_perscripiton = new ArrayList<String>();
    Socket communication;
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;

    public ReadRoom(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {

        this.inStream= inStream;
        this.outStream = outStream;
        read_Room();
    }

    private void read_Room() {   try {

        RoomDao roomDao = new RoomDao();
        List<Room> room = (List<Room>) roomDao.getAllEntities();
        outStream.writeObject(room);



    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
