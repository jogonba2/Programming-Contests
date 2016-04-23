import java.util.Scanner;
import java.util.ArrayList;

public class Main{

    private static class Tuple<X extends Comparable,Y extends Comparable> implements Comparable< Tuple<X,Y> > {
	
	private final X left;
	private final Y right;
	
	public Tuple(X right,Y left){
		this.left  = right;
		this.right = left;
	}
	
	public X getLeft(){ return this.left; }
	public Y getRight(){ return this.right; }
	
	public boolean equals(Object o){
		if(o==null) return false;
		if(o==this) return true;
		if(!(o instanceof Tuple)) return false;
		return ((Tuple<X,Y>)o).left==this.left && ((Tuple<X,Y>)o).right==this.right;
	}

	public int compareTo(Tuple<X,Y> other){ 
		return this.right.compareTo(other.right);	
	}
    }	
    /**private static ArrayList<Tuple> factorize(int n){
	int i;
	int c,cont = 0;
	c = n;
	ArrayList<Tuple> primeFactors = new ArrayList<Tuple>();
	while((c%2)==0){ c = c/2; cont++; }
	if(cont>0) primeFactors.add(new Tuple(2,cont));
	i = 3;
	cont = 0;
	while(i<=(Math.sqrt(c)+1)){
	    if((c%i)==0){
		cont++;
		c = c/i;
	    }
	    else{
		if(cont>0){ primeFactors.add(new Tuple(i,cont)); }
		i = i+2;
		cont = 0;
	    }
	}
	if(c>1) primeFactors.add(new Tuple(c,1));
	return primeFactors;
	    
    }**/
    private static ArrayList<Tuple> factorize(int n){ 
	ArrayList<Tuple> primeFactors = new ArrayList<Tuple>();
	int counter = 0;
	while((n%2)==0) { counter++; n/=2; }
	if(counter>0) primeFactors.add(new Tuple(2,counter));
	int i=3;
	int last_i = -1;
	int ii = i*i;
	counter = 0;
	while(ii<=n){
	    if((n%i)==0){
		counter++;
		n /= i;
		last_i = i;
	    } else {
		if(counter>0) primeFactors.add(new Tuple(last_i,counter));
		ii += (i<<2)+4;
		i += 2;
		counter = 0;
	    }
	}
	if(counter>0){
	    if(n==last_i){ counter++; n=1; }
	    primeFactors.add(new Tuple(last_i,counter));
	}
	if(n>1) primeFactors.add(new Tuple(n,1));
	return primeFactors;
	    
    }
    
    public static boolean mDividesNFactorial(Tuple primeFactors,int n){
	int factor   = (int)primeFactors.getLeft();
	int exponent = (int)primeFactors.getRight();
	int x;
	while(exponent>0 && factor<=n){
	    x = factor;
	    while((x%(int)primeFactors.getLeft())==0){
		--exponent;
		x /= (int)primeFactors.getLeft();
	    }
	    factor += (int)primeFactors.getLeft();
	}
	return (exponent<=0);
    }
	
    public static void main(String[] args) throws Exception {
        Scanner tc = new Scanner(System.in);
        while (tc.hasNextInt()) {
            int n = tc.nextInt();
            int m = tc.nextInt();
	    if(m==0) System.out.println(m+" does not divide "+n+"!");
	    else{
		ArrayList<Tuple> primeFactors = factorize(m);
		boolean divides = true;
		for(int i=0;i<primeFactors.size() && divides;i++){
		    System.out.println(primeFactors.get(i).getRight()+","+primeFactors.get(i).getLeft());
		    //if(!mDividesNFactorial(primeFactors.get(i),n)) divides = false;
		}
		if(divides) System.out.println(m+" divides "+n+"!");
		else        System.out.println(m+" does not divide "+n+"!");
	    }
	}
    }
}
