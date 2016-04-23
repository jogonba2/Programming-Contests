import java.util.Scanner;
import java.util.HashMap;

class Arco
{
		private Nodo	nodo;
		private char	simbolo;

		public Arco( Nodo nodo, char simbolo )
		{
			this.nodo = nodo;
			this.simbolo = simbolo;
		}

		public Nodo getNodo()
		{
			return nodo;
		}
		public char getSimbolo()
		{
			return simbolo;
		}
}

class Nodo
	{
		private Arco	siguientes[];
		private String	palabra;
		private final int	numSimbolos=96;
		private final char	simboloBase=' ';
		
		public Nodo()
		{
			siguientes = new Arco [ numSimbolos ];
			this.palabra = null;	
		}
		public Nodo( String palabra )
		{
			this();
			this.palabra = palabra;
		}

		public String getPalabra()
		{
			return palabra;
		}
		public void setPalabra( String palabra )
		{
			this.palabra = palabra;
		}

		public Nodo getSiguiente( char simbolo )
		{
			try {
				int indice = simbolo - simboloBase;	

				if ( indice < 0 || indice > siguientes.length ) {
					throw new Exception( "Imposible alcanzar siguiente nodo con |" + simbolo + "|" );
				}

				Arco arco = siguientes[indice];

				if ( arco == null ) return null;

				if ( arco.getSimbolo() != simbolo ) {
					throw new Exception( "Imposible alcanzar siguiente nodo con |" + simbolo + "|" );
				}

				return siguientes[indice].getNodo();
			}
			catch( Exception e )
			{
				e.printStackTrace( System.err );
				System.exit(-1);
			}
			return null;
		}

		public void anyadeSiguiente( Nodo nodo, char simbolo )
		{
			try {
				int indice = simbolo - simboloBase;	

				if ( indice < 0 || indice > siguientes.length ) {

					throw new Exception( "Imposible preparar nuevo nodo con |" + simbolo + "|" );
				}

				siguientes[indice] = new Arco( nodo, simbolo );
			}
			catch( Exception e )
			{
				e.printStackTrace( System.err );
				System.exit(-1);
			}
		}

		public void recorre( String str )
		{
			if ( palabra != null ) System.out.printf( "[%s] %s\n", str, palabra.toString() );

			for( int i=0; i < siguientes.length; i++ ) {
				Arco arco = siguientes[i];
				if ( arco != null ) arco.getNodo().recorre( str + arco.getSimbolo() );
			}
		}
}	
class Diccionario
{
	
	private Nodo	raiz;

	public Diccionario()
	{
		raiz = new Nodo();
	}
	
	public Nodo getRaiz(){ return raiz; }
	
	public String get( String cadena )
	{
		char clave[] = cadena.toCharArray();

		Nodo actual = raiz;
		int	 i = 0;

		while( actual != null && i < clave.length ) {
			
			char simbolo = clave[i];
			Nodo siguiente = actual.getSiguiente( simbolo );

			if ( siguiente == null ) return null;

			actual = siguiente;
			i++;
		}

		if ( actual != null ) return actual.getPalabra();

		return null;
	}
	
	public void add( String cadena, String palabra )
	{
		char clave[] = cadena.toCharArray();

		Nodo actual = raiz;
		int	 i = 0;

		while( actual != null && i < clave.length ) {
			
			char simbolo = clave[i];
			Nodo siguiente = actual.getSiguiente( simbolo );

			if ( siguiente == null ) {
				siguiente = new Nodo();
				actual.anyadeSiguiente( siguiente, simbolo );
			}

			actual = siguiente;
			i++;
		}
		if ( actual != null ) actual.setPalabra( palabra );
	}
	
}
class WheresWaldorf{	
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCasos = tc.nextInt();
		tc.nextLine(); // Limpiar buffer;
		for(int caso=0;caso<nCasos;caso++){
			Diccionario diccionario_palabras_a_buscar = new Diccionario();
			HashMap<String,Boolean> diccionario_palabras_encontradas = new HashMap<String,Boolean>();
			String linea;
			do { linea = tc.nextLine().trim(); // Hasta encontrar la linea blanca //
			}while(tc.hasNext() && linea.length()!=0);
			int m = tc.nextInt();
			int n = tc.nextInt();
			tc.nextLine(); // Clear buffer
			String field[] = new String[m];
			for(int j=0;j<m;j++){
				field[j] = tc.nextLine().substring(0,n);
			}
			int k = tc.nextInt();
			tc.nextLine(); // Limpiar buffer
			String palabra_a_buscar;
			// Meter las palabras en un trie para buscarlas recorriendo la matriz en todas las direcciones posibles //
			for(int j=0;j<k;j++){
				palabra_a_buscar = tc.nextLine();
				diccionario_palabras_a_buscar.add(palabra_a_buscar,palabra_a_buscar);
				diccionario_palabras_encontradas.put(palabra_a_buscar,false);
			}
			Nodo aux;
			// Recorrer matriz por filas de izq a derecha //
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
						// Algo parecido al get del trie //
					}	
			}
		}	
	}
}

