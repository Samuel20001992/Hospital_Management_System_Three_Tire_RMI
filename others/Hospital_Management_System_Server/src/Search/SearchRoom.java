package Search;

import DataTypes.Employee;
import DataTypes.Room;
import app.database.models.employee.EmployeeDao;
import app.database.models.room.RoomDao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SearchRoom extends Thread{
    static ArrayList<String> read_employee = new ArrayList<String>();


    public SearchRoom() throws IOException, ClassNotFoundException {

        search_room();
    }
    public void search_room() throws IOException, ClassNotFoundException {

        RoomDao roomDao = new RoomDao();


        new Thread(()->{
            System.out.println("read employee");
            List<Room> roomList = roomDao.findByColumn(searchItems[0],searchItems[1]);
            roomList.forEach(System.out::println);


        }).start();

    }
}



