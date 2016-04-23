import java.util.Scanner;

public class Main{
	
	public static void main (String args[]) {
	    Scanner tc = new Scanner(System.in);
	    int nCases = tc.nextInt();
	    for(int i=0;i<nCases;i++){
		double d = tc.nextInt();
		double v = tc.nextInt();
		double u = tc.nextInt();
		if(v>=u || u==0 || v==0 || d==0 ) System.out.println("Case "+(i+1)+": can't determine");
		else                              System.out.printf("Case "+(i+1)+": %.3f\n",((1.0*(d/Math.sqrt((u*u)-(v*v))-d*(1.0/u)))));
	    }
	}
}

