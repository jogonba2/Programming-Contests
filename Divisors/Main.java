import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    
    private static ArrayList<Integer> criba(int MAX){
	int i,j;
	boolean[] esPrimo = new boolean[MAX];
	ArrayList<Integer> primes = new ArrayList<Integer>();
	esPrimo[0] = false;    
	for (i = 0; i< MAX;i++) esPrimo[i] = true;
	for(i = 2 ; i <= (MAX/2);i++)
	    for(j = 2; j<=(MAX/i); j++) esPrimo[i*j - 1] = false;
	for(i=0;i<MAX;i++){
	    if(esPrimo[i]) primes.add(i+1);
	}
	return primes;
    }
    
    private static int getDivisors(int x,ArrayList<Integer> sieve){ 
	int divisors  = 1;
	int aux_count = 0;
	int c = x;
	for(int i=1;i<sieve.size() && c>1;i++){
	    while((c%sieve.get(i))==0){
		aux_count++;
		c = c / sieve.get(i);
	    }
	    divisors *= (aux_count+1);
	    aux_count = 0;
	}
	return divisors;
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	ArrayList<Integer> sieve = criba((int)Math.sqrt(1000000000)+1000);
	int nCases = tc.nextInt();
	for(int i=0;i<nCases;i++){
	    int a = tc.nextInt();
	    int b = tc.nextInt();
	    int max  = -1;
	    int nmax = -1;
	    int aux  = -1;
	    for(int j=a;j<=b;j++){
		aux = getDivisors(j,sieve);
		if(aux>max){
		    max  = aux;
		    nmax = j;
		}
	    }
	    System.out.println("Between "+a+" and "+b+", "+nmax+" has a maximum of "+max+" divisors.");
	}
    }
}

