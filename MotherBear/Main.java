import java.util.Scanner;

public class Main{
    
    public static boolean isPalindrome(String s){
	int i=0,j=s.length()-1;
	while(i<j){
	    if(s.charAt(i)!=s.charAt(j)) return false;
	    i++;
	    j--;
	}
	return true;
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	String line = tc.nextLine();
	while(!line.equals("DONE")){
	    String aux = "";
	    for(int i=0;i<line.length();i++){
		if(line.charAt(i)!=' ' && line.charAt(i)!='!' && line.charAt(i)!='.' && line.charAt(i)!=',' && line.charAt(i)!='?'){
		    aux += Character.toLowerCase(line.charAt(i));
		}
	    }
	    if(isPalindrome(aux)) System.out.println("You won't be eaten!");
	    else 		  System.out.println("Uh oh..");
	    line =  tc.nextLine();
	}	
    }
}

