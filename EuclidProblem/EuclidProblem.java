import java.util.ArrayList;
import java.util.Scanner;

class EuclidProblem {
	
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
		long a,b;
		ArrayList<Long> res = new ArrayList<Long>();
		while(tc.hasNext()){
			a = tc.nextLong();
			b = tc.nextLong();
			res = euclid_extended(a,b);
			System.out.println(res.get(0)+" "+res.get(1)+" "+res.get(2));
		}
	}
}

