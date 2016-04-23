import java.util.Scanner;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	while(tc.hasNextInt()){
	    int v = tc.nextInt();
	    int t = tc.nextInt();
	    System.out.println(v*(2*t));
	}	
    }
}

