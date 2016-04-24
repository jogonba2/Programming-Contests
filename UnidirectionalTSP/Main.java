import java.util.Scanner;

public class Main{
    
    public static int mod(int a,int b){
	return ((a % b) + b) % b;
    }
    
    public static void printMatrix(int[][] a){
	for(int i=0;i<a.length;i++){
	    for(int j=0;j<a[i].length;j++){
		System.out.print(a[i][j]+" ");
	    }
	    System.out.println();
	}
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	while(tc.hasNextInt()){
	    int m = tc.nextInt();
	    int n = tc.nextInt();
	    int[][] costs = new int[m][n];
	    int[][] dp = new int[n][m];
	    int[][] paths = new int[n][m];
	    for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
		    costs[i][j] = tc.nextInt();
		}
	    }
	    int mini = Integer.MAX_VALUE;
	    for(int i=0;i<m;i++){ dp[0][i] = costs[i][0]; }
	    for(int i=1;i<n;i++){
		for(int j=0;j<m;j++){
		    mini = dp[i-1][mod(j-1,m)];
		    paths[i][j] = mod(j-1,m);
		    if(dp[i-1][j]<mini){
			mini = dp[i-1][j];
			paths[i][j] = j;
		    }
		    if(dp[i-1][mod(j+1,m)]<mini){
			mini = dp[i-1][mod(j+1,m)];
			paths[i][j] = mod(j+1,m);
		    }
		    dp[i][j] = mini+costs[j][i];
		}
	    }
	    System.out.println("COSTES");
	    printMatrix(costs);
	    System.out.println("DP");
	    printMatrix(dp);
	    System.out.println("CAMINOS");
	    printMatrix(paths);
	    int[] path = new int[n];
	    // Encontrar el coste minimo de la ultima fila //
	    int ind = n-1;
	    mini = Integer.MAX_VALUE;
	    int cost;
	    int mi = -1;
	    for(int i=0;i<m;i++){
		if(dp[n-1][i]<=mini){
		    mini  = dp[n-1][i];
		    mi = i;
		}
	    }
	    cost = mini;
	    System.out.println("\n"+cost);
	    /////////////////////////////////////////////////
	    
	    
	}
    }
}

