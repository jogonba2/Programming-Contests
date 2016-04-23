import java.util.*;

class Main {
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCases = tc.nextInt();
		int[] res = new int[nCases];
		for(int i=0;i<nCases;i++){
			int nDays  = tc.nextInt();
			int nParties = tc.nextInt();
			int hAux;
			boolean[] days = new boolean[nDays];
			for(int j=0;j<nParties;j++){
				hAux = tc.nextInt();
				int aux = hAux-1;
				while(aux<nDays){
					days[aux] = true;
					aux += hAux;
				}
			}
			int countHartals = 0;
			for(int j=0;j<nDays;j++){
				if(j%7!=5 && j%7!=6){
					if(days[j]) countHartals += 1;
				}
			}
			res[i] = countHartals;		
		}
		for(int i=0;i<nCases;i++) System.out.println(res[i]);
	}
}
