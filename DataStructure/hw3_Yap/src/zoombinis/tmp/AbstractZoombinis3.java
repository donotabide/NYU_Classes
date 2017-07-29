//THIS IS A THIRD DESIGN 
//	where we used static variables AND static methods.
//	BUT we must make these methods non-abstract.
//

import java.util.Random;

 public abstract class AbstractZoombinis3 {
 	static int nn, ss, mm;
 	static String path;
 	static Random rg; // must import java.util.Random

 	static boolean isVowel (char c) {
	    return true;
	}
 	static boolean isConsonant (char c) {
	    return true;
	}
 	static  char randomVowel () {
	    return 'a';
	}
 	static char randomConsonant() {
	    return 'b';
	}
 	static String randomSyllable() {
	    return "ba";
	}
 	static public String randomName()  {
	    return "baba";
	}

 	public static void main(String[] args) {}
}

