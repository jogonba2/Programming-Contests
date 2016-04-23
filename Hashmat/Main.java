import java.util.Scanner;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	while(tc.hasNextLong()){
	    long me  = tc.nextLong();
	    long you = tc.nextLong();
	    System.out.println(Math.abs(you-me));
	}	
    }
}

