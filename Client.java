import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            Socket clientSocket = new Socket();
            System.out.println("Estableciendo conexión...");
            InetSocketAddress address = new InetSocketAddress("localhost", 8000);
            clientSocket.connect(address);
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream objOutput = new ObjectOutputStream(output);
            ObjectInputStream objInput = new ObjectInputStream(input);
            Scanner kb = new Scanner(System.in);

            System.out.println("Enter a word:");
            objOutput.writeObject(kb.nextLine());
            objOutput.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
