import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class TheKnightsOfTheRoundTable {
	
	public static void main(String args[]) {
		Scanner tc = new Scanner(System.in);
		tc.useLocale(Locale.US);
		ArrayList<Double> res = new ArrayList<Double>();
		double a,b,c;
		double s,p;
		while(tc.hasNextLine()){ // Arreglar while //
			a = tc.nextDouble();
			b = tc.nextDouble();
			c = tc.nextDouble();
			s = (a+b+c)/2;
			p = (s-a)*(s-b)*(s-c);
			res.add(Double.valueOf(Math.sqrt(s*p)/s));
		}
		for(Double d : res) System.out.println("The radius of the round table is: "+d);
	}
}

