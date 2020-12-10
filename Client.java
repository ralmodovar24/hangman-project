import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {

        try {
            Socket clientSocket = new Socket();
            System.out.println("Estableciendo conexión...");
            InetSocketAddress address = new InetSocketAddress("25.3.4.27", 8000);
            clientSocket.connect(address);
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream objOutput = new ObjectOutputStream(output);
            ObjectInputStream objInput = new ObjectInputStream(input);
            Scanner kb = new Scanner(System.in);

            System.out.println(((String) objInput.readObject()));
            System.out.println(((String) objInput.readObject()));

            while (true) {

                objOutput.writeObject(kb.next());

                System.out.println(((String) objInput.readObject()));
                System.out.println(((String) objInput.readObject()));
                System.out.println(((String) objInput.readObject()));
                System.out.println(((String) objInput.readObject()));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
