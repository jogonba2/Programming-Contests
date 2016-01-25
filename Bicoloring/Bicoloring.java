import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Bicoloring {
	
	public static boolean bfs_coloring(int[][] m){
		int[] res = new int[m.length];
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		res[0]    = 1;
		q.add(Integer.valueOf(0));
		int altColor = -1;
		while(q.size()!=0){
			Integer node = q.poll();
			for(int i=0;i<m[node.intValue()].length;i++){
				if(m[node.intValue()][i]==1){
					if(res[i]!=0 && res[i]==res[node.intValue()]) return false;
					else{
						if(res[i]==1) altColor = 2;
						else          altColor = 1;
						res[i] = altColor;
						q.add(Integer.valueOf(i));
					}
				}
			}
		}
		return true;	
	}
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		ArrayList<Boolean> res = new ArrayList<Boolean>();
		int nodes = tc.nextInt();
		int edges = -1;
		if(nodes!=0) edges = tc.nextInt();
		while(nodes!=0){
			int[][] m = new int[nodes][nodes];
			for(int i=0;i<edges;i++){
				int a = tc.nextInt();
				int b = tc.nextInt();
				m[a][b] = 1;
			}
			res.add(Boolean.valueOf(bfs_coloring(m)));
			nodes = tc.nextInt();
			if(nodes==0) break;
			edges = tc.nextInt();
		}
		for(Boolean b : res) System.out.println(b); 
	}
}

