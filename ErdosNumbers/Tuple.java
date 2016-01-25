public class Tuple<X extends Comparable,Y extends Comparable> implements Comparable< Tuple<X,Y> > {
	
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

	public int compareTo(Tuple<X,Y> other){ 
		return this.right.compareTo(other.right);	
	}
}

