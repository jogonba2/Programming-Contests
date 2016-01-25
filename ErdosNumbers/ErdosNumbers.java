/* erdos_numbers.java */
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ErdosNumbers{
	
	public static HashMap<String,Integer> dijkstra(HashMap<String,ArrayList<String>> graph, String source){
		HashMap<String,Integer> distanciaMin = new HashMap();
		HashMap<String,Boolean> visitado     = new HashMap();
		for(String author : graph.keySet()){
			distanciaMin.put(author,Integer.MAX_VALUE);
			visitado.put(author,false);
		}
		distanciaMin.put(source,0);
		Tuple<String,Integer> tuple = new Tuple(source,0);
		PriorityQueue qPrior = new PriorityQueue();
		qPrior.add(tuple);
		while(qPrior.size()>0){
			Tuple<String,Integer> t = (Tuple<String,Integer>) qPrior.poll();
			String v   = t.getLeft();
			if(visitado.get(v)==false){
				visitado.put(v,true);
				for(String ady : graph.get(v)){
					int pesoW = 1;
					if(distanciaMin.get(ady)>distanciaMin.get(v)+pesoW){
						distanciaMin.put(ady,distanciaMin.get(v)+pesoW);
						Tuple<String,Integer> tuple2 = new Tuple(ady,distanciaMin.get(ady));
						qPrior.add(tuple2);
					}
				}
			}
		}
		return distanciaMin;
	}	
		
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int scenarios = tc.nextInt();
		HashMap<String,ArrayList<String>> authorsHash = new HashMap();
		for(int i=0;i<scenarios;i++){
			int narticles = tc.nextInt();
			int nauthors  = tc.nextInt();
			tc.nextLine(); // Limpiar buffer //
			for(int j=0;j<narticles;j++){
				String article   = tc.nextLine();
				String auxAuthors = article.split("\\.:")[0];
				String[] authors  = auxAuthors.split("\\.,");
				// Poner . a final de autores que no sean el ultimo //
				for(int z=0;z<authors.length;z++){
					authors[z] = authors[z].trim();
					authors[z] = authors[z]+".";
				}				
				for(int z=0;z<authors.length;z++){
					if(authorsHash.get(authors[z])==null) authorsHash.put(authors[z],new ArrayList<String>());
					for(int y=0;y<authors.length;y++){
						if(y!=z) authorsHash.get(authors[z]).add(authors[y]);
					}
				}	
			}
			// Antes de leer sobre que autores se consulta, calcular los numeros de Erdos //
			HashMap<String,Integer> distances = dijkstra(authorsHash,"Erdos, P.");
			System.out.println("Scenario "+i);
			for(int j=0;j<nauthors;j++){
				String author = tc.nextLine();
				Integer res = distances.get(author);
				if(res==Integer.MAX_VALUE) System.out.println(author + " infinity");
				else 					   System.out.println(author + " " + res);
			}
		}
	}
}
