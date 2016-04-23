import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    
    private static ArrayList<Long> criba(int MAX){
	int i,j;
	boolean[] esPrimo = new boolean[MAX];
	ArrayList<Long> primes = new ArrayList<Long>();
	esPrimo[0] = false;    
	for (i = 0; i< MAX;i++) esPrimo[i] = true;
	for(i = 2 ; i <= (MAX/2);i++)
	    for(j = 2; j<=(MAX/i); j++) esPrimo[i*j - 1] = false;
	for(i=0;i<MAX;i++){
	    if(esPrimo[i]) primes.add((long)i+1);
	}
	return primes;
    }
    
    private static void factorization(long x,ArrayList<Long> primes){	
	for(int i=1;i<primes.size();i++){
	    if(x<primes.get(i)){ break; }
	    while(x%primes.get(i)==0){
		System.out.println("    "+primes.get(i));
		x /= primes.get(i);
	    }
	}
	if(x>1) System.out.println("    "+x);
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	long n = tc.nextLong();
	ArrayList<Long> primes = criba(1000001);
	while(n!=-1){
	    factorization(n,primes);
	    System.out.println();
	    n = tc.nextLong();
	    
	    
	}
    }
}

