import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

class AustralianVoting{
	
	public static ArrayList<Integer> get_max(ArrayList<Integer> l){
		ArrayList<Integer> res = new ArrayList<Integer>();
		Integer max_val = -1,max_ind = -1;
		for(int i=0;i<l.size();i++){
			if(l.get(i).compareTo(max_val)>0){
				max_val = l.get(i);
				max_ind = i;
			}
		}
		res.add(max_ind); res.add(max_val);
		return res;
	}
	
	public static ArrayList<Integer> get_min(ArrayList<Integer> l){
		ArrayList<Integer> res = new ArrayList<Integer>();
		Integer min_val = Integer.MAX_VALUE,min_ind = -1;
		for(int i=0;i<l.size();i++){
			if(l.get(i).compareTo(min_val)<0){
				min_val = l.get(i);
				min_ind = i;
			}
		}
		res.add(min_ind); res.add(min_val);
		return res;
	}
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCases = tc.nextInt();
		tc.nextLine(); // Limpiar buffer
		for(int i=0;i<nCases;i++){
			tc.nextLine(); // Linea en blanco
			int nCandidates = tc.nextInt();
			HashMap<Integer,String> posCandidates = new HashMap<Integer,String>();
			ArrayList<Integer> votesCandidates     = new ArrayList<Integer>();
			ArrayList<Boolean> candActives        = new ArrayList<Boolean>();
			ArrayList<ArrayList<Integer>> votes   = new ArrayList<ArrayList<Integer>>();
			String candName;
			tc.nextLine(); // Limpiar buffer
			// Entrada nombres //
			for(int j=0;j<nCandidates;j++){
				candName = tc.nextLine();
				posCandidates.put(j,candName);
				candActives.add(true);
			}
			// Entrada votos //
			while(tc.hasNext()){
				ArrayList<Integer> vote = new ArrayList<Integer>();
				for(int j=0;j<nCandidates;j++) vote.add(tc.nextInt()-1);
				votes.add(vote);
			}
			while(true){
				// Poner a 0 el contador //
				for(int j=0;j<nCandidates;j++) votesCandidates.add(0);
			
				// Contar votos //
				for(int j=0;j<votes.size();j++){
					Integer auxCandidate;
					for(int z=0;z<votes.get(0).size();z++){
						auxCandidate = votes.get(j).get(z);
						if(candActives.get(auxCandidate)){ 
							votesCandidates.set(auxCandidate,votesCandidates.get(auxCandidate)+1); 
							break;
						}
					}
				}		
			
				ArrayList<Integer> max_votes = get_max(votesCandidates);
				ArrayList<Integer> min_votes = get_min(votesCandidates);
	
				// Comprobar si el numero de votos para él es > que el numero de votantes/2, si lo es, mostrar el nombre y finalizar. 
				if(max_votes.get(1).doubleValue()>(votes.size()/2.0)){
					System.out.println(posCandidates.get(max_votes.get(0)));
					break;
				}
				// SI el maximo, coincide con el minimo, mostrar todos los activos porque todos tienen el mismo numero de votos y finalizar **/
				if(max_votes.get(1).compareTo(min_votes.get(1))==0){
					for(int j=0;j<candActives.size();i++){
						if(candActives.get(j)) System.out.println(posCandidates.get(j));
					}
					break;
				}
			
				/** Desactivar los candidatos cuyo numero de votos coincide con el minimo **/
				for(int j=0;j<votesCandidates.size();j++){
					if(votesCandidates.get(j).compareTo(min_votes.get(1))==0) candActives.set(j,false);
				}
			}
		}
	}
}

