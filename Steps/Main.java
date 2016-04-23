import java.util.Scanner;

public class Main{
	// https://oeis.org/A000267
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCases = tc.nextInt();
		int ini,end,diff;
		for(int i=0;i<nCases;i++){
			ini = tc.nextInt();
			end = tc.nextInt();
			diff = end-ini-1;
			System.out.println((int)Math.floor(Math.sqrt(diff)+Math.sqrt(diff+2)));
		}
	}
}

