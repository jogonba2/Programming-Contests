import java.util.Scanner;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int a = tc.nextInt();
	int b = tc.nextInt();
	while(a!=0 && b!=0){
	    int c = 0;
	    for(int i=a;i<=b;i++){
		if(Math.sqrt(i)==Math.floor(Math.sqrt(i))) c++;
	    }
	    System.out.println(c);
	    a = tc.nextInt();
	    b = tc.nextInt();
	}	
    }
}

