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
    private static boolean getAns(Scanner scanner, String ch) {
        System.out.println("Enter your guess: ");
        String inputString = scanner.next();

        ch.length();
        for (int i = 0; i < ch.length(); i++) {
            System.out.println("X");
        }
        //int idx = ch.indexOf(inputString);
        //System.out.println(idx);



        return ch.contains(inputString);
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
        // System.out.println(randomNum);

        // System.out.println(line[randomNum]);
        while (line != null) {

            if (count == randomNum) {

                palabraEscojida = line;
                System.out.println(palabraEscojida);
            }
            count++;
            line = br.readLine();

        }

        // String fileAsString = sb.toString();
        // String[] arrOfStr = fileAsString.split("[=========]", 0);
        // System.out.println(arrOfStr);
        
        return palabraEscojida;
    }

    private static void scorePrnt(Scanner scanner, int cnt, BufferedReader buffer, StringBuilder sb, String ch)
            throws IOException {
        if (cnt != 54) 
        {
            if (getAns(scanner, ch) == false) {
                System.out.println("Intento fallido");
                cnt += 9;
                System.out.println(cnt);
                firstTurn(buffer, sb, cnt, scanner, ch);
            } else {
                System.out.println("Intento valido");
                firstTurn(buffer, sb, cnt, scanner, ch);
            }
        } else{
            System.out.println("Perdiste!!");
            System.exit(0);
        }
    }

    private static void firstTurn(BufferedReader buffer, StringBuilder sb, int cnt, Scanner scanner, String ch)
            throws IOException {
        // String line = buffer.readLine();
        // String fileAsString = sb.toString();
        // String[] line = fileAsString.split("[=========]", 0);

        String line = buffer.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = buffer.readLine();
        }

        String fileAsString = sb.toString();
        String[] arrOfStr = fileAsString.split("[=========]", -1);
        System.out.println(arrOfStr[cnt]);
        scorePrnt(scanner, cnt, buffer, sb, ch);
        // for (int i = 0; i < arrOfStr.length-1; i++)
        // {
        // System.out.println(arrOfStr[i]);

        // }

    }

    public static void main(String[] args) throws IOException {

        int cnt = 0;
        BufferedReader br = new BufferedReader(new FileReader("palabras.txt"));
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new FileReader("hangmanfigure.txt"));

        String ch = readFile(br);
        firstTurn(buffer, sb, cnt, scanner, ch);
        scorePrnt(scanner, cnt, buffer, sb, ch);

        br.close();
        buffer.close();
    }

}
