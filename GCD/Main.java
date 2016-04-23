import java.util.Scanner;


public class Main{
    
    public static int mcd(int a,int b){
	if(b==0) return a;
	else return mcd(b,a%b);
    }
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int N = tc.nextInt();
	while(N!=0){
	    int G = 0;
	    for(int i=1;i<N;i++){
		for(int j=i+1;j<=N;j++){
		    G += mcd(i,j);
		}
	    }
	    System.out.println(G);
	    N = tc.nextInt(); 
	}
    }
    
}
