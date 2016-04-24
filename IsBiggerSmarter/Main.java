import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    
    private static class Elephant implements Comparable{
	private int iq;
	private int weight;
	private int id;
	
	public Elephant(int id,int weight,int iq){
	    this.iq = iq;
	    this.weight = weight;
	    this.id = id;
	}
	
	public int getIQ(){ return this.iq; }
	public int getWeight(){ return this.weight; }
	public int getID(){ return this.id; }
	
	public int compareTo(Object other){
	    Elephant o = (Elephant) other;
	    if(this.weight<o.getWeight()) return 1;
	    else if(this.weight==o.getWeight()){
		if(this.iq>o.getIQ()) return 1;
		else if(this.iq<o.getIQ()) return -1;
		else return 0;
	    }
	    return -1;
	}
    }
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	ArrayList<Elephant> elephants = new ArrayList<Elephant>();
	int i=1;
	while(tc.hasNextInt()){
	    elephants.add(new Elephant(i,tc.nextInt(),tc.nextInt()));
	    i++;
	}
	// Ordenar elehantes //
	Collections.sort(elephants,Collections.reverseOrder());
	for(Elephant e : elephants){
	    System.out.println("Elefante: "+e.getID()+" con peso: "+e.getWeight()+" e inteligencia: "+e.getIQ());
	}
    }
}

