import java.util.Scanner;

public class Main{
	
    public static void main(String args[]) {
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	long K,A,B,C,D;
	int c;
	for(int i=0;i<nCases;i++){
	    K = tc.nextLong();
	    A=-1;B=-1;C=-1;D=-1;
	    c = 0;
	    for(int j=2;j<=K/2;j++){
		if(K%j==0 && c==0){
		    A = j; B = K/j;
		    c++;
		}
		else if(K%j==0 && c==1){
		    C = j; D = K/j;
		    break;
		}
	    }
	    System.out.println("Case #"+i+": "+K+" = "+A+" * "+B+" = "+C+" * "+D);
	    
	}
    }
}

