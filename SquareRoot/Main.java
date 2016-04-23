import java.math.BigInteger;
import java.util.Scanner;

public class Main{
    
    public static BigInteger sqrt(BigInteger x) {
	BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	BigInteger div2 = div;
	for(;;) {
	    BigInteger y = div.add(x.divide(div)).shiftRight(1);
	    if (y.equals(div) || y.equals(div2)) return y;
	    div2 = div;
	    div = y;
	}
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	//tc.nextLine(); // Linea en blanco
	for(int i=0;i<nCases;i++){
	    BigInteger n = tc.nextBigInteger();
	    System.out.println(sqrt(n).toString());
	    if(i!=nCases-1) System.out.println();
	}
    }
}

