import java.util.Scanner;

class WheresWaldorf{	
	
	private static class StringSearch
	{
		private final static int ALPHABET_SIZE=128;
		private final static int ALPHABET_MASK=255;

		private static int charToInt( char c )
		{
			return (int)c & ALPHABET_MASK;
		}
 
		public static int boyerMooreSearch( String s, String p )
		{
			int d[] = new int [ ALPHABET_SIZE ];
			int ls = s.length(),
				lp = p.length();

			for( int i=0; i < d.length; i++ ) d[i] = lp;

			for( int i=0; i < lp-1; i++ ) d[ charToInt( p.charAt(i) ) ] = lp-i-1;

			int i = lp-1;
			do {
				int j=lp-1, k=i;
				while( j >= 0 && s.charAt(k) == p.charAt(j) ) { --k; --j; }
				if ( j < 0 ) return k+1;
				i = i + d[ charToInt( s.charAt(i) ) ];
			} while( i < ls );

			return -1;
		}

	}

	public static String[] getColumns(String[] field){
		String res[] = new String[field[0].length()];
		for(int j=0;j<field[0].length();j++){
			String aux = "";
			for(int i=0;i<field.length;i++){
				aux += field[i].charAt(j);
			}
			res[j] = ""+aux;
		}
		return res;
	}
	
	public static ArrayList<String> getDiagonal(String[] field){
		ArrayList<String> res = new ArrayList<String>();
		return res;
	}
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCasos = tc.nextInt();
		tc.nextLine(); // Limpiar buffer;
		for(int caso=0;caso<nCasos;caso++){
			String linea;
			do { linea = tc.nextLine().trim(); // Hasta encontrar la linea blanca //
			}while(tc.hasNext() && linea.length()!=0);
			int m = tc.nextInt();
			int n = tc.nextInt();
			tc.nextLine(); // Clear buffer
			String fieldRows[] = new String[m];
			for(int j=0;j<m;j++){
				fieldRows[j] = tc.nextLine().substring(0,n);
			}
			int k = tc.nextInt();
			tc.nextLine(); // Limpiar buffer
			String[] palabras_a_buscar = new String[k];
			for(int i=0;i<k;i++) palabras_a_buscar[i] = tc.nextLine();
			String fieldColumns[] = getColumns(fieldRows);
			for(int i=0;i<n;i++) System.out.println(fieldColumns[i]);
		}	
	}
}

