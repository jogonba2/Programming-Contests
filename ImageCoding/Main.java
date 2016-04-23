import java.util.Scanner;
import java.util.HashMap;


class Main{
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	int R,C,M,N;
	String aux;
	for(int i=0;i<nCases;i++){
	    aux = "";
	    R = tc.nextInt();
	    C = tc.nextInt();
	    M = tc.nextInt();
	    N = tc.nextInt();
	    HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
	    for(int j=0;j<=R;j++) aux += tc.nextLine(); 
	    char c;
	    char maxc;
	    int cmax = Integer.MIN_VALUE;
	    for(int j=0;j<aux.length();j++){
		c = aux.charAt(j);
		if(hash.get(aux.charAt(j))==null) hash.put(c,1);
		else   				  hash.put(c,hash.get(c)+1);
		if(hash.get(c)>cmax){
		    cmax = hash.get(c);
		    maxc = c;
		}
	    }
	    int totalSize = 0;
	    for(Integer t : hash.values()){
		if(t==cmax) totalSize += (t*M);
		else        totalSize += (t*N);
	    }
	    System.out.println("Case "+(i+1)+": "+totalSize);
		
	}
    }
    
}
