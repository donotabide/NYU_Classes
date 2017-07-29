//THIS IS AN ALTERNATIVE DESIGN 
//	where we used static variables
//	BUT we could NOT use static abstract methods!
//	WHY? Because "static abstract" methods do not exist in Java
//	It is a design choice, as explained here:
//   http://stackoverflow.com/questions/370962/why-cant-static-methods-be-abstract-in-java
//

import java.util.Random;

 public abstract class AbstractZoombinis2 {
 	static int nn, ss, mm;
 	static String path;
 	static Random rg; // must import java.util.Random

 	abstract boolean isVowel (char c) ;
 	abstract boolean isConsonant (char c);
 	abstract  char randomVowel ();
 	abstract char randomConsonant();
 	abstract String randomSyllable();
 	public abstract String randomName() ;
 	public static void main(String[] args) {}
}

