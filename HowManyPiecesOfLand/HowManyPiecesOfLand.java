import java.util.Scanner;

public class HowManyPiecesOfLand {
	
	public static int binomial(int n,int k){
		int[][] mpd = new int[n+1][k+1];
		for(int i=0;i<n;i++) mpd[i][0] = 1;
		for(int i=1;i<k;i++) mpd[0][i] = 0;
		for(int i=1;i<n+1;i++){
			for(int j=1;j<k+1;j++){
				mpd[i][j] = mpd[i-1][j-1]+mpd[i-1][j];
			}
		}
		return mpd[n][k];
	}
	
	public static void main(String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCases = tc.nextInt();
		int[] res  = new int[nCases];
		int   n;
		for(int i=0;i<nCases;i++){
			n = tc.nextInt();
			res[i] = (binomial(n,4)+binomial(n,2))+1;
		}
		for(int i=0;i<nCases;i++) System.out.println(res[i]);	
	}
}

