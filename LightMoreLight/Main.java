import java.util.Scanner;

public class Main{
	
	// La sucesion describe los cuadrados perfectos. Si raiz(n)==entero -> !SI! //
	public static void main (String args[]) {
	    Scanner tc = new Scanner(System.in);
	    long n = tc.nextLong();
	    while(n>0){
		if(Math.sqrt(n)-Math.floor(Math.sqrt(n))==0) System.out.println("yes");
		else System.out.println("no");
		n = tc.nextLong();
	    }
	}
}

