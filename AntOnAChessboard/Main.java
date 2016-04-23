import java.util.Scanner;

class Main{
	
	public static void main (String args[]) {
	    Scanner tc = new Scanner(System.in);
	    int n = tc.nextInt();
	    int row,col,t;
	    while(n>0){
		t = (int)Math.sqrt(n-1)+1;
		row = (t%2)*Math.min(t,n-((t-1)*(t-1)))+((t+1)%2)*Math.min(t,(t*t)-n+1);
		col = (t%2)*Math.min(t,(t*t)-n+1) + ((t+1)%2)*Math.min(t,(n-((t-1)*(t-1))));
		System.out.println(col+" "+row);
		n = tc.nextInt();
	    }

	    
	}
}

