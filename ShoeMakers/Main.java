import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class Main{
	
	private static class Trabajo implements Comparable{
		private int dias;
		private int multa;
		private int indice;
		
		public Trabajo(int dias,int multa,int indice){
			this.dias = dias;
			this.multa = multa;
			this.indice = indice;
		}
		
		public int getDias(){ return this.dias; }
		public int getMulta(){ return this.multa; }
		public int getIndice(){ return this.indice; }
		
		public int compareTo(Object other){
			Trabajo o = (Trabajo) other;
			float multaPorDia1 = (float)this.multa/this.dias;
			float multaPorDia2 = (float)o.multa/o.dias;
			if(multaPorDia1>multaPorDia2) return 1;
			else if(multaPorDia1<multaPorDia2) return -1;
			return 0;
		}
	}
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCases = tc.nextInt();
		for(int i=0;i<nCases;i++){
			String line;
			int nTrabajos;
			ArrayList<Trabajo> trabajos = new ArrayList<Trabajo>();
			do{ line = tc.nextLine().trim();
			}while(!line.isEmpty());
			nTrabajos = tc.nextInt();
			for(int j=0;j<nTrabajos;j++){
				trabajos.add(new Trabajo(tc.nextInt(),tc.nextInt(),j+1));
			}
			Collections.sort(trabajos,Collections.reverseOrder());
			for(int j=0;j<nTrabajos;j++){
				System.out.print(trabajos.get(j).getIndice());
				if(j<nTrabajos-1) System.out.print(" ");
			}
			if(i<nCases-1) System.out.println("\n");
			else           System.out.println();
		}
	}
}

