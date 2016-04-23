import java.util.Scanner;
import java.lang.System;

public class Main{
    
    public static void printDishes(int[] dishes){
	for(int i=0;i<dishes.length;i++){
	    if(dishes[i]==0) System.out.print(" ");
	    else if(dishes[i]==1) System.out.print(".");
	    else if(dishes[i]==2) System.out.print("x");
	    else if(dishes[i]==3) System.out.print("W");
	}
	System.out.println();
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	tc.nextLine(); // Linea en blanco
	for(int i=0;i<nCases;i++){
	    int[] DNA = new int[10];
	    for(int j=0;j<10;j++) DNA[j] = tc.nextInt();
	    int[] dishes = new int[40];
	    dishes[19] = 1;
	    printDishes(dishes);
	    int[] newDishes = new int[40];
	    for(int j=0;j<49;j++){
		newDishes[0]  = DNA[dishes[0]+dishes[1]];
		newDishes[39] = DNA[dishes[39]+dishes[38]];
		for(int z=1;z<39;z++) newDishes[z] = DNA[dishes[z]+dishes[z-1]+dishes[z+1]];
		System.arraycopy(newDishes,0,dishes,0,40);
		printDishes(dishes);
	    }
	    if(i!=nCases-1) System.out.println();
	    tc.nextLine(); // Linea en blanco
	}
    }
}

