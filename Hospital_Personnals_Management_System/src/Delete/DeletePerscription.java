package Delete;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DeletePerscription  {

    private final int id;
    private  ObjectOutputStream outStream;
    private  ObjectInputStream inStream;

    public DeletePerscription(int id, Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream)
    {
        this.inStream = inStream;
        this.outStream = outStream;
        this.id = id;
    }
    public void delete_prescripiton_main() throws IOException {

        outStream.writeObject("Delete Prescription");
        outStream.writeObject(id);
    }
}
