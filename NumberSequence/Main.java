import java.util.Scanner;
// http://oeis.org/search?q=1%2C1%2C2%2C1%2C2%2C3%2C1%2C2%2C3%2C4%2C1%2C2%2C3%2C4%2C5%2C1%2C2%2C3%2C4%2C5%2C6%2C1%2C2%2C3%2C4%2C5%2C6%2C7&language=english&go=Search
public class Main{
    
    /**public static void main(String args[]) {
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	for(int i=0;i<nCases;i++){
	    long n = tc.nextLong();
	    long m = (long)Math.floor((-1+Math.sqrt(8*n-7))/2);
	    System.out.println(String.valueOf(n-m*(m+1)/2));
	    tc.nextLine();
	}
    }**/
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	for(int i=0;i<nCases;i++){
	    long n = tc.nextLong();
	    long q=1,m=0,sm=0;
	    while(sm<n){
		sm += q;
		m  += q-1;
		q++;
	    }
	    System.out.println(n-m);
	}
	
    }
}
