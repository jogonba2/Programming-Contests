import java.util.Scanner;


import java.util.Scanner;

public class Main{
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	for(int i=0;i<nCases;i++){
	    int n = tc.nextInt();
	    int m = tc.nextInt();
	    System.out.println((n/3)*(m/3));
	}
	
    }
    
}
