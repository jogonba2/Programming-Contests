import java.util.Scanner;
import java.util.ArrayList;
public class PrimaryArithmetic {
	
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		ArrayList<Integer> res = new ArrayList<Integer>();
		int it = 0;
		int carry = 0;
		int a1 = tc.nextInt();
		int a2 = tc.nextInt();
		String n1 = String.valueOf(a1);
		String n2 = String.valueOf(a2);
		while(a1!=0 && a2!=0){
			carry = 0;
			for(int i=0;i<Math.min(n1.length(),n2.length());i++){
				if( Character.getNumericValue(n1.charAt(i))+ Character.getNumericValue(n2.charAt(i))>=10) carry += 1;
			}
			res.add(carry);
			it += 1;
			a1 = tc.nextInt();
			a2 = tc.nextInt();
			n1 = String.valueOf(a1);
			n2 = String.valueOf(a2);
		}
		for(Integer c : res){
			System.out.println(c);
		}
	}
}
