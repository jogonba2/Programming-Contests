import java.util.Scanner;
import java.util.HashMap;


class Main{
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int N;
	String text;
	tc.useDelimiter(" ");
	String all = "";
	while(tc.hasNext()) all += tc.nextLine() + " ";
	//System.out.println(all);
	String lines[] = all.split(" ");
	for(int i=0;i<lines.length-1;i+=2){
	    N = Integer.parseInt(lines[i]);
	    text = lines[i+1];
	    HashMap<String,Integer> hash = new HashMap<String,Integer>();
	    String subs = null;
	    String pass = null;
	    int ocu  = Integer.MIN_VALUE;
	    int L = text.length()-N+1;
	    for(int j=0;j<L;j++){
		subs = text.substring(j,j+N);
		if(hash.get(subs)==null) hash.put(subs,1);
		else                     hash.put(subs,hash.get(subs)+1);
		if(hash.get(subs)>ocu){
		    ocu = hash.get(subs);
		    pass = subs;
		}
	    }
	    System.out.println(pass);
	}
    }
    
}
