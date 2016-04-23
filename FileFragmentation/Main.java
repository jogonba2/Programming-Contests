import java.util.*;
import java.util.Arrays;

class Main {
	
	private static class StringL implements Comparable{
		
		public String palabra;
		
		public StringL(String palabra){
			this.palabra = palabra;
		}
		
		public int compareTo(Object other){
			StringL o = (StringL) other;
			if(this.palabra.length()>o.palabra.length()) return 1;
			else if(this.palabra.length()<o.palabra.length()) return -1;
			return 0;
		}
		
	}
	
	public static String pattern(String[] fragment)
	{
		String minFragment = "";
		int minLength = 999;
		String maxFragment = "";
		int maxLength = 0;
		int mid = fragments/2;
		for(int z = 0; z < fragments; z++)
		{
				if(fragment[z].length() < minLength) {
					minFragment = fragment[z];
					minLength = minFragment.length();
				}
				if(fragment[z].length() > maxLength) {
					maxFragment = fragment[z];
					maxLength = maxFragment.length();
				}
		}
		System.out.println("Min : " + minFragment);
		System.out.println("Max : " + maxFragment);
		return minFragment + maxFragment;
	}
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCases = tc.nextInt();
		int j;
		String result;
		String line;
		tc.nextLine();
		do{line = tc.nextLine().trim();}
		while(!line.isEmpty());
		for(int i = 0; i< nCases; i++)
		{
			StringL [] fragment = new StringL [144];
			
			j = 0;
			while(tc.hasNext()){
				line = tc.nextLine().trim();
				if(line.isEmpty()) break;
				fragment[j] = new StringL(line); 
				fragments++;
				j++;
			}
			
			Arrays.sort(fragment,0,fragments);
			for(int z=0;z<fragments;z++) System.out.print(fragment[z].palabra+",");
			System.out.println();
			if(i!=nCases-1) System.out.println();
		}
		
	}
}
