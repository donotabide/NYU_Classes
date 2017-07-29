/* Match.java
 *
 *    String[]	AA = {"pit","spot", "spate", "slaptwo", "respite"},
 *    		BB = {"pt","Pot", "peat", "part"};
 *
 *	automatic testing of patterns for 
 *		-- matching every string in array AA,
 *		-- matching no string in array BB.
 *
 *	This was hw3.  We give 3 possible solutions below:
 *
 *    	  pat0 = "pit|spot|spate|slaptwo|respite"
 *    	  pat1 = "[^pP].*|.*[^t]|pit"
 *    	  pat2 = "pit|s.*|^r.*"
 *
 *	Also, some non-solutions:
 *    	  pat3 = "pit|spot|spate|slaptwo|respite|pt"
 *    	  pat4 = "pit|spot|spate|slaptwo"
 *
 *	In command line, you can
 * Prof Chee Yap
 * Data Structures (CS102)
 * Fall 2016
 */
package match;

class Match{
  public static void main(String[] args){
      // Please keep these default arguments:
      String pat = (args.length>1) ? args[1] : "pit|s.*|^r.*" ;
      String afile = (args.length>2) ? args[2] : "src/match/afile.txt";
      String bfile = (args.length>3) ? args[3] : "src/match/bfile.txt";


      // You should create your A-list by reading from the afile.
      // You should create your B-list by reading from the bfile.
      //
      // NOTE that you must NOT modify our afile.txt or bfile.txt
      //
      //	-- so you need to ignore comment lines that begins with # 
      //	-- so you need to ignore empty lines

  }//main

}//class
