import java.util.Scanner;

public class Main{
    /**  	Padovan sequence: a(n) = a(n-2) + a(n-3) with a(0)=1, a(1)=a(2)=0.  **/
    public static void padovan(int[] l){
	l[0] = 1; l[1] = l[2] = 0;
	for(int i=3;i<150;i++){
	    l[i] = l[i-2]+l[i-3];
	}
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int[] l = new int[150];
	padovan(l);
	while(tc.hasNextInt()){
	    System.out.println(l[tc.nextInt()+6]);
	}
    }
}

