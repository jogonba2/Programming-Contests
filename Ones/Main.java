import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;
class Main{
	
	public static int countDigits(BigInteger i){
		BigInteger z= new BigInteger("1");
		while(z.mod(i).compareTo(BigInteger.valueOf(0))!=0) z = z.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(1));
		return z.toString().length();
	}
	public static void main(String args[]){
		Scanner tc = new Scanner(System.in);
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(tc.hasNextInt()){
			BigInteger i = tc.nextBigInteger();
			res.add(countDigits(i));
		}
		for(Integer e : res) System.out.println(e);
	}
}
