import java.util.Scanner;

// Se saca con coeficientes multinomiales https://en.wikipedia.org/wiki/Multinomial_theorem n!/(k1!*k2!*k3!*...*kk!) //

public class Main{
    
    public static int factorial(int n){
	if(n==0 || n==1) return 1;
	else{
	    int res = 1;
	    for(int i=1;i<=n;i++) res *= i;
	    return res;
	}
    }
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	while(tc.hasNextInt()){
	    int N = tc.nextInt();
	    int K = tc.nextInt();
	    int res = 1;
	    for(int i=0;i<K;i++) res*= factorial(tc.nextInt());
	    System.out.println(factorial(N)/res);
	}
	
    }
}
