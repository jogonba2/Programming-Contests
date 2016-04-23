import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class Main{
    
    private static boolean isPrime(int num) {
        if (num == 2 ) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
	for(int i=0;i<chars.length();i++){ hash.put(chars.charAt(i),i+1); }
	while(tc.hasNextLine()){
	    String word = tc.nextLine().trim();
	    int q = 0;
	    for(int i=0;i<word.length();i++){ q += hash.get(word.charAt(i)); }
	    if(isPrime(q)) System.out.println("It is a prime word.");
	    else 	   System.out.println("It is not a prime word.");
	}
    }
}

