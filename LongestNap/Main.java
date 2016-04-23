import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    
    private static class Tuple<X extends Comparable,Y extends Comparable> implements Comparable< Tuple<X,Y> > {
	
	private final X left;
	private final Y right;
	
	public Tuple(X right,Y left){
		this.left  = right;
		this.right = left;
	}
	
	public X getLeft(){ return this.left; }
	public Y getRight(){ return this.right; }
	
	public boolean equals(Object o){
		if(o==null) return false;
		if(o==this) return true;
		if(!(o instanceof Tuple)) return false;
		return ((Tuple<X,Y>)o).left==this.left && ((Tuple<X,Y>)o).right==this.right;
	}
	
	public boolean equals(Tuple<X,Y> other){
	    return true ? (this.left==other.getLeft() && this.right==other.getRight()) : false;
	}
	
	public int compareTo(Tuple<X,Y> other){ 
		return this.right.compareTo(other.right);	
	}
	
	 public Tuple<X,Y> difference(Tuple<X,Y> b){
	    return new Tuple((Integer)this.right-(Integer)b.getRight(),(Integer)this.left-(Integer)b.getLeft());
	}
    
    }	
    
   
    
    public static void main(String args[]){
	Scanner tc = new Scanner(System.in);
	while(tc.hasNext()){
	    int n = tc.nextInt();
	    ArrayList<Tuple<Tuple<Integer,Integer>,Tuple<Integer,Integer>>> acts = new ArrayList<Tuple<Tuple<Integer,Integer>,Tuple<Integer,Integer>>>();
	    String[] splitted;
	    String[] aux1,aux2;
	    tc.nextLine(); // Clear buffer
	    for(int i=0;i<n;i++){
		splitted = tc.nextLine().split(" ");
		aux1 = splitted[0].split(":");
		aux2 = splitted[1].split(":");
		acts.add(new Tuple(new Tuple(Integer.valueOf(aux1[0]),Integer.valueOf(aux1[1])),new Tuple(Integer.valueOf(aux2[0]),Integer.valueOf(aux2[1]))));
	    }
	    Collections.sort(acts);
	    ArrayList<Tuple<Integer,Integer>> naps = new ArrayList<Tuple<Integer,Integer>>();
	    acts.add(new Tuple(new Tuple(18,0),new Tuple(18,0)));
	    for(int i=0;i<acts.size()-1;i++){
		if(acts.get(i).getRight().equals(acts.get(i+1).getLeft())==false){
		    naps.add(acts.get(i+1).getLeft().difference(acts.get(i).getRight()));
		}
	    }
	    for(Tuple<Integer,Integer> nap : naps){
		System.out.println("Hours: "+nap.getLeft()+", minutes: "+nap.getRight());
	    }
	    /**for(Tuple<Tuple<Integer,Integer>,Tuple<Integer,Integer>> act : acts){
		System.out.println(act.getLeft().getLeft()+":"+act.getLeft().getRight()+","+act.getRight().getLeft()+":"+act.getRight().getRight());
	    }**/
	    
	}
    }
    
    
    
    
    
    
    
    
    
    
    
}
