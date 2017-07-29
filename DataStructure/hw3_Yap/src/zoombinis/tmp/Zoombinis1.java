// PACKAGE!
package Zoombinis;

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

/*
 * Zoombinis.java
 * 
 * This implements the abstractZoombinis class.
 * 
 * This problem asks you to generate a sequence of random Zoombini names.
 * Zoombinis is a great logical computer game for children to adults, 
 * very popular in the 1990s.  
 * 
 * Basic requirement for a Zoombini name is that it is "pronounceable"
 * (it is a sequence of syllables).  
 * 
 * But we may want to have different ethnic Zoombini names (called modes):
 *       1 American, 2 Chinese, 3 Indian, 4 Italian,
 *       5 Japanese, 6 Korean,  7 Japanese, 8 Hawaiian,
 *       9 Other
 * all with their particular probabilistic distribution of sounds 
 * and number of syllables.  How do we do this?
 * 
 * We achieve this by introducing several probability distributions: 
 *    the number of syllables in a name
 *    the vowels (including diphthongs)
 *    the consonants (including digraphs of consonants)
 *    the terminal consonants in a name
 *    the initial vowels in a name
 * 
 * What is needed for this problem (homework 2):
 *      Random number (java.util.Random)
 *      String manipulation
 *      File handling (java.util.Scanner)
 *      Command line argument processing
 *      ArrayList (java.util.ArrayList)
 * 
 * Chee Yap
 * Data Structures Class (CS 102)
 * Spring 2015
 */

public class Zoombinis extends abstractZoombinis {

	 // MEMBERS:======================
     static String vowels="aeiou";
	 static String consonants="bcdfghjklmnpqrstvwxyz";
	 static int[] LDT = {1, 2, 2, 2, 3, 3, 3, 4, 4, 5};
	 static ArrayList<String> 
	 		 allVowels = new ArrayList<String>(),
			 allConsonants = new ArrayList<String>(),
	 		 tConsonants = new ArrayList<String>();
	 //Per mode (1st entry is not used):
	 static int[] terminalProbability = { 5, 2, 2, 4, 4, 4, 2, 4, 4, 4};
	 //Per mode (1st entry is not used):
	 static int[] initialProbability =  { 5, 8, 9, 4, 4, 4, 9, 4, 4, 4};

	 static String[] ethnicity = {
	     	"Default", "American", "Chinese", "Indian", "Italian", 
		"Japanese", "Korean", "Spanish", "Hawaiian", "Other"};

	 //CONSTRUCTOR:====================
	 Zoombinis(int ss, int nn, int mm, String ppath){
	     s=ss; n=nn; m=mm; path=ppath;
	     if (s==0) rg = new Random();
	     else rg = new Random(s);
	 }
	 
	 //METHODS:========================
	 boolean isVowel (char c) {		// not used
		 return vowels.matches(".*" + c + ".*");
	 }
	 boolean isConsonant (char c) {		// not used
		 return consonants.matches(".*" + c + ".*");
	 }
	 String randomVowel () {
	     if (m==0)
		 return Character.toString(
			 vowels.charAt(rg.nextInt(vowels.length())));	 
	     else
		 return allVowels.get(rg.nextInt(allVowels.size()));
	 }
	 String randomConsonant() {
	     if (m==0)
		 return Character.toString(
			 consonants.charAt(rg.nextInt(consonants.length())));
	     else
		 return allConsonants.get(rg.nextInt(allConsonants.size()));
	 }
	 String randomTconsonant() {
		 return tConsonants.get(rg.nextInt(tConsonants.size()));
	 } 
	 String randomSyllable() {
		return randomConsonant() + randomVowel();
	 }
	 String randomInitialSyllable(){
		 if (rg.nextInt(10)>= initialProbability[m])
			 return randomVowel();
		 return randomConsonant()+randomVowel();
	 }
	 
	public  String randomName() {
		String name = "";
		int len = LDT[rg.nextInt(10)];
		if (m==0) {
			 for (int i=0; i< len; i++)
			     name = name + randomSyllable();
		} else { // m>0:
			 name = randomInitialSyllable(); 
			 for (int i=1; i< len; i++)
			     name = name + randomSyllable();
			 // fix the terminal consonant:
			 if (rg.nextInt(10)>= terminalProbability[m])
				 name = name + randomTconsonant();
		}
		 // Capitalize the first letter of name:
		 name = Character.toString(name.charAt(0)).toUpperCase()
			     	+ name.substring(1);
	     return name;
	}//randomName
	
	// File READERS:========================
	
	// Read a LDT file
	public void readLDT() throws FileNotFoundException {
		    File ff = new File(path + "/syntax-" + m + "/LDT");
		    Scanner scan = new Scanner(ff);
		    for (int i=0; i<10; i++) 
				LDT[i] = scan.nextInt();
		    scan.close();
	}//readLDT
	
	// Reads a string per line of input file "fn", and adds to ArrayList "alist"
	public void readFile(ArrayList<String> alist, String fn) 
			throws FileNotFoundException {	
	    File ff = new File(path + "/syntax-" + m + "/" + fn);  
	    Scanner scan = new Scanner(ff);
	    while (scan.hasNext()) 
			alist.add(scan.next());
	    scan.close();
	 }//
	
	
	// MAIN METHOD:===========================
	public static void main(String[] args) throws FileNotFoundException  {

	        int ss=0, nn=16, mm=0;
		String ppath=".";

		if (args.length>0) ss=Integer.parseInt(args[0]);
		if (args.length>1) nn=Integer.parseInt(args[1]);
		if (args.length>2) mm=Integer.parseInt(args[2]);
		if (args.length>3) ppath=args[3];
	
	    Zoombinis zz = new Zoombinis(ss, nn, mm, ppath);
	    System.out.printf("ss=%d, nn=%d, mode=%d, path=%s\n", ss, nn, mm, ppath);
		
		if (zz.m>0) {

		    zz.readFile(allVowels, "vowels");
		    zz.readFile(allVowels, "diphthongs");
		    System.out.println("allVowels = " + allVowels.toString());
		    
		    zz.readFile(allConsonants, "consonants");
		    zz.readFile(allConsonants, "digraphs");
		    System.out.println("allConsonants = " + allConsonants.toString());
		    
		    zz.readFile(tConsonants, "tconsonants");
		    System.out.println("tconsonants = " + tConsonants.toString());

		    zz.readLDT();
		}

		System.out.printf("LDT = " + Arrays.toString(LDT) + "\n");
		System.out.printf( "\n=========================================\n"
			    + "Ethnicity of Names: " + ethnicity[zz.m]
			    + "\n=========================================\n");
	
		for (int i = 0; i< zz.n; i++) 
			System.out.println(zz.randomName());
	
	}//main

}//class
