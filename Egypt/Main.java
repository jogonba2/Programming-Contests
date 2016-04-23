import java.util.Scanner;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	long a = tc.nextLong();
	long b = tc.nextLong();
	long c = tc.nextLong();
	while(a!=0 && b!=0 && c!=0){
	    double A,B,C;
	    if((a*a)+(b*b)==(c*c)) System.out.println("right");
	    else if((a*a)+(c*c)==(b*b)) System.out.println("right");
	    else if((b*b)+(c*c)==(a*a)) System.out.println("right");
	    else System.out.println("wrong");
	    a = tc.nextLong(); b = tc.nextLong(); c = tc.nextLong();
	}	
    }
}

