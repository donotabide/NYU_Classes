
/****************************************************

 *	Data Structures (CS 102), Section 7, Fall 2016
 *
 *	This was the program illustrated in Eclipse
 *	in lecture 1.  Please study this, as homework 1
 *	will ask you to elaborate on this.
 *
 *	--Chee Yap
 *	Sep 6, 2016
 *
 ***************************************************/
package hw1_Nunes;

import java.util.Random;

public class HelloClass {
	
	public static void main(String[] args) {

		String[] greet = 		//possible greetings
			{"Hello", "Hi", "Yo", "Ni Hao"};
		
		String[] subject = 		//possible subjects
			{"World", "Class", "Chee",
				"Justin", "Tin", "Yuting", "Charles"};	
		
		Random rg = new Random();	//random number generator

		String who = subject[rg.nextInt(subject.length)];
						//pick someone randomly...
		
		if (args.length>0)		//   unless command line
			who = args[0];		//   makes a choice
		
		System.out.printf(		//print random greeting!
				"  %s, %s!  \n\n",
				greet[rg.nextInt(greet.length)],
				who);		
	}//main
}//HelloClass class

