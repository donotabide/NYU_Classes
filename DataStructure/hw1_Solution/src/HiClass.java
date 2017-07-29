import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/* HiClass.java
 *
 * 	A random variation on Hello World!
 *
 *		Read a list of student names from input file 
 *			"src/students.txt" (one per line)
 *		And greet each student with a random greeting
 *			taken from an array of greetings.
 *		Prints out the greeted students to an output file
 *			"src/hiStudents.txt" (one per line)
 *
 * 	Data Structures, Section 7
 * 	Fall 2016
 * 	Prof.Yap
 *
 * ***************************************************/

public class HiClass {

    public static void main(String[] args) throws FileNotFoundException {
        String[] greet = {"Hello", "Hi", "Yo", "Ni Hao"};
        Random rg = new Random();
        File inputFile = new File("src/students.txt");
        File outputFile = new File("src/hiStudents.txt");
        Scanner scanner = new Scanner(inputFile);
        PrintWriter printWriter = new PrintWriter(outputFile);
        // For every student, randomly great them and write to a file.
        while (scanner.hasNextLine()) {
            printWriter.printf("  %s, %s! \n",
		    greet[rg.nextInt(greet.length)],
		    scanner.nextLine());
        }
        printWriter.close();
        scanner.close();
    }
}
