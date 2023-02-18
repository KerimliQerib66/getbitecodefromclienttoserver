package Bean;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client implements Runnable {
    public String localadress;
   private final int portnumber;
   private final String filename;
    public Client(String localadress,int portnumber,String filename){
     this.portnumber=portnumber;
     this.localadress=localadress;
     this.filename=filename;
    }


    @Override
    public void run() {
        try (Socket socket = new Socket(this.localadress, this.portnumber);
             OutputStream out = socket.getOutputStream()) {
            File file = new File(filename);
            byte[] filecontent = Files.readAllBytes(file.toPath());
            out.write(filecontent);
        }
        catch(IOException E){
            E.getStackTrace();
        }
    }
}
