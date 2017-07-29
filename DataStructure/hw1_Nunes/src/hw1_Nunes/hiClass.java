package hw1_Nunes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/**
 * Created by Ricardo Nunes on 9/10/2016.
 */


public class hiClass {

    public static void main(String[] args) {
    	
    	Random rd = new Random();
    	
    	String[] greet = 		//possible greetings
			{"Hello", "Hi", "Yo", "Ni Hao", "Sup", "Hey", "Ahoy", "Hold your horses"};
    	
    	// directory for input file students.txt
    	String dirIn = "/Users/ricardodossantosalmei/Documents/workspace"
    							+"/CH1/Classes/Ch1/hw1_Nunes/src/hw1_Nunes/students.txt";
    	// directory for output file hiStudents.txt
    	String dirOut = "/Users/ricardodossantosalmei/Documents/workspace"
    							+"/CH1/Classes/Ch1/hw1_Nunes/src/hw1_Nunes/hiStudents.txt";
    	
    	
    	File file = new File(dirIn);
       
        try {
            
        	Scanner scanner = new Scanner(file);
        	
            while(scanner.hasNext()){
                String student = scanner.nextLine().replaceAll("\"", "")+"!";
            	printToFile(dirOut, greet[rd.nextInt(greet.length)]+" "+student);            
            }
            
            scanner.close();
            
        } catch (FileNotFoundException ex){
            
        	ex.printStackTrace();
        }
    }

    // Method to print expression to file
    private static void printToFile(String directory, String expression){

    	try {
    		
    		FileWriter fileWriter = new FileWriter(directory, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(expression);
            bufferedWriter.newLine();

            bufferedWriter.close();
           
        } catch (IOException e) {
            e.printStackTrace();
        }     	

    }
    
}

