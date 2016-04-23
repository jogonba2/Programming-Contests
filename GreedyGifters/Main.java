import java.util.Scanner;
import java.util.HashMap;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	while(tc.hasNextInt()){
	    int n = tc.nextInt();
	    int[] diff = new int[n];
	    HashMap<String,Integer> r = new HashMap<String,Integer>();
	    tc.nextLine();
	    String[] names = tc.nextLine().split(" ");
	    for(int i=0;i<names.length;i++) r.put(names[i],i);
	    int index;
	    for(int i=0;i<n;i++){
		String[] line = tc.nextLine().split(" ");
		if(Integer.parseInt(line[2])!=0){
		    index = r.get(line[0]);
		    diff[index] -= Integer.parseInt(line[1]);
		    diff[index] += (Integer.parseInt(line[1])%Integer.parseInt(line[2])); // Sumarle el resto si no es divisible!! //
		    for(int j=3;j<line.length;j++){
			index = r.get(line[j]);
			diff[index] += (Integer.parseInt(line[1])/Integer.parseInt(line[2]));
		    }
		}
	    }
	    for(int i=0;i<names.length;i++){
		index = r.get(names[i]);
		System.out.println(names[i]+" "+diff[index]);
	    }
	    if(tc.hasNextInt()) System.out.println();
	}
	    
    }
}

