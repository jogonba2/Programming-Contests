import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Main{
	
	private static class Adyacente implements Comparable{
	    private int destino;
	    private int peso;
	    
	    public Adyacente(int destino,int peso){
		this.destino = destino;
		this.peso = peso;
	    }
	    public int getDestino(){ return this.destino; }
	    public int getPeso(){ return this.peso; }
	    
	    public void setDestino(int destino){ this.destino = destino; }
	    public void setPeso(int peso){ this.peso = peso; }
	    
	    public int compareTo(Object other){
		Adyacente o = (Adyacente) other;
		if(this.peso>o.getPeso()) return 1;
		else if(this.peso<o.getPeso()) return -1;
		return 0;
	    }
	}
	
	private static class Coste implements Comparable{
	    private int nodo;
	    private int coste;
	    
	    public Coste(int nodo,int coste){
		this.nodo = nodo;
		this.coste = coste;
	    }
	    public int getNodo(){ return this.nodo; }
	    public int getCoste(){ return this.coste; }
	    
	    public int compareTo(Object other){
		Coste o = (Coste) other;
		// Al reves para que en la cola de prioridad se seleccione siempre el mayor //
		if(this.coste<o.getCoste()) return 1;
		else if(this.coste>o.getCoste()) return -1;
		return 0;
	    }
	}
	
	public static int maxFlow(ArrayList<ArrayList<Adyacente>> graph,int ini,int end){
	    int[] flow = new int[graph.size()];
	    boolean[] visitado = new boolean[graph.size()];
	    for(int i=0;i<graph.size();i++) flow[i] = Integer.MAX_VALUE;
	    PriorityQueue<Coste> q = new PriorityQueue<Coste>();
	    q.add(new Coste(ini,Integer.MAX_VALUE));
	    while(q.size()>0){
		Coste v = q.poll();
		if(!visitado[v.getNodo()]){
		    visitado[v.getNodo()] = true;
		    for(Adyacente ady : graph.get(v.getNodo())){
			flow[ady.getDestino()] = Math.min(v.getCoste(),ady.getPeso());
			q.add(new Coste(ady.getDestino(),flow[ady.getDestino()]));
		    }
		}
	    }
	    return flow[end];
	}
	
	public static void main (String args[]) {
	    Scanner tc = new Scanner(System.in);
	    ArrayList<ArrayList<Adyacente>> graph = new ArrayList<ArrayList<Adyacente>>();
	    int N = tc.nextInt();
	    int R = tc.nextInt();
	    int C1,C2,P,ini,end,tourists;
	    int scenario = 1;
	    while(N>0 && R>0){
		// Inicializar ciudades //
		for(int i=0;i<N;i++) graph.add(new ArrayList<Adyacente>());
		for(int i=0;i<R;i++){
		    C1 = tc.nextInt();
		    C2 = tc.nextInt();
		    P  = tc.nextInt();
		    try{
			graph.get(C1-1).add(new Adyacente(C2-1,P));
			graph.get(C2-1).add(new Adyacente(C1-1,P));
		    }catch(Exception e){}
		}
		ini = tc.nextInt()-1;
		end = tc.nextInt()-1;
		tourists = tc.nextInt();
		System.out.println("Scenario #"+scenario);
		if(ini==end) System.out.println("Minimum Number of Trips = "+1);
		else System.out.println("Minimum Number of Trips = "+(int)Math.ceil((float)tourists/(maxFlow(graph,ini,end)-1)));
		System.out.println();
		N = tc.nextInt();
		R = tc.nextInt();
		scenario++;
	    }
	}
}

