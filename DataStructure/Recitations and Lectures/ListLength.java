import java.util.Random;

class Node {
	
	long val;
	Node next;
	Node(long n){
		val = n;
    }
}
    

class ListLength {
    
    static Random rg = new Random();
    
    static Node getList(long n){
		
		Node u = new Node(rg.nextInt(10));
		Node v = u;
		
		for (int i=1; i<n; i++){
			u.next = new Node(rg.nextInt(10));
			u = u.next;
		}
		
		return v;
    }
	
	//static Node rev(Node u){}
	
	static int length(Node u){
		if(u==null) 
			return 0;
		return 1+length(u.next);
	}

    public static void main (String[] args){

		long n = (args.length>0) ? Long.parseLong(args[0]) : 8;
		long m = (args.length>1) ? Long.parseLong(args[1]) : 3;
	
		Node myList = getList(n);
	
		System.out.printf("myList: \n");
	
		for (Node u = myList; u!=null; u=u.next)
			System.out.printf(" %d\n", u.val);

    }//main
}
