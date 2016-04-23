import java.util.Scanner;
import java.util.ArrayList;

class Main{	
	
    private static class Position implements Comparable{
        private int row;
        private int col;
        
        public Position(int row,int col){
            this.row = row;
            this.col = col;
        }
        
        public int getRow(){ return this.row; }
        public int getCol(){ return this.col; }
        public void setRow(int row){ this.row = row; }
        public void setCol(int col){ this.col = col; }
        public int compareTo(Object other){
            Position o = (Position) other;
            if(this.row>o.getRow()) return 1;
            else if(this.row<o.getRow()) return -1;
            else{
                if(this.col<o.getCol()) return 1;
                else if(this.col>o.getCol()) return -1;
                else return 0;
            }
        }
    }
   
	
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

	public static ArrayList<String> getColumns(ArrayList<String> field){
		ArrayList<String> res = new ArrayList<String>();
		for(int j=0;j<field.get(0).length();j++){
			String aux = "";
			for(int i=0;i<field.size();i++){
				aux += field.get(i).charAt(j);
			}
			res.add(""+aux.toUpperCase());
		}
		return res;
	}

    public static ArrayList<String> getLeftDiagonal(ArrayList<String> field){
        ArrayList<String> res = new ArrayList<String>();
        int k,p;
        String aux,last;
        for(int j=0;j<field.get(0).length();j++){
           k = 0;
           p = j;
           res.add(0,"");
           while(k<field.size() && p<field.get(0).length()){
               last = res.get(0);
               aux = last+""+field.get(k).charAt(p);
               res.set(0,aux.toUpperCase());
               k++;
               p++;
           }
        }
        for(int j=0;j<field.size();j++){
            k = j;
            p = 0;
            res.add("");
            while(k<field.size() && p<field.get(j).length()){
                last = res.get(res.size()-1);
                aux = last+""+field.get(k).charAt(p);
                res.set(res.size()-1,aux.toUpperCase());
                k++;
                p++;
            }
        }
        return res;
    }
	public static ArrayList<String> getRightDiagonal(ArrayList<String> field){
		ArrayList<String> res = new ArrayList<String>();
		int k,p;
		String aux,last;
		for(int j=0;j<field.get(0).length();j++){
			res.add("");
			k = 0;
			p = j;
			while(k<field.size() && p>=0){
				last = res.get(res.size()-1);
				aux  = last+""+field.get(k).charAt(p);
				res.set(res.size()-1,aux.toUpperCase());
				k++;
				p--;
			}
		}
		for(int i=1;i<field.size();i++){
			res.add("");
			p = i;
			k = field.get(0).length()-1;
			while(p<field.size() && k>=0){
				last = res.get(res.size()-1);
				aux  = last+""+field.get(p).charAt(k);
				res.set(res.size()-1,aux.toUpperCase());
				p += 1;
				k -= 1;
			}
		}	
		return res;
	}
	
	public static String reverseWord(String word){
		String res = "";
		for(int i=word.length()-1;i>=0;i--) res += word.charAt(i);
		return res;
	}
	
	public static int searchWords(ArrayList<String> rows, ArrayList<String> cols, ArrayList<String> rightDiags,ArrayList<String> leftDiags,String word){
		String reversed = reverseWord(word);
        ArrayList<Position> positions = new ArrayList<Position>();
		int oc = -1;
		// Buscar en filas //
        String aux;
        for(int i=0;i<rows.size();i++){
            aux = rows.get(i);
			if(aux.length()>=word.length()){
				oc = StringSearch.boyerMooreSearch(aux,word);
				if(oc!=-1){
                    positions.add(new Position(i,oc));
                    break;
                }
				oc = StringSearch.boyerMooreSearch(aux,reversed);
				if(oc!=-1){
                    positions.add(new Position(i,oc));
                    break;
                }
			}
		}
		// Buscar en columnas //
        for(int i=0;i<cols.size();i++){
            aux = cols.get(i);
			if(aux.length()>=word.length()){
				oc = StringSearch.boyerMooreSearch(aux,word);
				if(oc!=-1){
                    positions.add(new Position(oc,i));
                    break;
                }
				oc = StringSearch.boyerMooreSearch(aux,reversed);
				if(oc!=-1){
                    positions.add(new Position(oc,i));
                    break;
                }
			}
		}
		// Buscar en diagonales a derechas //
		for(String dia : rightDiags){
			if(dia.length()>=word.length()){
				oc = StringSearch.boyerMooreSearch(dia,word);
				if(oc!=-1) break;
				oc = StringSearch.boyerMooreSearch(dia,reversed);
				if(oc!=-1) break;
			}
		}
		if(oc!=-1) return oc;
		// Buscar en diagonales a izquierdas //
        for(String dia : leftDiags){
			if(dia.length()>=word.length()){
				oc = StringSearch.boyerMooreSearch(dia,word);
				if(oc!=-1) break;
				oc = StringSearch.boyerMooreSearch(dia,reversed);
				if(oc!=-1) break;
			}
		}
		return oc;	
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
			ArrayList<String> fieldRows = new ArrayList<String>();
			for(int j=0;j<m;j++){ fieldRows.add(tc.nextLine().substring(0,n).toUpperCase()); }
			int k = tc.nextInt();
			tc.nextLine(); // Limpiar buffer
			String[] palabras_a_buscar = new String[k];
			for(int i=0;i<k;i++) palabras_a_buscar[i] = tc.nextLine().toUpperCase();
			ArrayList<String> fieldColumns   = getColumns(fieldRows);
			ArrayList<String> fieldRightDiagonals = getRightDiagonal(fieldRows);
            ArrayList<String> fieldLeftDiagonals = getLeftDiagonal(fieldRows);
            System.out.println(fieldRows+"\n");
            System.out.println(fieldColumns+"\n");
            System.out.println(fieldRightDiagonals+"\n");
            System.out.println(fieldLeftDiagonals+"\n");
            
            
			/**for(String palabra_a_buscar : palabras_a_buscar){
				System.out.println("Palabra: "+palabra_a_buscar);
				System.out.println("Encontrada en: "+searchWords(fieldRows,fieldColumns,fieldRightDiagonals,fieldLeftDiagonals,palabra_a_buscar));
			}**/
		}	
	}
}

