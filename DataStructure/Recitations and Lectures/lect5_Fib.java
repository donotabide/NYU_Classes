class lect5_Fib {
    static long f(long n){
	
	
		if (n<2) 
			return n;	
		
		return f(n-1)+ f(n-2);
    }

    public static void main (String[] args){

	long n = (args.length>0) ? Long.parseLong(args[0]) : 8;
	long m = (args.length>1) ? Long.parseLong(args[1]) : 3;

	System.out.printf("fib(%d) = %d\n", n, f(n));
	
	for (long i=1; i<m; i++)
		System.out.printf("fib(%d) = %d\n", ++n, f(n));

    }//main
}
