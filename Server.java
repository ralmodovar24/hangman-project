import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    /*
     * Metodo para adquirir respuesta del usuario y comparar. Aqui estaba probando
     * el getAns con un hard code de la respuesta "L"
     */
    private static boolean getAns(ObjectInputStream objInput, ObjectOutputStream objOutput, String ch,
            ArrayList<String> letters) {
        String inputString = "";

        try {
            objOutput.writeObject("Enter your guess: ");

            inputString = (String) objInput.readObject();

            ch.length();

            if (!letters.contains(inputString)) {
                if (ch.contains(inputString)) {
                    int index = ch.indexOf(inputString);

                    letters.set(index, inputString);
                    int otherIndex = ch.lastIndexOf(inputString);

                    if (otherIndex != index) {
                        letters.set(otherIndex, inputString);
                    }

                    objOutput.writeObject(letters.toString());
                    check(letters, objOutput);
                } else {
                    objOutput.writeObject(letters.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ch.contains(inputString);
    }

    private static void check(ArrayList<String> letters, ObjectOutputStream objOutput) {
        if (!letters.contains("_")) {
            try {
                objOutput.writeObject("GANASTE!!!");
                System.exit(0);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }
    }

    /*
     * Metodo para leer las palabras de un file usando br. En este estoy tratando de
     * manejar las palabras mejor pero sigo fallando.
     */
    private static String readFile(BufferedReader br) throws IOException {
        String line = br.readLine();

        int count = 0;
        String palabraEscojida = null;
        Random r = new Random();
        int randomNum = r.nextInt(10);

        while (line != null) {

            if (count == randomNum) {

                palabraEscojida = line;
                System.out.println(palabraEscojida);
            }
            count++;
            line = br.readLine();

        }

        return palabraEscojida;
    }

    private static void scorePrnt(ObjectInputStream objInput, ObjectOutputStream objOutput, int cnt,
            BufferedReader buffer, StringBuilder sb, String ch, ArrayList<String> letters) throws IOException {
        try {
            if (cnt != 6) {
                if (getAns(objInput, objOutput, ch, letters) == false) {
                    objOutput.writeObject("Intento fallido");
                    cnt++;
                    // System.out.println(cnt);
                    firstTurn(buffer, sb, cnt, objOutput, objInput, ch, letters);
                } else {
                    objOutput.writeObject("Intento valido");
                    firstTurn(buffer, sb, cnt, objOutput, objInput, ch, letters);
                }
            } else {
                objOutput.writeObject("Perdiste!!");
                System.exit(0);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static void firstTurn(BufferedReader buffer, StringBuilder sb, int cnt, ObjectOutputStream objOutput,
            ObjectInputStream objInput, String ch, ArrayList<String> letters) throws IOException {

        String line = buffer.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = buffer.readLine();
        }

        String fileAsString = sb.toString();
        String[] arrOfStr = fileAsString.split("=========");
        objOutput.writeObject(arrOfStr[cnt]);
        objOutput.flush();
        scorePrnt(objInput, objOutput, cnt, buffer, sb, ch, letters);

    }

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress address = new InetSocketAddress("25.3.4.27", 8000);
            serverSocket.bind(address);
            System.out.println("Aceptando conexiones...");
            Socket newSocket = serverSocket.accept();
            System.out.println("¡Conexión aceptada!");
            InputStream input = newSocket.getInputStream();
            OutputStream output = newSocket.getOutputStream();
            ObjectOutputStream objOutput = new ObjectOutputStream(output);
            ObjectInputStream objInput = new ObjectInputStream(input);

            int cnt = 0;
            ArrayList<String> letters = new ArrayList<>(7);
            BufferedReader br = new BufferedReader(new FileReader("./src/palabras.txt"));
            StringBuilder sb = new StringBuilder();
            BufferedReader buffer = new BufferedReader(new FileReader("./src/hangmanfigure.txt"));

            String ch = readFile(br);
            for (int i = 0; i < ch.length(); i++) {
                letters.add(i, "_");
            }

            firstTurn(buffer, sb, cnt, objOutput, objInput, ch, letters);
            scorePrnt(objInput, objOutput, cnt, buffer, sb, ch, letters);

            br.close();
            buffer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
