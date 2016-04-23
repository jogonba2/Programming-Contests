import java.util.Scanner;

public class Main{
	
    public static void main(String args[]) {
	Scanner tc = new Scanner(System.in);
	int Z,M,I,L;
	Z = tc.nextInt();
	I = tc.nextInt();
	M = tc.nextInt();
	L = tc.nextInt();
	int cases = 1;
	while(Z!=0 && M!=0 && I!=0 && L!=0){
	    int lastNumber = L;
	    int nextNumber = -1;
	    boolean[] generated = new boolean[M];
	    int range = 0;
	    while(nextNumber==-1 || generated[nextNumber]==false){
		lastNumber = (Z*lastNumber+I)%M;
		nextNumber = (Z*lastNumber+I)%M;
		generated[lastNumber] = true;
		range++;
	    }
	    System.out.println("Case "+cases+": "+range);
	    cases++;
	    Z = tc.nextInt();
	    I = tc.nextInt();
	    M = tc.nextInt();
	    L = tc.nextInt();
	}
    }
}

