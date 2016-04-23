import java.util.Scanner;


public class Main{
    
    private static class MFSet{
	private int talla;
	private int elArray[];
	
	public MFSet(int talla){
	    this.talla = talla;
	    this.elArray = new int[talla];
	    for(int i=0;i<talla;i++) this.elArray[i] = -1;
	}
	
	public int find(int x){
	    if(this.elArray[x]<0) return x;
	    else return elArray[x] = find(elArray[x]);
	}
	
	public void merge(int x,int y){
	    int raizX = find(x);
	    int raizY = find(y);
	    if(raizX!=raizY){
		if(elArray[raizX]==elArray[raizY]){
		    elArray[raizX] = raizY;
		    elArray[raizY]--;
		}
		else if(elArray[raizX] < elArray[raizY]){
		    elArray[raizY] = raizX;
		}
		else{
		    elArray[raizX] = raizY;
		}
	    }
	}	
	
	public void append(int x,int y){
	    int raizY = find(y);
	    elArray[x] = raizY;
	}
	
	public void printSum(int x){
	    int raizX = find(x);
	    int raizI;
	    int sum   = x;
	    int n     = 1;
	    for(int i=0;i<this.talla;i++){
		if(i!=x){
		    raizI = find(i);
		    if(raizI==raizX){ sum+=(i+1); n+= 1; }
		}
	    }
	    System.out.println(n+" "+sum);
	}
	
	public void printMFSet(){
	    for(int i=0;i<this.talla;i++){
		System.out.print(this.elArray[i]+",");
	    }
	    System.out.println();
	}
    }    
    
    public static boolean isValidPQ(int p,int n){
	if(p>n || p<0) return false;
	return true;
    }
    
    public static void main(String args[]) {
	Scanner tc = new Scanner(System.in);
	while(tc.hasNextInt()){
	    int n = tc.nextInt();
	    int m = tc.nextInt();
	    for(int i=0;i<m;i++){
		MFSet mfset = new MFSet(n);
		int op = tc.nextInt();
		if(op==1){
		    int p = tc.nextInt()-1;
		    int q = tc.nextInt()-1;
		    if(isValidPQ(p,n) && isValidPQ(q,n)){
			mfset.merge(p,q);
		    }
		    mfset.printMFSet();
		}
		else if(op==2){
		    int p = tc.nextInt()-1;
		    int q = tc.nextInt()-1;
		    if(isValidPQ(p,n) && isValidPQ(q,n)){
			mfset.append(p,q);
		    }
		    mfset.printMFSet();
		}
		else if(op==3){
		    int p = tc.nextInt()-1;
		    if(isValidPQ(p,n)){
			mfset.printSum(p);
		    }
		}
	    }
	}
    }
}

