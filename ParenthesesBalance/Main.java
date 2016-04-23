import java.util.Scanner;
import java.util.Stack;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int nCases  = tc.nextInt();
	tc.nextLine();
	String line;
	for(int i=0;i<nCases;i++){
	    line = tc.nextLine();
	    Stack<Character> stack = new Stack<Character>();
	    boolean possible = true;
	    for(int j=0;j<line.length();j++){
		if(j==0){
		    if(line.charAt(j)==']' || line.charAt(j)==')'){
			possible = false;
			break;
		    }
		    else stack.push(line.charAt(j));
		}
		else{
		    if(line.charAt(j)==')'){
			if(stack.size()==0){ possible = false; break; }
			else{
			    if(stack.peek()=='(') stack.pop();
			    else stack.push(line.charAt(j));
			}
		    }
		    else if(line.charAt(j)==']'){
			if(stack.size()==0){ possible = false; break; }
			else{
			    if(stack.peek()=='[') stack.pop();
			    else stack.push(line.charAt(j));
			}
		    }
		    else stack.push(line.charAt(j));
		}
	    }
	    if(stack.size()>0) possible = false;
	    if(possible) System.out.println("Yes");
	    else         System.out.println("No");
	    
	}	
    }
}

