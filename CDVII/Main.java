import java.util.Scanner;

class Main {
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int[] tarifas = new int[24];
		int nCases = tc.nextInt();
		for(int i=0;i<nCases;i++){
			String line;
			do{ line = tc.nextLine().trim();
			}while(tc.hasNextLine() && !line.isEmpty());
			for(int j=0;j<24;j++) tarifas[j] = tc.nextInt();
			String splitted[];
			while(tc.hasNextLine()){
				line = tc.nextLine();
				splitted = line.split(" ");
			}
		}
	}
}

