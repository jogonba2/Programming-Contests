import java.util.Scanner;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	long a,b;
	a = tc.nextLong();
	b = tc.nextLong();
	int i = 1;
	while(a!=0 && b!=0){
	   System.out.println("Case "+i+": "+(a*b*(a-1)*(b-1))/4);
	   i++;
	   a = tc.nextLong();
	   b = tc.nextLong();
	}	
    }
}

