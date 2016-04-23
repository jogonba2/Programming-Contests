import java.util.Scanner;
import java.math.BigInteger;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	while(tc.hasNextInt()){
	    int N = tc.nextInt();
	    BigInteger A = tc.nextBigInteger();
	    BigInteger sum = new BigInteger("0");
	    for(int i=1;i<=N;i++) sum = sum.add(BigInteger.valueOf((long)i).multiply(A.pow(i)));
	    //for(int i=1;i<=N;i++); //sum//sum += i*Math.pow(A,i);
	    System.out.println(sum.toString());
	    
	}	
    }
}

