import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer extends javax.swing.JFrame {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    private ServerSocket server;
    private int totalClients = 100;
    private int port = 6789;

    public MainServer() {

        this.setTitle("Server");
        this.setVisible(true);
    }

    public void startRunning() {
        try {
            server = new ServerSocket(port, totalClients);
            while (true) {
                try {
                    System.out.println(" Waiting for Someone to Connect...");
                    connection = server.accept();
                    System.out.println(" Now Connected to " + connection.getInetAddress().getHostName());

                    output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(connection.getInputStream());

                } catch (EOFException eofException) {
                    eofException.printStackTrace();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}