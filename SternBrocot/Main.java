import java.util.*;

class Main {
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int p = tc.nextInt();
	int q = tc.nextInt();
	while(p!=1 || q!=1){
	    int i0=0,i1=1,c0=1,c1=1,d0=1,d1=0;	   
	    while(c0!=p || c1!=q){
		if(c1*p > c0*q){
		//if((float)p/q>(float)c0/c1){
		    System.out.print("R");
		    i0 = c0;
		    i1 = c1;
		    c0 = c0+d0;
		    c1 = c1+d1;
		}
		else{
		//if((float)p/q<(float)c0/c1){
		    System.out.print("L");
		    d0 = c0;
		    d1 = c1;
		    c0 = c0+i0;
		    c1 = c1+i1;
		}
	    }
	    System.out.println();
	    p = tc.nextInt();
	    q = tc.nextInt();
	}
    }
}
