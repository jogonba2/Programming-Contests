import java.util.Scanner;

public class Main{
    
    // a*b = mcd(a,b)*mcm(a,b) (a|mcm(a,b)(1) , b|mcm(a,b)(2) , mcd(a,b)|a (3) , mcd(a,b)|b (4), mcd(a,b)|mcm(a,b) (5) ) --> a = mcd(a,b) y b = mcm(a,b) //
    // Solo cuando a|b por (5) //
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	for(int i=0;i<nCases;i++){
	    int a = tc.nextInt();
	    int b = tc.nextInt();
	    if(b%a==0) System.out.println(a+" "+b);
	    //else       System.out.println(-1);
	}
    }
    
}
