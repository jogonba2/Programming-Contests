import java.util.Scanner;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	String text = "";
	while(tc.hasNextLine()){
	    text += tc.nextLine();
	    if(tc.hasNextLine()) text += "\n";
	}
	String res = "";
	int c = 0;
	for(int i=0;i<text.length();i++){
	    if(text.charAt(i)!='"') res += text.charAt(i);
	    else{
		if(c%2==0) res += "``";
		else res += "''";
		c = (c+1)%2;
	    }
	}
	System.out.println(res);
    }
}

