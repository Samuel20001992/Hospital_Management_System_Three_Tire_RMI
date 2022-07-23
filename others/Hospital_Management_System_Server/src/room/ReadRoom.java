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

    public ReadRoom() {


    }

    public static Room read_Room() {


        RoomDao roomDao = new RoomDao();
        List<Room> room = (List<Room>) roomDao.getAllEntities();
        Room room1 = (Room) room;
        return room1;

    }
}
