
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends javax.swing.JFrame {

    private static ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    private ServerSocket server;
    private int totalClients = 100;
    private int port = 6789;

    static String message2;

    public SocketServer() {

        initComponents();
        this.setTitle("HANGMAN");
        this.setVisible(true);
        status.setVisible(true);
    }

    public void startRunning() {
        try {
            server = new ServerSocket(port, totalClients);
            while (true) {
                try {
                    status.setText(" Waiting for Someone to Connect...");
                    connection = server.accept();
                    status.setText(" Now Connected to " + connection.getInetAddress().getHostName());

                    output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(connection.getInputStream());

                    whileChatting();

                } catch (EOFException eofException) {
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
