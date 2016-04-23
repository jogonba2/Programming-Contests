import java.util.Scanner;

public class Main{
    
    public static int max(int a,int b,int c){
	int max = Integer.MIN_VALUE;
	if(a>=max) max = a;
	if(b>=max) max = b;
	if(c>=max) max = c;
	return max;
    }
    
    public static int lcs(String u,String v){
	int[][] trellis = new int[u.length()+1][v.length()+1];
	for(int i=0;i<=v.length();i++) trellis[0][i] = 0;
	for(int i=0;i<=u.length();i++) trellis[i][0] = 0;
	for(int i=1;i<=u.length();i++){
	    for(int j=1;j<=v.length();j++){
		if(u.charAt(i-1)==v.charAt(j-1)) trellis[i][j] = trellis[i-1][j-1]+1;
		else trellis[i][j] = Math.max(trellis[i-1][j],trellis[i][j-1]);
	    }
	}
	return trellis[u.length()][v.length()];
	
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	String word1,word2;
	while(tc.hasNextLine()){
	    word1 = tc.nextLine().trim();
	    word2 = tc.nextLine().trim();
	    if(word1.isEmpty() || word2.isEmpty()) System.out.println("0");
	    else 				   System.out.println(lcs(word1,word2));
	}	
    }
}

