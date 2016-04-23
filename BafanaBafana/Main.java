import java.util.Scanner;


public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	// Hay una expresion que lo saca en O(1), no la he conseguido sacar, es algo asi: ((K+P)%(N+1))+1
	int nCases = tc.nextInt();
	for(int i=0;i<nCases;i++){
	    int N = tc.nextInt();
	    int K = tc.nextInt();
	    int P = tc.nextInt();
	    int res = K;
	    for(int j=0;j<P;j++){
		res += 1;
		if(res>N) res = 1;
	    }
	    System.out.println("Case "+(i+1)+": "+res);
	}	
    }
}

