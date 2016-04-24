import java.util.Scanner;
import java.util.HashMap;

public class Main{
    
    public static boolean isConsonant(char a){
	if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u') return false;
	return true;
    }
    
    public static boolean ruleTwo(String x){
	if(x.charAt(x.length()-1)=='o' || x.charAt(x.length()-1)=='s' || x.charAt(x.length()-1)=='x' ||
	   (x.charAt(x.length()-2)=='c' && x.charAt(x.length()-1)=='h') || (x.charAt(x.length()-2)=='s' && x.charAt(x.length()-1)=='h')){
	       return true;
	}
	return false;
    }
    
    public static String preprocess(String x){
	String res = null;
	if(isConsonant(x.charAt(x.length()-2)) && x.charAt(x.length()-1)=='y'){
	    res = x.substring(0,x.length()-1)+"ies";
	}
	else if(ruleTwo(x)) res = x+"es";
	else res = x+"s";
	return res;
    }
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int L = tc.nextInt();
	int N = tc.nextInt();
	String[] irregular;
	String word;
	HashMap<String,String> irregulars = new HashMap<String,String>();
	tc.nextLine(); // Clear buffer 
	for(int i=0;i<L;i++){
	    irregular = tc.nextLine().trim().split(" ");
	    irregulars.put(irregular[0],irregular[1]);
	}
	for(int i=0;i<N;i++){
	    word = tc.nextLine().trim();
	    if(irregulars.get(word)!=null) System.out.println(irregulars.get(word));
	    else                           System.out.println(preprocess(word));
	}
    }
    
}
