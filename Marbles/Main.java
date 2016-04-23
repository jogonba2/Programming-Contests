import java.util.Scanner;
import java.util.ArrayList;

// Ecuacion diofantica https://es.wikipedia.org/wiki/Ecuaci%C3%B3n_diof%C3%A1ntica //

public class Main{
    
    public static ArrayList<Long> euclid_extended(long a,long b){
	long r0,r1,x0,x1,y0,y1,q,aux;
	ArrayList<Long> res = new ArrayList<Long>();
	r0 = a; r1 = b;
	x0 = 1; x1 = 0;
	y0 = 0; y1 = 1;
	while(r1!=0){
	    q   = r0/r1;
	    aux = r1;
	    r1  = r0%r1;
	    r0  = aux;
	    aux = x1;
	    x1  = x0 - (q*x1);
	    x0  = aux; 
	    aux = y1;
	    y1  = y0 - (q*y1);
	    y0  = aux;
	}
	res.add(x0); res.add(y0); res.add(r0); 
	return res;
    }
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	long n = tc.nextLong();
	while(n!=0){
	    long c1,c2,n1,n2;
	    c1 = tc.nextLong();
	    n1 = tc.nextLong();
	    c2 = tc.nextLong();
	    n2 = tc.nextLong();
	    ArrayList<Long> m = euclid_extended(n1,n2);
	    boolean failed = false;
	    long x = m.get(0), y = m.get(1), mcd = m.get(2);
	    if(n%mcd!=0){ System.out.println("failed"); failed = true; }
	    else{
		x *= n / mcd;
		y *= n / mcd;
		n1 /= mcd;
		n2 /= mcd;
		long c = (long)Math.ceil(-(double)x/n2);
		long f = (long)Math.floor((double)y/n1);
		if(c>f){ System.out.println("failed"); failed = true; }
		if(!failed){
		    long cost = c1*n2 - c2*n1;
		    long res1,res2;
		    if(cost*c<cost*f){
			res1 = x+n2*c;
			res2 = y-n1*c;
		    }
		    else{
			res1 = x+n2*f;
			res2 = y-n1*f;
		    }
		    System.out.println(res1+" "+res2);
		}
	    }
	    n = tc.nextLong();
	}		
    }
}

