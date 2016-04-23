import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main{
	
	public static boolean checkOrder(ArrayList<Integer> l){
		for(int i=0;i<l.size()-1;i++){
			if(l.get(i).compareTo(l.get(i+1))<0) return false;
		}
		return true;
	}
	
	public static int posMax(ArrayList<Integer> l){
		int pos = -1, max = Integer.MIN_VALUE;
		int aux;
		for(int i=0;i<l.size();i++){
			aux = l.get(i).intValue();
			if(aux>max){
				max = aux;
				pos = i;
			}
		}
		return pos;
	}
	
	public static void reverse(ArrayList<Integer> l,int ini){
		Integer aux;
		int i = ini-1,j = l.size()-1;
		while(i<=j){
			aux = l.get(i);
			l.set(i,l.get(j));
			l.set(j,aux);
			i++;
			j--;
		}
	}
	
	public static ArrayList<Integer> flaps(ArrayList<Integer> l){
		ArrayList<Integer> res = new ArrayList<Integer>();
		int count = 0;
		while(!checkOrder(l)){
			int posM = posMax(l);
			if(posM==0){
				l.remove(0);
				count++;
			}
			else{
				if(posM==l.size()-1){
					reverse(l,1);
					res.add(count+1);
				}
				else{
					reverse(l,posM+1);
					res.add(posM+1+count);
				}
			}
		}
		return res;
	}
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		while(tc.hasNextLine()){
			ArrayList<Integer> stack = new ArrayList<Integer>();
			String[] stackI = tc.nextLine().split(" ");
			for(int i=stackI.length-1;i>=0;i--) stack.add(Integer.valueOf(stackI[i]));
			ArrayList<Integer> auxStack = new ArrayList<Integer>(stack);
			Collections.reverse(auxStack);
			for(int i=0;i<auxStack.size();i++){
				System.out.print(auxStack.get(i));
				if(i<auxStack.size()-1) System.out.print(" ");
			}
			System.out.println();
			ArrayList<Integer> res = flaps(stack);
			for(int i=0;i<res.size();i++) System.out.print(res.get(i)+" ");
			System.out.print("0\n");
			
		}
	}
}

