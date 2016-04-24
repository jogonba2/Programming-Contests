import java.util.Scanner;

public class Main{
    
    
    public static boolean wrong_answer(String a,String b){
	String auxA = "";
	for(int i=0;i<a.length();i++){
	    if(a.charAt(i)!=' ') auxA += a.charAt(i);
	}
	if(auxA.equals(b)) return false;
	return true;
    }
    
    public static void main(String args[]){
	Scanner tc  = new Scanner(System.in);
	int nCases = tc.nextInt();
	String a,b;
	tc.nextLine(); // Clear buffer
	for(int i=0;i<nCases;i++){
	    a = tc.nextLine();
	    b = tc.nextLine();
	    if(a.equals(b)) System.out.printf("Case %d: Yes\n",i+1);
	    else{
		if(wrong_answer(a,b)) System.out.printf("Case %d: Wrong Answer\n",i+1); 
		else                  System.out.printf("Case %d: Output Format Error\n",i+1);
	    }
	}
	
	
	
	
    }
    
    
}
