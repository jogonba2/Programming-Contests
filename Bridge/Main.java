import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

class Main {
	
	// A particular case of the Bucket Sort algorithm, O(n+k)
    public static void countingSort( ArrayList<Integer> a )
    {
        int min=a.get(0), max=a.get(0);
        for( int i=1; i < a.size(); i++ ) {
            min = Math.min( min, a.get(i) );
            max = Math.max( max, a.get(i) );
        }

        if ( max - min <= 10000000 ) { // To use 40MB of RAM at most

            int counter[] = new int [ max - min + 1 ];

            for( int i=0; i < a.size(); i++ ) counter[ a.get(i)-min ]++;

            int k=0;
            for( int i=0; i < counter.length; i++ ) {
                while( counter[ i ] > 0 ) {
                    a.set(k,i+min);
                    counter[i]--;
                    k++;
                }
            }

        } else {
            Collections.sort( a );
        }
    }
    
    
    
    public static int getGroups(int[][] res,ArrayList<Integer> personas){
		int i = 0;
		int time = 0;
		while(personas.size()!=0){
			if(personas.size()==1){
				res[i][0] = personas.get(0);
				res[i][1] = -1;
				time += Math.max(res[i][0],res[i][1]);
				personas.remove(0);
				i++;
			}
			else if(personas.size()==2){
				res[i][0] = personas.get(0);
				res[i][1] = personas.get(1);
				personas.remove(0); personas.remove(0);
				time += Math.max(res[i][0],res[i][1]);
				i++;
			}
			else if(personas.size()==3){
				res[i][0] = personas.get(0);
				res[i][1] = personas.get(2);
				time += Math.max(res[i][0],res[i][1]);
				i++;
				res[i][0] = personas.get(0);
				time += res[i][0];
				i++;
				res[i][0] = personas.get(0);
				res[i][1] = personas.get(1);
				personas.remove(0);personas.remove(0);personas.remove(0);
				time += Math.max(res[i][0],res[i][1]);
				i++;
			}
			else if(personas.size()==4){
				Integer A = personas.get(0),B = personas.get(1),C = personas.get(2), D = personas.get(3);
				int formaUno = A+3*B+D;
				int formaDos = 2*A+B+C+D;
				if(formaUno<formaDos){
					res[i][0] = A;
					res[i][1] = B;
					i++;
					res[i][0] = A;
					i++;
					res[i][0] = C;
					res[i][1] = D;
					i++;
					res[i][0] = B;
					i++;
					res[i][0] = A;
					res[i][1] = B;
					i++;
					time += formaUno;
				}
				else{
					res[i][0] = A;
					res[i][1] = D;
					i++;
					res[i][0] = A;
					i++;
					res[i][0] = A;
					res[i][1] = C;
					i++;
					res[i][0] = A;
					i++;
					res[i][0] = A;
					res[i][1] = B;
					i++;
					time += formaDos;
				}
				personas.remove(0);personas.remove(0);personas.remove(0);personas.remove(0);
			}
			else{
				Integer A = personas.get(0), B = personas.get(1), C = personas.get(personas.size()-2), D = personas.get(personas.size()-1);
				int formaUno = 2*B+A+D;
				int formaDos = 2*A+C+D;
				if(formaUno<formaDos){
					res[i][0] = A;
					res[i][1] = B;
					i++;
					res[i][0] = A;
					i++;
					res[i][0] = C;
					res[i][1] = D;
					i++;
					res[i][0] = B;
					i++;
					time += formaUno;
				}
				else{
					res[i][0] = A;
					res[i][1] = D;
					i++;
					res[i][0] = A;
					i++;
					res[i][0] = A;
					res[i][1] = C;
					i++;
					res[i][0] = A;
					i++;
					time += formaDos;
				}
			personas.remove(personas.size()-1); personas.remove(personas.size()-1);
			}
			
		}
		return time;
	}
    
	public static void main (String args[]) {
		Scanner tc = new Scanner(System.in);
		int nCases = tc.nextInt();
		for(int i=0;i<nCases;i++){
			String line;
			do{ line = tc.nextLine().trim();
			}while(tc.hasNextLine() && !line.isEmpty());
			int[][] res  = new int[5000][2];
			// Rellenar a -1 //
			for(int j=0;j<5000;j++){ res[j][0] = -1; res[j][1] = -1; }
			int nPersonas = tc.nextInt();
			ArrayList<Integer> personas = new ArrayList<Integer>();
			for(int j=0;j<nPersonas;j++) personas.add(tc.nextInt());
			countingSort(personas);
			int time = getGroups(res,personas);
			System.out.println(time);
			for(int j=0;j<5000;j++){
				if(res[j][0]!=-1){
					if(res[j][0]!=-1) System.out.print(res[j][0]);
					if(res[j][1]!=-1) System.out.print(" "+res[j][1]);
					System.out.println();
				}
				else break;
			}
			if(i<nCases-1) System.out.println();
			tc.nextLine();
		}
	}
}

