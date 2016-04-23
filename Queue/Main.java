import java.util.Scanner;

public class Main{
	
	public static int fact(int a){
	    int r = 1;
	    for(int i=2;i<=a;i++) r*=i;
	    return r;
	}
	
	public static int comb(int a,int b){
	    return fact(a)/(fact(b)*fact(a-b));
	}
	
	public static int Q(int N,int P,int R){
	    if((N==1 && P==1 && R==1) || (N==2 && P==1 && R==2) || (N==2 && P==2 && R==1)) return 1;
	    else{
		if(R==1 && P>=1){
		    int sum = 0;
		    for(int k=P-1;k<N;k++){
			sum += Q(k,P-1,1) * comb(N-2,k-1) * fact(N-k-1);
		    }
		    return sum;
		}
		else if(P>=R && R>1){
		    int sum = 0;
		    for(int k=P;k<=N-R+1;k++){
			sum += Q(k,P,1) * comb(N-1,k-1) * Q(N-k+1,R,1);
		    }
		    return sum;
		}
		else return 0;
	    }
	}
	
	public static void main(String args[]) {
	    Scanner tc = new Scanner(System.in);
	    int nCases = tc.nextInt();
	    for(int i=0;i<nCases;i++){
		int N = tc.nextInt();
		int P = tc.nextInt();
		int R = tc.nextInt();
		System.out.println(Q(N,Math.max(P,R),Math.min(P,R)));
	    }
	}
}

