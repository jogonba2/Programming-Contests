import java.util.Scanner;
class Main{
	
	public static void main (String args[]) {
	    Scanner tc = new Scanner(System.in);
	    int N = tc.nextInt();
	    while(N>0){
		int count1 = 0,count2 = 0;
		int res,resA = -1,resB = -1;
		boolean found = false;;
		int[] x = new int[2*N];
		int[] y = new int[2*N];
		for(int i=0;i<2*N;i++){
		    x[i] = tc.nextInt();
		    y[i] = tc.nextInt();
		}
		for(int A=-500;A<=500;A++){
		    for(int B=0;B<=500;B++){
			count1 = 0;
			count2 = 0;
			found  = true;
			for(int i=0;i<2*N;i++){
			    res = A*x[i]+B*y[i];
			    if(res>0) count1++;
			    if(res<0) count2++;
			    if(res==0){ found=false; break; }
			}
			if(found==true){
			    if(count1!=N && count2!=N) found=false;
			    else{
				resB = B;
				resA = A;
				break;
			    }
			}
		    }
		    if(found==true) break;
		    }
		System.out.println(resA+" "+resB);
		N = tc.nextInt();
	    }
	}
}

