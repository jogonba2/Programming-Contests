import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    
    private static class Turtle implements Comparable<Turtle>{
	private int weight;
	private int capacity;
	private int strength;
	private int acum;
	private int length;
	
	public Turtle(int weight,int strength){
	    this.weight = weight;
	    this.strength = strength;
	    this.acum = weight;
	    this.length = 1;
	}
	
	public int getWeight(){   return this.weight; }
	public int getStrength(){ return this.strength; }
	public int getAcum(){ return this.acum; }
	public int getLength(){ return this.length; }
	
	public void setAcum(int acum){ this.acum = acum; }
	public void setLength(int length){ this.length = length; }
	
	public int compareTo(Turtle o) {
	    if (this.strength == o.getStrength()) return this.weight - o.getWeight();
	    return (this.strength) - (o.getStrength());
	}
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	ArrayList<Turtle> turtles = new ArrayList<Turtle>();
	while(tc.hasNextInt()){
	    turtles.add(new Turtle(tc.nextInt(),tc.nextInt()));
	}
	
	Collections.sort(turtles);
	//for(Turtle t : turtles) System.out.println(t.getStrength()+","+t.getWeight());
	int max = turtles.size();
	for(int i=0;i<turtles.size();i++){
	    for(int k=max;k>=0;k--){
		if(turtles.get(i).getAcum()<=turtles.get(k).getStrength() && (1+turtles.get(i).getLength())>=turtles.get(k).getLength()){
		    turtles.get(k).setLength(turtles.get(i).getLength()+1);
		    turtles.get(k).setAcum(turtles.get(i).getAcum()+turtles.get(k).getWeight());
		    if(turtles.get(k).getLength()>max) max = turtles.get(k).getLength();
		}
	    }
	}
	max = Integer.MIN_VALUE;
	for(Turtle t : turtles){ if(t.getLength()>max) max = t.getLength(); }
	System.out.println(max);
    }
}

