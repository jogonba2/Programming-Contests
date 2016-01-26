import java.math.BigInteger;
import java.util.Scanner;

class DistinctSubsequences{
	/** f(a,b,i,j) = 
						* 1 si i==0 ^ a[i]==b[j]
						* 0 si a[i]!=b[j]
						* sum(f(i-1,j-p)) para toda 0<=p<j si a[i] == b[j]
    **/	
    
    public static BigInteger get_subsequences(String w1,String w2){
		BigInteger[][] dpm = new BigInteger[w2.length()][w1.length()];
		// Rellenar primera fila //
		for(int j=0;j<w1.length();j++){
			if(w2.charAt(0)==w1.charAt(j)) dpm[0][j]=BigInteger.valueOf(1);
			else                           dpm[0][j]=BigInteger.valueOf(0);
		}
		for(int i=1;i<w2.length();i++){
			for(int j=0;j<w1.length();j++){
				if(w2.charAt(i)!=w1.charAt(j)) dpm[i][j]=BigInteger.valueOf(0);
				else{
					BigInteger sum = new BigInteger("0");
					for(int p=0;p<j;p++){ sum = sum.add(dpm[i-1][p]); }
					dpm[i][j] = sum;
				}
			}
		}	
		BigInteger res = new BigInteger("0");
		for(int i=0;i<w1.length();i++) res = res.add(dpm[w2.length()-1][i]);
		return res;
	}
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCases = tc.nextInt();
		tc.nextLine(); // Clear buffer
		String w1,w2;
		for(int i=0;i<nCases;i++){
			w1 = tc.nextLine();
			w2 = tc.nextLine();
			System.out.println(get_subsequences(w1,w2));
		}
	}
}

