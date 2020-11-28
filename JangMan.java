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
    private static void manageWord(String palabraEscojida) {
     
        char ch[] = palabraEscojida.toCharArray() ;
        for (char c : ch) {
            System.out.print(c + " ");
        }
        System.out.println();
             
    }

    /*
     * Metodo para leer las palabras de un file usando br. En este estoy tratando de
     * manejar las palabras mejor pero sigo fallando.
     */
    private static void readFile(BufferedReader br) throws IOException {
        String line = br.readLine();

        int count = 0;
        String palabraEscojida;
        Random r = new Random();
        int randomNum = r.nextInt(10);
        // System.out.println(randomNum);
  
        // System.out.println(line[randomNum]);
        while (line != null) {
           

            if (count == randomNum) {
               
                palabraEscojida = line;
                System.out.println(palabraEscojida);

                manageWord(palabraEscojida);
            }
            count++;
            line = br.readLine();

        }

        // String fileAsString = sb.toString();
        // String[] arrOfStr = fileAsString.split("[=========]", 0);
        // System.out.println(arrOfStr);
    }
    private static void scorePrnt(Scanner scanner, int cnt) {

        if (getAns(scanner) == false) {
            System.out.println();
            System.out.println("Intento fallido");
            cnt++;
            
        } else {
            
        }

    }

    private static void firstTurn(BufferedReader buffer, StringBuilder sb) throws IOException {
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
        System.out.println(arrOfStr[0]);
        // for (int i = 0; i < arrOfStr.length-1; i++)
		// {    		
        //     System.out.println(arrOfStr[i]);		
		// }
    }

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new FileReader("palabras.txt"));
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new FileReader("hangmanfigure.txt"));

        firstTurn(buffer,sb);
        readFile(br);
        scorePrnt(scanner, cnt);


        // Mas pruebas.
        // if (getAns(scanner) != true) {
        //     System.out.println("not");
        // } else
        //     System.out.println("tru");

        br.close();
        buffer.close();
    }



}
