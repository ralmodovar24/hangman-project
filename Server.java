import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress address = new InetSocketAddress("localhost", 8000);
            serverSocket.bind(address);
            System.out.println("Aceptando conexiones...");
            Socket newSocket = serverSocket.accept();
            System.out.println("¡Conexión aceptada!");
            InputStream input = newSocket.getInputStream();
            OutputStream output = newSocket.getOutputStream();
            ObjectOutputStream objOutput = new ObjectOutputStream(output);
            ObjectInputStream objInput = new ObjectInputStream(input);

            String message = (String) objInput.readObject();
            System.out.println(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
