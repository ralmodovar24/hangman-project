
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

    static String encripcion, desencripcion;
    static String output1;
    static String message2;

    public SocketServer() {

        initComponents();
        this.setTitle("Encrypted chat");
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

    private void whileChatting() throws IOException {

        jTextField1.setEditable(true);
        do {
            try {
                message2 = (String) input.readObject();
                chatArea.append("\n" + message2);
            } catch (ClassNotFoundException classNotFoundException) {

            }
        } while (!message2.equals("Client - END"));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        jPanel1.setLayout(null);

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 360, 270);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(30, 50, 270, 30);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(310, 50, 80, 30);

        status.setText("...");
        jPanel1.add(status);
        status.setBounds(30, 80, 300, 40);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Write your text here");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 30, 150, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg7.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 420, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE));

        setSize(new java.awt.Dimension(414, 428));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

        sendMessage(jTextField1.getText());
        jTextField1.setText("");
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed

        sendMessage(jTextField1.getText());
        jTextField1.setText("");
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void sendMessage(String message) {

        try {
            output.writeObject("Ricardo: " + encryptar(message) + " --> " + desEncryptar(message));
            output.flush();
            chatArea.append("\nRicardo: " + encryptar(message));
        } catch (IOException ioException) {
            chatArea.append("\n Unable to Send Message");
        }
    }

    public static String encryptar(String message2) {

        output1 = new String(message2.replace('A', '@'));
        output1 = output1.replace('a', '@');
        output1 = output1.replace('b', ';');
        output1 = output1.replace('B', ';');
        output1 = output1.replace('c', '"');
        output1 = output1.replace('C', '"');
        output1 = output1.replace('d', '$');
        output1 = output1.replace('D', '$');
        output1 = output1.replace('e', '˜');
        output1 = output1.replace('E', '˜');
        output1 = output1.replace('f', '%');
        output1 = output1.replace('F', '%');
        output1 = output1.replace('g', '^');
        output1 = output1.replace('G', '^');
        output1 = output1.replace('h', '&');
        output1 = output1.replace('H', '&');
        output1 = output1.replace('i', '>');
        output1 = output1.replace('I', '>');
        output1 = output1.replace('j', '*');
        output1 = output1.replace('J', '*');
        output1 = output1.replace('k', '<');
        output1 = output1.replace('K', '<');
        output1 = output1.replace('l', '|');
        output1 = output1.replace('L', '|');
        output1 = output1.replace('m', '?');
        output1 = output1.replace('M', '?');
        output1 = output1.replace('n', ',');
        output1 = output1.replace('N', ',');
        output1 = output1.replace('o', '(');
        output1 = output1.replace('O', '(');
        output1 = output1.replace('p', ')');
        output1 = output1.replace('P', ')');
        output1 = output1.replace('q', '+');
        output1 = output1.replace('Q', '+');
        output1 = output1.replace('r', '=');
        output1 = output1.replace('R', '=');
        output1 = output1.replace('s', '#');
        output1 = output1.replace('S', '#');
        output1 = output1.replace('t', '/');
        output1 = output1.replace('T', '/');
        output1 = output1.replace('u', '!');
        output1 = output1.replace('U', '!');
        output1 = output1.replace('v', ':');
        output1 = output1.replace('V', ':');
        output1 = output1.replace('w', 'x');
        output1 = output1.replace('W', 'x');
        output1 = output1.replace('x', '.');
        output1 = output1.replace('X', '.');
        output1 = output1.replace('y', '_');
        output1 = output1.replace('Y', '_');
        output1 = output1.replace('z', '-');
        output1 = output1.replace('Z', '-');

        return output1;
    }

    public static String desEncryptar(String output1) {
        desencripcion = output1.replace('@', 'a');
        desencripcion = desencripcion.replace(';', 'b');
        desencripcion = desencripcion.replace('"', 'c');
        desencripcion = desencripcion.replace('$', 'd');
        desencripcion = desencripcion.replace('˜', 'e');
        desencripcion = desencripcion.replace('%', 'f');
        desencripcion = desencripcion.replace('^', 'g');
        desencripcion = desencripcion.replace('&', 'h');
        desencripcion = desencripcion.replace('>', 'i');
        desencripcion = desencripcion.replace('*', 'j');
        desencripcion = desencripcion.replace('<', 'k');
        desencripcion = desencripcion.replace('|', 'l');
        desencripcion = desencripcion.replace('?', 'm');
        desencripcion = desencripcion.replace(',', 'n');
        desencripcion = desencripcion.replace('(', 'o');
        desencripcion = desencripcion.replace(')', 'p');
        desencripcion = desencripcion.replace('+', 'q');
        desencripcion = desencripcion.replace('=', 'r');
        desencripcion = desencripcion.replace('#', 's');
        desencripcion = desencripcion.replace('/', 't');
        desencripcion = desencripcion.replace('!', 'u');
        desencripcion = desencripcion.replace(':', 'v');
        desencripcion = desencripcion.replace('x', 'w');
        desencripcion = desencripcion.replace('.', 'x');
        desencripcion = desencripcion.replace('_', 'y');
        desencripcion = desencripcion.replace('-', 'z');

        return desencripcion;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea chatArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
