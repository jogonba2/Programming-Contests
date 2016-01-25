import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Scanner;

public class HowManyFibs {
	
	public static ArrayList<BigInteger> fibo(int digits){
		ArrayList<BigInteger> fibs = new ArrayList<BigInteger>();
		fibs.add(BigInteger.valueOf(1)); fibs.add(BigInteger.valueOf(2));
		int size = fibs.size();
		while(String.valueOf(fibs.get(fibs.size()-1)).length()<digits){ 
			fibs.add(fibs.get(size-1).add(fibs.get(size-2)));
			size = fibs.size();
		}
		return fibs;
	}
	
	public static int numfibos(ArrayList<BigInteger> fibs,BigInteger a,BigInteger b){
		int res = 0;
		for(BigInteger c : fibs){
			if(c.compareTo(a)>=0 && c.compareTo(b)<=0) res += 1;
			else if(c.compareTo(b)>0) break;
		}
		return res;
	}
			
	public static void main(String args[]) {
		ArrayList<BigInteger> fibs = fibo(100);
		ArrayList<Integer> res     = new ArrayList<Integer>();
		BigInteger a,b;
		Scanner tc = new Scanner(System.in);
		a = new BigInteger(tc.next());
		b = new BigInteger(tc.next());
		while(a.compareTo(BigInteger.valueOf(0))!=0 && b.compareTo(BigInteger.valueOf(0))!=0){
			res.add(Integer.valueOf(numfibos(fibs,a,b)));
			a = new BigInteger(tc.next());
			b = new BigInteger(tc.next());
		}
		for(Integer e : res) System.out.println(e);		
	}
}

