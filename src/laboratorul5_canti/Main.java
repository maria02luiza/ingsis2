package laboratorul5_canti;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        try {
            printSmallTextFile("text.txt");
            System.out.println("\n\n");
           printLargerTextFile("text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void printSmallTextFile(String fileName) throws IOException {
        System.out.println("Using Files.readAllLines:");
        Path path = Paths.get(fileName);
        List<String> allLinesInMemory = Files.readAllLines(path);
        for(String line: allLinesInMemory) {
            System.out.println(": " +line);
        }
    }
    static void printLargerTextFile(String fileName) throws IOException {
        System.out.println("Using Scanner:");
        Path path = Paths.get(fileName);
        try (Scanner scanner = new Scanner(path)){
            while (scanner.hasNextLine()){
                System.out.println(": " + scanner.nextLine());
            }
        }
        String line ="Lorem ipsum dolor sit amet, vim ne eripuit vulputate.\n"    +    "Vide tantas dicunt ne ius, mel pertinacia intellegebat ei." ;
        // Adăugăm \n după fiecare punct (.)
        line = line.replace(".", ".\n");

        System.out.println("String line = \"" + line + "\";");

        // Split după un singur caracter de spațiu
        System.out.println("Split by one space char: ");
        String[] words = line.split(" ");
        for (String w : words) {
            System.out.print("[" + w + "]");
        }

        System.out.println("\n\nSplit by regex \\s+: ");

        // Split după spațiu sau grupuri de spații
        String[] words2 = line.split("\\s+");
        for (String w : words2) {
            System.out.print("[" + w + "]");

        }
    }
}


