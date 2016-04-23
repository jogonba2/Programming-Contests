import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

class Main{
	
	public static int maxFlowFloyd(int[][] graph,int ini,int end){
	    for(int k=0;k<graph.length;k++){
		for(int i=0;i<graph.length;i++){
		    for(int j=0;j<graph.length;j++){
			graph[i][j] = Math.max(graph[i][j],Math.min(graph[i][k],graph[k][j]));
		    }
		}
	    }
	    return graph[ini][end];
	}
	
	public static void main (String args[]) {
	    Scanner tc = new Scanner(System.in);
	    int N = tc.nextInt();
	    int R = tc.nextInt();
	    int C1,C2,P,ini,end,tourists;
	    int scenario = 1;
	    while(N>0 && R>0){
		int[][] graph = new int[N][N];
		for(int i=0;i<R;i++){
		    C1 = tc.nextInt();
		    C2 = tc.nextInt();
		    P  = tc.nextInt();
		    graph[C1-1][C2-1] = P-1;
		    graph[C2-1][C1-1] = P-1;
		}
		ini = tc.nextInt()-1;
		graph[ini][ini] = Integer.MAX_VALUE; // Capacidad maxima del primero -> infinito, 0 viajes //
		end = tc.nextInt()-1;
		tourists = tc.nextInt();
		System.out.println("Scenario #"+scenario);
		System.out.println("Minimum Number of Trips = "+(int)Math.ceil(((float)tourists/(maxFlowFloyd(graph,ini,end)))));
		N = tc.nextInt();
		R = tc.nextInt();
		System.out.println();
		scenario++;
	    }
	}
}

