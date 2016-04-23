import java.util.Scanner;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	String n = tc.nextLine();
	while(true){
	    if(n.length()==1 && n.charAt(0)=='0') break;
	    int res = 0;
	    for(int i=n.length()-1;i>=0;i--){
		res += (Math.pow(2,n.length()-i)-1)*Character.getNumericValue(n.charAt(i));
	    }
	    System.out.println(res);
	    if(tc.hasNextLine()) n = tc.nextLine();
	}
		
    }
}

