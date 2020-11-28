import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class JangMan {

    /*
     * Metodo para adquirir respuesta del usuario y comparar. Aqui estaba probando
     * el getAns con un hard code de la respuesta "L"
     */
    private static boolean getAns(Scanner scanner) {
        String w = "L";
        System.out.println("Enter your guess: ");
        String inputString = scanner.nextLine();
        if (inputString == w) {
            return true;
        } else
            return false;
    }

    /*
     * Por hacer
     */
    private static void manageWord() {

    }

    /*
     * Metodo para leer las palabras de un file usando br. En este estoy tratando de
     * manejar las palabras mejor pero sigo fallando.
     */
    private static void readFile(BufferedReader br, StringBuilder sb) throws IOException {
        String line = br.readLine();

        int count = 0;
        String palabraEscojida;
        Random r = new Random();
        int randomNum = r.nextInt((10 - 0) + 1) + 0;
        while (line != null) {
            // System.out.println(line);

            if (count == randomNum) {
                System.out.println("llegue");
                palabraEscojida = line;
                System.out.println(palabraEscojida);
            }
            count++;
            line = br.readLine();

        }

        String fileAsString = sb.toString();
        String[] arrOfStr = fileAsString.split("[\\n]", -1);
        System.out.println(arrOfStr);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("palabras.txt"));
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        readFile(br, sb);

        manageWord();

        // Mas pruebas.
        if (getAns(scanner) != true) {
            System.out.println("not");
        } else
            System.out.println("tru");

        br.close();
    }
}