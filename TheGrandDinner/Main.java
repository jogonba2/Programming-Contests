import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main{
	
    static class Equipo implements Comparable{
	private int id;
	private int nMiembros;
	private ArrayList<Integer> mesa;
	
	public Equipo(int id,int nMiembros){
	    this.id = id;
	    this.nMiembros = nMiembros;
	    this.mesa = new ArrayList<Integer>();
	}
	
	public void setMiembros(int nMiembros){ this.nMiembros = nMiembros; }
	public int getMiembros(){ return this.nMiembros; }
	public void addMesa(int i){ this.mesa.add(i); this.nMiembros--; }
	public ArrayList<Integer> getMesas(){ return this.mesa; }
	
	public int compareTo(Object other){
	    Equipo o = (Equipo) other;
	    if(this.nMiembros>o.getMiembros()) return 1;
	    else if(this.nMiembros<o.getMiembros()) return -1;
	    return 0;
	}
    }
    
    static class Mesa implements Comparable{
	private int capacidad;
	private int id;
	
	public Mesa(int id,int capacidad){
	    this.id = id;
	    this.capacidad = capacidad;
	}
	
	public int getId(){ return this.id; }
	public void setCapacidad(int capacidad){ this.capacidad = capacidad; }
	public int getCapacidad(){ return this.capacidad; }
	public void addComensal(){ this.capacidad--; }
	
	public int compareTo(Object other){
	    Mesa o = (Mesa) other;
	    if(this.capacidad>o.getCapacidad()) return 1;
	    else if(this.capacidad<o.getCapacidad()) return -1;
	    return 0;
	}
    }
	
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int M,N;
	M = tc.nextInt();
	N = tc.nextInt();
	while(M!=0 && N!=0){
	    ArrayList<Equipo> equipos = new ArrayList<Equipo>();
	    ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	    for(int i=0;i<M;i++) equipos.add(new Equipo(i+1,tc.nextInt()));
	    for(int i=0;i<N;i++){ mesas.add(new Mesa(i+1,tc.nextInt())); }
	    boolean completed = true;
	    // Por cada equipo //
	    for(int i=0;i<M;i++){
		// Reordenar mesas en orden descendente por capacidad //
		Collections.sort(mesas,Collections.reverseOrder());
		for(int j=0;j<N;j++){
		    if(equipos.get(i).getMiembros()==0) break;
		    else{
			if(mesas.get(j).getCapacidad()>=1){
			    mesas.get(j).addComensal();
			    equipos.get(i).addMesa(mesas.get(j).getId());
			}
		    }
		}
		if(equipos.get(i).getMiembros()>0){ completed = false; break; }
	    }
	    if(!completed){ System.out.println("0"); }
	    else{
		System.out.println("1");
		for(int i=0;i<M;i++){
		    ArrayList<Integer> mesasEquipo = equipos.get(i).getMesas();
		    for(int j=0;j<mesasEquipo.size();j++){
			System.out.print(mesasEquipo.get(j));
			if(j<mesasEquipo.size()-1) System.out.print(" ");
		    }
		    System.out.println();
		}
	    }
	    M = tc.nextInt();
	    N = tc.nextInt();
	}
		
		
	}
}

