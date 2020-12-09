import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JangMan {

    public ArrayList<String> letters = new ArrayList<>();

    /*
     * Metodo para adquirir respuesta del usuario y comparar. Aqui estaba probando
     * el getAns con un hard code de la respuesta "L"
     */
    private static boolean getAns(Scanner scanner, String ch, ArrayList<String> letters) {
        System.out.println("Enter your guess: ");
        String inputString = scanner.next();

        ch.length();

        System.out.println();

        if (!letters.contains(inputString)){
            if(ch.contains(inputString)){
                int index = ch.indexOf(inputString);

                letters.set(index, inputString);
                int otherIndex = ch.lastIndexOf(inputString);
                if(otherIndex != index){
                    letters.set(otherIndex, inputString);
                }
                System.out.println(letters.toString());
                check(letters);
            }
        }
            
        return ch.contains(inputString);
    }


    private static void check(ArrayList<String> letters) {
        if (!letters.contains("_")) {
            System.out.println("GANASTE!!!");
            System.exit(0);
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

    private static void scorePrnt(Scanner scanner, int cnt, BufferedReader buffer, StringBuilder sb, String ch,
            ArrayList<String> letters) throws IOException {
        if (cnt != 6) {
            if (getAns(scanner, ch, letters) == false) {
                System.out.println("Intento fallido");
                cnt++;
                // System.out.println(cnt);
                firstTurn(buffer, sb, cnt, scanner, ch, letters);
            } else {
                System.out.println("Intento valido");
                firstTurn(buffer, sb, cnt, scanner, ch, letters);
            }
        } else {
            System.out.println("Perdiste!!");
            System.exit(0);
        }
    }

    private static void firstTurn(BufferedReader buffer, StringBuilder sb, int cnt, Scanner scanner, String ch,
            ArrayList<String> letters) throws IOException {

        String line = buffer.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = buffer.readLine();
        }

        String fileAsString = sb.toString();
        String[] arrOfStr = fileAsString.split("=========");
        System.out.println(arrOfStr[cnt]);
        scorePrnt(scanner, cnt, buffer, sb, ch, letters);

    }
    
    public static void main(String[] args) throws IOException {

        int cnt = 0;
        ArrayList<String> letters = new ArrayList<>(7);
        BufferedReader br = new BufferedReader(new FileReader("palabras.txt"));
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new FileReader("hangmanfigure.txt"));


        String ch = readFile(br);
        for (int i = 0; i < ch.length(); i++) {
            letters.add(i, "_");
        }
        
        firstTurn(buffer, sb, cnt, scanner, ch, letters);
        scorePrnt(scanner, cnt, buffer, sb, ch, letters);

        br.close();
        buffer.close();
    }

}
