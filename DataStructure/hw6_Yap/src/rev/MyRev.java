package rev;

/*****************************************
 * MyRev.java
 *		
 *	MyRev is just an extension of Rev.
 *
 *	You only provide the implementation of 2 methods:
 *
 *		Node iReverse(Node u);
 *		Node iReverse2(Node u);
 *	 	
 *	Just use the main method of Rev.java.
 *
 * Chee Yap
 * Fall 2016, CS102
 *
 *****************************************/
import java.util.Random;
import util.MyList;

class MyRev extends Rev{

    /*****************************************
     * METHODS
     *****************************************/

    // iterative Reversal (cyclic version)
    Node iReverse2(Node u){
	return reverse(u);
    }// iReverse

    // iterative Reversal (direct version)
    Node iReverse(Node u){
	return reverse(u);
    }// iReverse

}
