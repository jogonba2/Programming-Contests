import java.math.BigInteger;
import java.util.Scanner;

public class ReverseAndAdd{
	
	public static String reverse(String s){
		String reverse = "";
		for(int i=s.length()-1;i>=0;i--) reverse += s.charAt(i);
		return reverse;
	}
	
	public static boolean is_palindrome(String s){ return s.equals(reverse(s)); }
		
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCases = tc.nextInt();
		tc.nextLine(); // Clear buffer //
		int[] minIterations = new int[nCases];
		BigInteger[] resPalind     = new BigInteger[nCases];
		String p,rev;
		int it = 0;
		for(int i=0;i<nCases;i++){
			p   = tc.nextLine();
			if(is_palindrome(p)){ minIterations[i] = 0; resPalind[i] = new BigInteger(p); continue; }
			rev = reverse(p);
			it = 0;
			while(!is_palindrome(rev)){
				p = String.valueOf((new BigInteger(p)).add(new BigInteger(rev)));
				rev = reverse(p);
				it += 1;
			}
			resPalind[i]     = new BigInteger(p);
			minIterations[i] = it;
		}
		for(int i=0;i<nCases;i++) System.out.println(minIterations[i]+" "+resPalind[i]);	
	}
}
