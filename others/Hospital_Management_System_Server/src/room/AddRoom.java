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

    private int id;

    public AddRoom() {

    }

    public static void add_Room(int id,Room room) {

       RoomDao roomDao= new RoomDao();
        roomDao.updateById(id,room);

    }
    }


