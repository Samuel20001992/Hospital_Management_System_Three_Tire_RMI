package Delete;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeletePatient{
    private final int id;
    private  ObjectInputStream inStream;
    private  ObjectOutputStream outStream;

    public DeletePatient(int id, Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream)
    {
        this.inStream = inStream;
        this.outStream = outStream;
        this.id = id;
    }
    public void delete_patient_main() throws IOException {
        outStream.writeObject("Delete Patient");
       outStream.writeObject(id);
    }
}
