/* file: TraceFac.java
 *
 *	Showing the trace of Factorial computation
 *
 *	QUESTION: when does this break down?
 *
 *	Chee Yap
 *	Data Structures (CS102)
 *	2014f, 2016f
 */


public class lect5_TraceFac {

  private static String indent = "";  // indentation for trace

  private static long fac(long n) {

    long retValue;   // return value
    System.out.println(indent + "Enter fac " + n);
    indent = indent + "| ";

    if (n <= 1) 
    	retValue = n;
    else 
    	retValue = n * fac(n - 1);
      
    indent = indent.substring(2);
    
    System.out.println(indent + "Return " + retValue);
    
    return(retValue);
  }

  public static void main(String[] args) {

    int n = (args.length>0) ? Integer.parseInt(args[0]) : 3;
    int N = (args.length>1) ? Integer.parseInt(args[1]) : 5;
    
    System.out.printf("\n fac of %d is %d\n",  n, fac(n));
    while (n++ < N)
    	System.out.printf("\n fac of %d is %d\n",  n, fac(n));

  } //main
}
