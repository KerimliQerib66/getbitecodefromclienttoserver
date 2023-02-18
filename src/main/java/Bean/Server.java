package Bean;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server implements Runnable {
    @Override
    public void run() {

        try ( ServerSocket serverSocket = new ServerSocket(6789);
                Socket socket = serverSocket.accept();
              InputStream is = socket.getInputStream();
              ){
            System.out.println("Server basladildi");

            System.out.println("Elaqe yaradildi");

            byte[] file= is.readAllBytes();
            Files.write(Paths.get("C:\\Users\\user\\Documents\\burdayam1.png"),file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
