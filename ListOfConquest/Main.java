import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	HashMap<String,Integer> res = new HashMap<String,Integer>();
	int nCases = tc.nextInt();
	tc.nextLine(); // Clear buffer
	for(int i=0;i<nCases;i++){
	    String line = tc.nextLine().trim();
	    String country = line.split(" ")[0]; 
	    if(res.get(country)==null){ res.put(country,1); }
	    else{ res.put(country,res.get(country)+1); }
	}	
	ArrayList<String> countries = new ArrayList<String>(res.keySet());
	Collections.sort(countries);
	for(String c : countries){
	    System.out.println(c+" "+res.get(c));
	}
    }
}

