
import java.util.Random;
import java.lang.Character;

 public class Zoombinis2 extends AbstractZoombinis2 {

 	boolean isVowel (char c) {
	    return Character.toString(c).matches("[aeiou]");
	}
 	boolean isConsonant (char c){
	    return true;
	}
 	char randomVowel (){
	    String vowels="aeiou";
	    return(vowels.charAt(rg.nextInt(5)));
	}
 	char randomConsonant(){
	    String vowels="bcdfghjklmnpqrstvwxyz";
	    return(vowels.charAt(rg.nextInt(21)));
	}
 	String randomSyllable(){
	    String s="" + randomConsonant() + randomVowel();
	    return s;
	}
 	public String randomName() {
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

	    Zoombinis zz = new Zoombinis();

	    System.out.println(zz.randomName());
	}
}

