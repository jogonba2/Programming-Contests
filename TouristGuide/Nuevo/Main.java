import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

class Main{
	
	private static class Ciudad{
	    
	    private int id;
	    private int capMaxima;
	    private boolean enCola;
	    private LinkedList<Ciudad> adyacentes;
	    private LinkedList<Integer> capCiudades;
	    
	    public Ciudad(int id,int capMaxima,boolean enCola){
		this.id = id;
		this.capMaxima = capMaxima;
		this.enCola = enCola;
		this.adyacentes = new LinkedList<Ciudad>();
		this.capCiudades = new LinkedList<Integer>();
	    }
	    
	    public int getId(){ return this.id; }
	    public int getCapMaxima(){ return this.capMaxima; }
	    public boolean getEnCola(){ return this.enCola; }
	    public LinkedList<Ciudad> getAdyacentes(){ return this.adyacentes; }
	    public Ciudad getAdyacente(int i){ return this.adyacentes.get(i); }
	    public LinkedList<Integer> getCapCiudades(){ return this.capCiudades; }
	    public int getCapCiudad(int i){ return this.capCiudades.get(i).intValue(); }
	    public void setId(int id){ this.id = id; }
	    public void setCapMaxima(int capMaxima){ this.capMaxima = capMaxima; }
	    public void setEnCola(boolean enCola){ this.enCola = enCola; }
	    public void addAdyacente(Ciudad adyacente){ this.adyacentes.add(adyacente); }
	    public void addCapCiudad(Integer capCiudad){ this.capCiudades.add(capCiudad); }
	
	}
	
	public static int maxFlow(ArrayList<Ciudad> graph,int ini,int end){ 
	    LinkedList<Ciudad> q = new LinkedList<Ciudad>();
	    q.add(graph.get(ini));
	    graph.get(ini).setEnCola(true);
	    Ciudad w;
	    Ciudad v;
	    int i;
	    while(q.size()>0){
		v = q.pop();
		v.setEnCola(false);
		LinkedList<Ciudad> aux = v.getAdyacentes();
		i = 0;
		while(!aux.isEmpty()){
		   w = aux.pop(); 
		   w.setCapMaxima(Math.max(w.getCapMaxima(),Math.min(v.getCapMaxima(),v.getCapCiudad(i))));
		   if(!w.getEnCola()){
		       q.add(w);
		       w.setEnCola(true);
		   }
		   i++;
		}
	    }
	    return graph.get(end).getCapMaxima();
	}
	
	public static void main (String args[]) {
	    Scanner tc = new Scanner(System.in);
	    int N = tc.nextInt();
	    int R = tc.nextInt();
	    int C1,C2,P,ini,end,tourists;
	    int scenario = 1;
	    while(N>0 && R>0){
		ArrayList<Ciudad> graph = new ArrayList<Ciudad>();
		// Configurar ciudades //
		for(int i=0;i<N;i++) graph.add(new Ciudad(i,0,false));
		for(int i=0;i<R;i++){
		    C1 = tc.nextInt();
		    C2 = tc.nextInt();
		    P  = tc.nextInt();
		    graph.get(C1-1).addAdyacente(graph.get(C2-1));
		    graph.get(C1-1).addCapCiudad(P-1);
		    graph.get(C2-1).addAdyacente(graph.get(C1-1));
		    graph.get(C2-1).addCapCiudad(P-1);
		}
		ini = tc.nextInt()-1;
		graph.get(ini).setCapMaxima(Integer.MAX_VALUE); // Capacidad maxima del primero -> infinito, 0 viajes //
		end = tc.nextInt()-1;
		tourists = tc.nextInt();
		System.out.println("Scenario #"+scenario);
		System.out.println("Minimum Number of Trips = "+(int)Math.ceil(((float)tourists/(maxFlow(graph,ini,end)))));
		N = tc.nextInt();
		R = tc.nextInt();
		System.out.println();
		scenario++;
	    }
	}
}

