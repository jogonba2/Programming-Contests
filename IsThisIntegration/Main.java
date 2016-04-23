import java.util.*;

class Main {
    public static double PI = Math.PI;
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	String line;
	double a,x,y,z;
	while(tc.hasNext()){
	    line = tc.nextLine();
	    a = Double.parseDouble(line);
	    x = a*a*(1-Math.sqrt(3)+PI/3);
	    y = a*a*(2*Math.sqrt(3)-4+PI/3);
	    z = a*a*(4-2*PI/3-Math.sqrt(3));
	    System.out.printf("%.3f %.3f %.3f",x,y,z);
	    System.out.println();
        }
    }
}
