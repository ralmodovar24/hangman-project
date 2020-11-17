import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JangMan {

    private static boolean getAns(Scanner scanner) {
        String w = "L";
        System.out.println("Enter your guess: ");
        String inputString = scanner.nextLine();
        if (inputString == w) {
            return true;
        }else
            return false;
    }

    private static void manageWord() {
        
    }

    private static void readFile(BufferedReader br, StringBuilder sb) throws IOException {
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
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
    if (getAns(scanner) != true) {
        System.out.println("not");
    }else
        System.out.println("tru");

    br.close();
  }
}