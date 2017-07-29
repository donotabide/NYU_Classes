
import java.util.Random;
import java.lang.Character;

 public class Zoombinis3 extends AbstractZoombinis3 {

 	static boolean isVowel (char c) {
	    return Character.toString(c).matches("[aeiou]");
	}
 	static boolean isConsonant (char c){
	    return true;
	}
 	static char randomVowel (){
	    String vowels="aeiou";
	    return(vowels.charAt(rg.nextInt(5)));
	}
 	static char randomConsonant(){
	    String vowels="bcdfghjklmnpqrstvwxyz";
	    return(vowels.charAt(rg.nextInt(21)));
	}
 	static String randomSyllable(){
	    String s="" + randomConsonant() + randomVowel();
	    return s;
	}
 	static public String randomName() {
	    int n=rg.nextInt(5);
	    String name = randomSyllable();
	    for (int i=0; i<n; i++)
		name = name+ randomSyllable();
	    return name;
	}
 	public static void main(String[] args) {

	 	nn=0;
		ss=0;
		mm=16;
	 	path=".";
		rg = new Random(); 

	    System.out.println(randomName());
	}
}

