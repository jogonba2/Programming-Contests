import java.util.Scanner;

public class Main{
    
    public static int modpow(int value , int power, int mod){
	int e = 1;
	for (int i = 0; i < power; i++) { e = ((e * value) % mod); }
        return e;
    }
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	try{
	    int c = 1;
	    while(tc.hasNextInt()){
		int M = tc.nextInt();
		int n = tc.nextInt();
		int[] numbers = new int[n];
		for(int i=0;i<n;i++) numbers[i] = tc.nextInt();
		if(n>1){
		    int res = modpow(numbers[n-2],numbers[n-1],M);
		    for(int i=n-3;i>=0;i--){
			res = modpow(numbers[i],res,M);
		    }
		    System.out.println("Case #"+c+": "+res);
		}else{
		   System.out.println("Case #"+c+": "+numbers[0]); 
		}c++;
	    }
	}catch(Exception e){ System.out.println(e.getMessage());}
	
	
    }
}
