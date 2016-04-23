import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;

public class Main{
	
    public static void main (String args[]) {
	BufferedReader di     = new BufferedReader(new InputStreamReader(System.in));
	DataOutputStream dout = new DataOutputStream(System.out);
	String line;
	String newLine;
	try{
	    line = di.readLine();
	    while(!line.isEmpty()){
		newLine = "";
		for(int i=0;i<line.length();i++){
		    if(line.charAt(i)!=' '){
			newLine += (char)((int)line.charAt(i)-7);
		    }
		    else line += " ";
		}
		System.out.println(newLine);
		//dout.writeUTF(newLine+"\n");
		line = di.readLine();
	    }
	}catch(Exception e){}
    }
}

