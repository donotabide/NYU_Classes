package stringLog;

import java.util.Random;

public class MyArrayStringLog
	implements StringLogInterface {

	// MEMBERS:
	String name;
	String[] log;
	int lastIndex = -1;

	// CONSTRUCTORS:
	MyArrayStringLog(String name, int maxSize) {
	    log = new String[maxSize];
	    this.name = name; 
	}
	MyArrayStringLog(String name) {
	    log = new String[100];
	    this.name = name; 
	}


	public void insert(String e){
	    resize();		// new!
	    lastIndex++;
	    log[lastIndex] = e;
	}

	public void clear() {
	    lastIndex = -1;
	}

	public boolean isFull() {
	    if (lastIndex == log.length -1)
		return true;
	    else
		return false;
	}

	public int size() {
	    return (lastIndex+1);
	}

	// NEW:
	public String toString(int m){
	    String logString = "Log: " + name + "\n\n";

	    if (m>lastIndex/2) m=lastIndex/2;

	    for (int i=0; i < m; i++)
		logString = logString + (i+1) + ". " + log[i] + "\n";

	    logString = logString + " ...\n";
	    for (int i=lastIndex-m+1; i <= lastIndex; i++)
		logString = logString + (i) + ". " + log[i] + "\n";

	    return logString;
	}

	public boolean contains(String e){
	    for (int i=0; i<=lastIndex; i++){
		if (e.equalsIgnoreCase(log[i]))
		    return true;
	    }
	    return false;
	}

	// RESIZE:
	public void resize(){
	    if (isFull()){
		String[] biggerLog = new String[2*log.length];
		for (int i=0; i<= lastIndex; i++)
		    biggerLog[i] = log[i];
		log = biggerLog;
	    }
	}

	// MAIN class
	public static void main(String[] args){
	    int nn = (args.length>0)? Integer.parseInt(args[0]) : 20;
	    int mm = (args.length>1)? Integer.parseInt(args[1]) : 3;
	    int ss = (args.length>2)? Integer.parseInt(args[2]) : 0;

	    Random rg = (ss>0)? new Random(ss) : new Random();

	    MyArrayStringLog myLog = new MyArrayStringLog("Ricardo's Log");

	    for (int i=0; i<nn; i++){
		myLog.insert(Integer.toString(rg.nextInt(nn)));
	    }

	    System.out.printf(" \n --- first and last %d strings are:\n", mm);
	    System.out.println(myLog.toString(mm));
	}
}//class

