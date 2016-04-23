import java.util.Scanner;
import java.util.Locale;
public class Main{
    
    public static double euclidean(double x1,double y1,double x2,double y2){
	return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in).useLocale(Locale.ENGLISH);	
	while(tc.hasNext()){
	    int nToperas = tc.nextInt();
	    double tx,ty,px,py,ax,ay;
	    boolean catched = false;
	    tx = tc.nextDouble();
	    ty = tc.nextDouble();
	    px = tc.nextDouble();
	    py = tc.nextDouble();
	    for(int i=0;i<nToperas;i++){
		ax = tc.nextDouble();
		ay = tc.nextDouble();
		if(euclidean(px,py,ax,ay)/2.0>=euclidean(tx,ty,ax,ay) && !catched){
		    System.out.format(Locale.ENGLISH,"The gopher can escape through the hole at (%.3f,%.3f).\n",ax,ay);
		    catched = true;
		}
	    }
	    if(!catched) System.out.println("The gopher cannot escape.");
	    String linea;
	    do { linea = tc.nextLine().trim();
	    }while(tc.hasNext() && linea.length()!=0);
	}
    }
}

