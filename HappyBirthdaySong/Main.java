import java.util.Scanner;

class Main{
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	int n      = tc.nextInt();
	String[] names  =  new String[n];
	String[] song   = {"Happy","birthday","to","you","Happy","birthday","to","you","Happy","birthday","to","Rujia","Happy","birthday","to","you"};
	int[]    counts = new int[n];
	tc.nextLine();
	for(int i=0;i<n;i++){ names[i] = tc.nextLine().trim(); counts[i] = 0; }
	int i = 0,j = 0,c = 0;
	while(c<n || j<song.length-1){
	    System.out.println(names[i]+": "+song[j]);
	    if(counts[i]==0){ c+=1; counts[i]=1; }	    
	    i = (i+1)%n;
	    j = (j+1)%(song.length);
	}
	System.out.println(names[i]+": "+song[j]);
	
    }
    
}
