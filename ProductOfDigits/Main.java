import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    
    public static void factorization(int x){
	ArrayList<Integer> res = new ArrayList<Integer>();
	int i;
	int c;
	c = x;
	i = (int)(9);
	while(i>=2){
	    if((c%i)==0){
		res.add(i);
		c = c / i;
	    }
	    else i--;
	}
	Collections.sort(res);
	if(c==1){
	    for(int j=0;j<res.size();j++) System.out.print(res.get(j));
	}
	else System.out.print(-1);
	System.out.println();
    }
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int nCases = tc.nextInt();
	for(int i=0;i<nCases;i++){
	    int x = tc.nextInt();
	    if(x>=10){
		factorization(x);
	    }
	    else System.out.println(x);
	}
    }
}
