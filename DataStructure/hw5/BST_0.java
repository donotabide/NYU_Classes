import java.util.Random;

    class Node {
	int key;
	Node left, right, parent;
	Node(int k){
	    key = k;
	}
    }

class BST_0{

    static Node u = null;

    static Node search(int K, Node u){
	if (u == null || u.key == K) return u;

	if (u.key < K) return search(K, u.left);
	return search(K, u.right);
    }//search

    static boolean add( int K, Node u){
	if (u == null || u.key == null) return false;
	// precondition: u is not null
	Node v = search(K, u); //v is not null

	if (v.key == K) return false;
	Node w = new Node(K);
	if (v.key < K) 
	    v.right = w;
	else
	    v.left = w;
	return true;
    }//add

    static void show(Node u){
	if (u == null) return;
	show(u.left);
	System.out.printf("key= %d, ", u.key);
	show(u.right);
    }

    public static void main (String[] args){
	int n = (args.length>0)?  Integer.parseInt(args[0]) : 10;
	int s = (args.length>1)?  Integer.parseInt(args[1]) : 111;
	int m = (args.length>2)?  Integer.parseInt(args[2]) : 9;
	
	Random rg = (s == 0)? new Random() : new Random(s);
	
	Node u = new Node(rg.nextInt(10));

	for (int i = 0; i<n; i++){
	    add ( rg.nextInt(10), u);
	}

	System.out.printf("BST\n");
	show(u);

    }//main
}
