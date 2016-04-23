import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    
    private static boolean isPrime(int num) {
        if (num == 2 ) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
    
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
    
    private static int primoCuartaParte(int num){
	for(int i=(int)Math.ceil(num/4.0);i>=1;i--){
	    if(i%2!=0 || i==2){
		if(isPrime(i)) return i;
	    }
	}
	return -1;
    }
    
    private static void goldbach(int n,ArrayList<Integer> primes){
	boolean found = false;
	int p;
	// EL 1 NO ES PRIMO!! //
	for(int i=1;i<primes.size() && !found;i++){
	    p = primes.get(i);
	    if(isPrime(n-p)){
		System.out.println(p+" "+(n-p));
		found = true;
	    }
	}
    }
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int n;
	ArrayList<Integer> primes = criba(3500000);
	while(tc.hasNextInt()){
	    n = tc.nextInt();
	    if(n<8) System.out.println("Impossible.");
	    else{
		int a,b,c,d;
		a = primoCuartaParte(n);
		n = n-a;
		if(n%2==0) b = 2;
		else b=3;
		n = n-b;
		System.out.print(a+" "+b+" ");
		goldbach(n,primes);
	    }
	
	}	
    }
}

