import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.ArrayList;

class PlayingWithWheels {
	
	public static ArrayList<Integer> get_successors(int v){
		ArrayList<Integer> res = new ArrayList<Integer>();
		int[] va = new int[4];
		for(int i=0;i<4;i++){ va[3-i] = v%10; v /= 10; }
		res.add((va[0]*1000)+(va[1]*100)+(va[2]*10)+(((va[3]+1) % 10)+(va[3]+1 < 0 ? 10 : 0)));
		res.add((va[0]*1000)+(va[1]*100)+(va[2]*10)+(((va[3]-1) % 10)+(va[3]-1 < 0 ? 10 : 0)));
		res.add((va[0]*1000)+(va[1]*100)+((((va[2]+1) % 10)+(va[2]+1 < 0 ? 10 : 0))*10)+va[3]);
		res.add((va[0]*1000)+(va[1]*100)+((((va[2]-1) % 10)+(va[2]-1 < 0 ? 10 : 0))*10)+va[3]);	
		res.add((va[0]*1000)+((((va[1]+1) % 10)+(va[1]+1 < 0 ? 10 : 0))*100)+(va[2]*10)+va[3]);
		res.add((va[0]*1000)+((((va[1]-1) % 10)+(va[1]-1 < 0 ? 10 : 0))*100)+(va[2]*10)+va[3]);	
		res.add(((((va[0]+1) % 10)+(va[0]+1 < 0 ? 10 : 0))*1000)+(va[1]*100)+(va[2]*10)+va[3]);
		res.add(((((va[0]-1) % 10)+(va[0]-1 < 0 ? 10 : 0))*1000)+(va[1]*100)+(va[2]*10)+va[3]);
		return res;
	}
	
	public static int get_steps_bfs(int ini,int end,HashMap<Integer,Integer> forbidden){
		boolean[] visitados = new boolean[10000];
		visitados[ini] = true;
		int i = 0;
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		q.add(ini);
		while(q.size()!=0 && !visitados[end]){
			int u = q.poll().intValue();
			i += 1;
			ArrayList<Integer> successors = get_successors(u);
			for(Integer v : successors){
				if(!visitados[v.intValue()] && forbidden.get(v)==null){
					visitados[v.intValue()] = true;
					q.add(v);
				}
			}
		}
		if(visitados[end]==false) return -1;
		return i;
	}
		
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int a,b,c,d;
		int nCases = tc.nextInt();
		int ini,end,nForbidden,auxForbidden,nSteps;
		tc.nextLine(); // Clear buffer
		for(int i=0;i<nCases;i++){
			HashMap<Integer,Integer> forbidden = new HashMap<Integer,Integer>();
			a = tc.nextInt();
			b = tc.nextInt();
			c = tc.nextInt();
			d = tc.nextInt();
			ini = (a*1000)+(b*100)+(c*10)+d;
			a = tc.nextInt();
			b = tc.nextInt();
			c = tc.nextInt();
			d = tc.nextInt();
			end = (a*1000)+(b*100)+(c*10)+d;
			nForbidden = tc.nextInt();
			for(int j=0;j<nForbidden;j++){
				a = tc.nextInt();
				b = tc.nextInt();
				c = tc.nextInt();
				d = tc.nextInt();
				auxForbidden = (a*1000)+(b*100)+(c*10)+d;
				forbidden.put(auxForbidden,auxForbidden);
			}
			nSteps = get_steps_bfs(ini,end,forbidden);
			System.out.println(nSteps);
		}
	}
}

