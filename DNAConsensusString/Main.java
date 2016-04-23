import java.util.Scanner;

public class Main{
    
    public static int max(int a,int b,int c,int d){
	int max = Integer.MIN_VALUE;
	if(a>=max) max = a;
	if(b>=max) max = b;
	if(c>=max) max = c;
	if(d>=max) max = d;
	return max;
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	for(int i=0;i<nCases;i++){
	    int m = tc.nextInt();
	    int n = tc.nextInt();
	    String[] sequences = new String[m];
	    tc.nextLine(); // Clear buffer
	    for(int j=0;j<m;j++) sequences[j] = tc.nextLine().trim().toUpperCase();
	    int error = 0;
	    int A,G,C,T,MAX;
	    String consensus = "";
	    for(int j=0;j<n;j++){
		A = 0;
		G = 0;
		C = 0;
		T = 0;
		for(int k=0;k<m;k++){
		    if(sequences[k].charAt(j)=='A') 	 A++;
		    else if(sequences[k].charAt(j)=='G') G++;
		    else if(sequences[k].charAt(j)=='C') C++;
		    else if(sequences[k].charAt(j)=='T') T++;
		}
		MAX = max(A,G,C,T);
		if(A==MAX)      consensus+="A";
		else if(C==MAX) consensus+="C";
		else if(G==MAX) consensus+="G";
		else if(T==MAX) consensus+="T";
		error += m-MAX;
	    }
	    System.out.println(consensus);
	    System.out.println(error);
	}	
    }
}

