import java.util.Scanner;
import java.util.HashMap;

public class Main{
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	HashMap<Character,Character> note = new HashMap<Character,Character>();
	note.put('1','1'); note.put('0','0'); note.put('-','-');
	note.put('A','2'); note.put('B','2'); note.put('C','2');
	note.put('D','3'); note.put('E','3'); note.put('F','3');
	note.put('G','4'); note.put('H','4'); note.put('I','4');
	note.put('J','5'); note.put('K','5'); note.put('L','5');
	note.put('M','6'); note.put('N','6'); note.put('O','6');
	note.put('P','7'); note.put('Q','7'); note.put('R','7'); note.put('S','7');
	note.put('T','8'); note.put('U','8'); note.put('V','8');
	note.put('W','9'); note.put('X','9'); note.put('Y','9'); note.put('Z','9');
	while(tc.hasNextLine()){
	    String line = tc.nextLine().trim();
	    for(int i=0;i<line.length();i++){
		System.out.print(note.get(line.charAt(i)));
	    }
	    System.out.println();
	    
	}
    }
}

