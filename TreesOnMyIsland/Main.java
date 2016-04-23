import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    
    private static class A{
	private double area;
	private long puntos;
	
	public A(double area,long puntos){
	    this.area = area;
	    this.puntos = puntos;
	}
	
	public double getArea(){ return this.area; }
	public double getPuntos(){ return this.puntos; }
    }
     
    public static long gcd(long a,long b){
	if(b==0) return a;
	if(a%b==0 || a==0) return b;
	else return gcd(b,a%b);
    }
    
    public static A area(long[][] p){
	double total = 0;
	long dx,dy;
	int n = p.length;
	int X=0,Y=1;
	int i,j;
	long puntos = 0;
	for(i=0;i<n;i++){
	    j=(i+1)%n;
	    total += p[i][X]*p[j][Y]-p[j][X]*p[i][Y];
	    dx = p[j][X]-p[i][X];
	    dy = p[j][Y]-p[i][Y];
	    puntos += gcd(Math.abs(dx),Math.abs(dy));
	}
	A res = new A(Math.abs(total)/2,puntos);
	return res;
    }
    
    public static void main (String args[]) {
	Scanner tc = new Scanner(System.in);
	int n = tc.nextInt();
	while(n!=0){
	    long[][] p = new long[n][2];
	    for(int i=0;i<n;i++){
		p[i][0] = tc.nextLong();
		p[i][1] = tc.nextLong();
	    }
	    A res = area(p);
	    // Ya se conoce el area del poligono A y el numero de vértices del polígono B //
	    // Teorema de Pick I = A - (B/2) + 1 //
	    System.out.println((long)(res.getArea()-(res.getPuntos()/2)+1));
	    
	    n = tc.nextInt();
	}
	
    }
}
