package Delete;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeleteEmployee {

    private  ObjectInputStream inStream;
    private  ObjectOutputStream outStream;
    private int id;

    public DeleteEmployee(int id)
    {
        this.id = id;
    }
    public void delete_employee_main() throws IOException {

    }
}
