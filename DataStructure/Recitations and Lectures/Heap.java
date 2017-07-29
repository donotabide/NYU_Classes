/*
 * This code was developed in class lectures (Nov 15, 2016)
 * We ask you to develop the 
 *	dequeue method
 * and
 *	to prove a test in main method.
 *	
 * -- Chee
 *
 */
import java.util.Random;


class Heap{

    int[] A = new int[100];

    int tos = 0;

    int parent(int i) {
	return (i-1)/2;
    }
    int leftChild(int i){
	return 2*i + 1;
    }
    int rightChild(int i){
	return 2*i + 2;
    }

    void swap(int i){
	int tmp = A[i];
	A[i] = A[parent(i)];
	A[parent(i)] = tmp;
    }
    int  dequeue () {
	int k = A[0];
	A[0] = A[--tos];

	int i = 0;
	while(hasChild(i)){
	}

    }
    void  enqueue (int k) {
	A[tos++] = k;

	int i = tos-1;
	while (i>0 && A[i] > A[parent(i)]){
	    	swap(i);
		i = parent(i);
	}
    }

    void show(int nn){
	System.out.println("A = ");
	for (int i=0; i< nn; i++)
	    System.out.printf(" %d ", A[i]);
	System.out.println("");
    }

    public static void main(String[] args){

	Random rg = new Random();

	int nn=10;

	Heap hh = new Heap();

	for (int i=0; i<nn; i++){
	    hh.enqueue( rg.nextInt(nn) );
	}

	hh.show(nn);

    }

}
