import java.util.Scanner;
import java.math.BigInteger;
import java.util.HashMap;

public class Main{
    
	public static boolean carmichael[] = new boolean[650000];
	
	public static boolean fermat(int n){
	    BigInteger a = BigInteger.valueOf(2);
	    BigInteger r = BigInteger.valueOf(n);
	    int i=2;
	    for(i=2;i<n;i++){
		if(a.modPow(r,r).compareTo(a)!=0) return false;
		a = a.add(BigInteger.valueOf(1));
	    }
	    return true;
	}
	
	public static boolean isPrime(int n){
	    if(n%2==0) return false;
	    else{
		for(int i=3;i*i<=n;i+=2){
		    if(n%i==0) return false;
		}
	    }
	    return true;
	}
	
	public static void preprocessCharmichael(){
	    int n = 3;
	    for(n=52632;n<65000;n++){
		if(n%2!=0 && fermat(n) && !isPrime(n)) carmichael[n] = true;
	    }
	    for(int i=0;i<65000;i++){ 
		if(carmichael[i]!=false) System.out.println("Carmichael: "+i);
	    }
	}
	
	public static void main(String args[]) {
	    Scanner tc = new Scanner(System.in);
	    //preprocessCharmichael();
	    carmichael[561] = carmichael[1105] = carmichael[1729] = carmichael[2465] = carmichael[2821] = carmichael[6601] = carmichael[8911] = carmichael[10585] = carmichael[15841] = carmichael[29341] = true;
	    carmichael[41041] = carmichael[46657] = carmichael[52633] = carmichael[62745] = carmichael[63973] = true;
	    int n = tc.nextInt();
	    while(n>0){
		if(carmichael[n]) System.out.println("The number "+n+" is a Carmichael number.");
		else System.out.println(n+" is normal.");
		n = tc.nextInt();
	    }
	}
}

