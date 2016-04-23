import java.util.Scanner;


public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	String name;
	while(tc.hasNextLine()){
	    int i=1;
	    name = tc.nextLine();
	    boolean found = false;
	    while(i<=10000 && !found){
		if(yuanfen(getIntegerName(name,i))==100) found = true;
		i++;
	    }
	    if(!found) System.out.println(":(");
	    else System.out.println(i-1);
	}	
    }
    
    public static int yuanfen(int v[]){
	int len = v.length;
	while(len>2){
	    for(int i=0;i<len-1;i++) v[i] = (v[i]+v[i+1])%10;
	    len -= 1;
	    if(len==3 && v[0]==1 && v[1]==0 && v[2]==0) return 100;
	}
	return 0;
    }
    
    public static int[] getIntegerName(String name, int st){
	String aux = "";
	for(int i=0;i<name.length();i++) aux += name.charAt(i)-'A'+st;
	int v[] = new int[aux.length()];
	for(int i=0;i<aux.length();i++) v[i] = Character.getNumericValue(aux.charAt(i));
	return v;
    }
}

