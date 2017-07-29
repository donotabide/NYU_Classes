/*
 * file: FileHandling.java
 *
 *   File Handling can be very confusing.  The lowest level
 *     is to treat them as an (input or output) stream,
 *     i.e., a sequence of bytes (8-bit chunks).
 *     But we prefer to work with slightly higher level of
 *     abstraction, viewed as a sequence primitive data types
 *     of Java (ints, doubles, characters) or lines of characters,
 *     or "tokens" (strings with no white-space), etc.
 *
 *   The following distills this to only three main packages that
 *   that you need to import to handling files and I/O for our class:
 *    
 *        java.io.File
 *        java.io.PrintWriter
 *        java.util.Scanner.
 *    
 *   In this program, 
 *    	0.  We have used a simplified Exception handling
 *    		method (HOW?)
 *      1.  We first create a file named "FileHandling"
 *          and write some information into the file.  
 *          NOTE: this is a text file, with no extension in its name
 *                (Windows programs beware).
 *                Question: What IS a "text file"?
 *      
 *      2.  Then we will open it for reading, and print its contents
 *          on the terminal.
 * 
 *    (STEP 1) Create a file object 
 *        It has no associated read/write methods!!!
 *    
 *        ABSOLUTE MININUM METHODS:  (assuming error free)
 *              File(String pathname)
 *              File(String parent, String child)
 *              File(File parent, String child)
 *              
 *    (STEP 2) Convert File object into a file processing mechanism.
 *             There are two possibilities:
 *    
 *       WRITE ONLY:      PrintWriter -- to write into a text file
 *              CONSTRUCTORS:
 *                  PrintWriter(String filename)
 *                  PrintWriter(File file)
 *                  PrintWriter(OutputStream out)
 *              METHODS: 
 *                  void print(xxx)    where
 *                      xxx = String, char, char[], int, double, boolean
 *            
 *                 Also: println and printf
 *       
 *       READ ONLY:     Scanner  -- read tokens separated by white spaces
 *                               -- can construct from file or System.in!
 *             CONSTRUCTORS:
 *                 Scanner(XXX)    where XXX is File or String
 *             METHODS:
 *                close()
 *                hasNext() boolean
 *                next() String
 *                nextLine() String
 *                nextInt() int
 *                nextDouble() double
 *              
 *      ==========================
 *      Data Structure Class CS102
 *      Chee Yap
 *      2016 Fall
 */

import java.io.File;  
import java.io.PrintWriter;
import java.util.Scanner;


public class FileHandling {

	public static void main (String[] args) throws Exception {
		
		String fname = "FileHandling";	// name of file
		File file = new File(fname);
		
		//////////////////////PRINT WRITER///////////////////
		PrintWriter pw = new PrintWriter(file);
		
		// If file exists already, write over it!!!:
		pw.print("This is from PrintWriter\n");  
		
		int n=123;
		pw.printf("int n=%d\n", n);
		
		double d=123.456;
		pw.printf("double d=%f\n", d);
		
		boolean flag=false;
		pw.printf("boolean flag=%s\n", flag);
		
		pw.close();
		
		
		//////////////////////SCANNER///////////////////
		// Scanner ifile = new Scanner(System.in);
		Scanner ifile = new Scanner(new File(fname));
		
		while (ifile.hasNext()) {
			System.out.println(ifile.nextLine());
		}

		ifile.close(); // what if you forget to close?

		///////////////////// INTERACTIVE VERSION ///////
		// ifile = new Scanner(System.in);
		// pw = new PrintWriter(file);
		// 
		// Write a while loop here to read various data types
		//     (int, boolean, etc) from console
		//     and store them in "FileHandling"
	}
	
}

