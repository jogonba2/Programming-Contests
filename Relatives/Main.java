import java.util.Scanner;


public class Main{
    
    public static int euler_pi(int x){
	int i,c,exp,eulerpi = 1;
	c = x;
	exp = 0;
	while((c%2)==0){
	    exp++;
	    c = c/2;
	}
	if(exp>0) eulerpi *= (Math.pow(2,exp)-Math.pow(2,exp-1));
	exp = 0;
	i   = 3;
	while(i<=(Math.sqrt(c)+1)){
	    if((c%i)==0){
		exp = 0;
		while((c%i)==0){
		    exp++;
		    c = c/i;
		}
		eulerpi *= (Math.pow(i,exp)-Math.pow(i,exp-1));
	    }
	    else i += 2;
	}
	if(c>1) eulerpi *= (c-1);
	return eulerpi;
    }
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int n = tc.nextInt();
	while(n>0){
	    if(n==1) System.out.println(0);
	    else     System.out.println(euler_pi(n));
	    n = tc.nextInt();
	}
	
    }
    
}
