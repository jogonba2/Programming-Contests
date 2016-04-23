import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class Main{
    
    public static double round(double value, int places) {
	if (places < 0) throw new IllegalArgumentException();
	long factor = (long) Math.pow(10, places);
	value = value * factor;
	long tmp = Math.round(value);
	return (double) tmp / factor;
    }
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	tc.useLocale(Locale.US);
	int nCases = tc.nextInt();
	while(nCases!=0){
	    double avg = 0;
	    double[] expenses = new double[nCases];
	    for(int i=0;i<nCases;i++){
		expenses[i] = tc.nextDouble();
		avg += expenses[i];
	    }
	    avg /= nCases;
	    double posDiff = 0, negDiff = 0;
	    for(int i=0;i<nCases;i++){
		if(expenses[i]>avg) posDiff += (double)(long)((expenses[i]-avg)*100.0)/100.0;
		else    negDiff += (double)(long)((expenses[i]-avg)*100.0)/100.0;
	    }
	    negDiff = -negDiff;
	    if(negDiff>posDiff) System.out.format(Locale.US,"$%.2f\n",negDiff);
	    else                System.out.format(Locale.US,"$%.2f\n",posDiff);
	    nCases = tc.nextInt();
	}
	
	
    }
    
}
