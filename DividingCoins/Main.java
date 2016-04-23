import java.util.Scanner;


public class Main{
    
    public static int knapsack(int[] v,int i,int c){
	if(i==0 || c==0) return 0;
	else if(c-v[i-1]>=0) return Math.max(knapsack(v,i-1,c),knapsack(v,i-1,c-v[i-1])+v[i-1]);
	else return knapsack(v,i-1,c);
    }
    
    public static int knapsack_dp(int[] v,int N){
	int[][] dp = new int[v.length+1][N+1];
	for(int i=0;i<v.length;i++) dp[i][0] = 0;
	for(int c=0;c<N;c++)        dp[0][c] = 0;
	for(int i=1;i<v.length+1;i++){
	    for(int c=1;c<N+1;c++){
		if(c-v[i-1]>=0) dp[i][c] = Math.max(dp[i-1][c],dp[i-1][c-v[i-1]]+v[i-1]);
		else            dp[i][c] = dp[i-1][c];
	    }
	}
	return dp[v.length][N];
    }
    // Mochila hasta N/2 //
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	for(int i=0;i<nCases;i++){
	    int size = tc.nextInt();
	    int v[]  = new int[size];
	    int N    = 0;
	    for(int j=0;j<size;j++){
		v[j] = tc.nextInt();
		N   += v[j];
	    }
	    int me = knapsack_dp(v,N/2);
	    int other = N-me;
	    int diff  = other-me;
	    System.out.println(diff);
	    
	}
	
    }
    
    
}
