import java.util.Scanner;
import java.math.BigInteger;

public class Main{
	private static BigInteger[] res;
	
	public static void setCounts(){
	    int i;
	    res[0] = BigInteger.valueOf(1);
	    res[1] = BigInteger.valueOf(-2);
	    res[2] = BigInteger.valueOf(5);
	    for(i=3;i<1001;i++){
		res[i] = BigInteger.valueOf(-2).multiply(res[i-1]).add(res[i-2]).subtract(res[i-3]);
	    }
	}
	
	public static void main (String args[]) {
	    res = new BigInteger[1001];
	    setCounts();
	    Scanner tc = new Scanner(System.in);
	    while(tc.hasNextInt()){
		System.out.println(res[tc.nextInt()].abs().toString());
	    }
	}
}

