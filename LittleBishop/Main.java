import java.util.Scanner;

public class Main{
	
	// Hecho siguiendo el esquema de las n reinas de jon //
	// http://users.dsic.upv.es/~jon/docencia/CPR/Codigo-de-Apoyo/backtraking/n_reinas.java //
	private int num_soluciones;
	
	public Main(){
	    num_soluciones = 0;
	} 
	
	private boolean is_complete(int k,int n){ return k==n; }
	
	private void branch(int[][] a,int k,int n){
	    // ... //
	    // newBoard[loquesea] = loquesea; //
	}
	
	private void backtracking(int[][] board,int k,int n){
	    if (is_complete(k,n)) num_soluciones++;
	    else{
		int[][] newBoard = new int[n][n];
		branch(board,k,n);
		
		
	    }
	    
	    
	}
	
	// Te lo dejo así por si quieres seguirlo, lo haré en python a ver si sale mejor alli :) //
	public static void main(String args[]) {
	    Scanner tc = new Scanner(System.in);
	    int n,k;
	    n = tc.nextInt();
	    k = tc.nextInt();
	    while(n>0 && k>0){
		int[][] board = new int[n][n];
		// Aparcao xD //
		n = tc.nextInt();
		k = tc.nextInt();
	    }
	}
}

