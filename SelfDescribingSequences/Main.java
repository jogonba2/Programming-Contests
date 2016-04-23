import java.util.Scanner;

public class Main{
	
	
	public static int[] f(){
	    int[] a = new int[680000];
	    a[1] = 1;
	    int m=0;
	    for(int i=2;i<680000;i++){
		if(a[m+1]<=i-1) m = m+1;
		a[i] = a[i-1]+m;
	    }
	    return a;
	}
	
	public static int binarySearch(int a[],int n){
	    int centro=-1,inf=0,sup=a.length-1;
	    while(inf<=sup){
		centro = (sup+inf)/2;
		if(a[centro]==n) return centro;
		else if(n<a[centro]) sup = centro-1;
		else{ inf = centro+1; }
	    }
	    return centro+1;
	}
	
	public static int linearSearch(int a[],int n){
	    for(int i=0;i<a.length-1;i++){
		if(n==a[i]) return i;
		else{
		    if(n>a[i] && n<a[i+1]) return i;
		}
	    }
	    return -1;
	}
	
	public static void main (String args[]) {
	    Scanner tc = new Scanner(System.in);
	    int[] a = f();
	    int n = tc.nextInt();
	    while(n!=0){
		System.out.println(linearSearch(a,n));
		n = tc.nextInt();
	    }
	}
}

