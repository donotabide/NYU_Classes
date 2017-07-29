import java.math.*;


class lect5_Fib1 {
    static BigInteger ONE = new BigInteger("1");
    static BigInteger TWO = new BigInteger("2");


    static BigInteger f(BigInteger n){

		if (n.compareTo(ONE)<0) 
			return n;

		return f(n.subtract(ONE)).add( f(n.subtract(TWO)) );
    }

    public static void main (String[] args){

		BigInteger n = (args.length>0) ? new BigInteger(args[0]) : 
	    			new BigInteger("7");

		int m = (args.length>1) ? Integer.parseInt(args[1]) : 3;
		
		System.out.printf("fib(%s) = %s\n", n.toString(), f(n).toString());
		
		for (int i=1; i<m; i++){
			n.add(ONE);
			System.out.printf("fib(%s) = %s\n", n.toString(), f(n).toString());
		}
    }//main
}
