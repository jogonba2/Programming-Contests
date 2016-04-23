import java.util.Scanner;
import java.util.Arrays;

class Carta implements Comparable{
	
	int num;
	char palo;
	
	public Carta(int num,char palo){
		this.num  = num;
		this.palo = palo;
	}

	public int compareTo(Object other){
		Carta o = (Carta)other;
		if(this.num>o.num) return 1;
		else if(this.num==o.num) return 0;
		else return -1;
	}
}

class Main
{
	public static boolean straightFlush(Carta[] cards)
	{
		if( flush(cards) && straight(cards))
		{
			return true;
		}
		return false;
	}
	public static int compareStraightFlush(Carta[] handBlack, Carta[] handWhite)
	{
		if(handBlack[4].num>handWhite[4].num) return 1;
		else if(handBlack[4].num<handWhite[4].num) return -1;
		else return 0;
	}
		
	public static boolean fourOfAKind(Carta[] x)
	{
		return (x[0].num == x[1].num && x[0].num == x[2].num && x[0].num == x[3].num ) || (x[4].num == x[1].num && x[4].num == x[2].num && x[4].num == x[3].num );
	}
	public static int compareFourOfAKind(Carta[] black, Carta[] white)
	{
		int solitariaBlack = 0;
		int solitariaWhite = 0;
		int pokerBlack = 0;
		int pokerWhite = 0;
		
		if(black[0].num == black[1].num) {pokerBlack = black[0].num;}
		else {pokerBlack = black[1].num; }
		if(white[0].num == white[1].num) {pokerWhite = white[0].num; }
		else {pokerWhite = white[1].num; }
		if(pokerBlack > pokerWhite) return 1;
		else if(pokerWhite > pokerBlack) return -1;
		else return 0;
	}
	
	public static boolean fullHouse(Carta[] cards)
	{
		if(cards[0].num  == cards[2].num && cards[3].num == cards[4].num || cards[0].num == cards[1].num && cards[2].num == cards[4].num)
		{
				return true;
		}
		return false;
	}
	public static int compareFullHouse(Carta[] handBlack, Carta[] handWhite)
	{
		int tb = -1;
		int tw = -1;
		if(handBlack[0].num==handBlack[1].num && handBlack[0].num==handBlack[2].num) tb = handBlack[0].num;
		else if(handBlack[2].num==handBlack[3].num && handBlack[2].num==handBlack[4].num) tb = handBlack[2].num;
		if(handWhite[0].num==handWhite[1].num && handWhite[0].num==handWhite[2].num) tw = handWhite[0].num;
		else if(handWhite[2].num==handWhite[3].num && handWhite[2].num==handWhite[4].num) tw = handWhite[2].num;
		if(tb>tw) return 1;
		else if(tb<tw) return -1;
		else return 0;
	}
	
	public static boolean flush(Carta[] cards)
	{
		if( cards[0].palo == cards[1].palo && cards[1].palo == cards[2].palo && cards[2].palo == cards[3].palo && cards[3].palo == cards[4].palo)
		{
			return true;
		}
		return false;
	}
	public static int compareFlush(Carta[] handBlack, Carta[] handWhite)
	{
		for(int i=4;i>=0;i--){
			if(handBlack[i].num>handWhite[i].num) return 1;
			else if(handBlack[i].num<handWhite[i].num) return -1;
		}
		return 0;
	}
	
	public static boolean straight(Carta[] cards)
	{
		if(cards[1].num == (cards[0].num+1) && cards[2].num == (cards[0].num+2) && cards[3].num == (cards[0].num+3) && cards[4].num == (cards[0].num+4))
		{
			return true;
		}
		return false;
	}
	public static int compareStraight(Carta[] handBlack, Carta[] handWhite)
	{
		if(handBlack[4].num>handWhite[4].num) return 1;
		else if(handBlack[4].num<handWhite[4].num) return -1;
		else return 0;
	}
	
	public static boolean threeOfAKind(Carta[] cards)
	{
		if(cards[0].num == cards[1].num && cards[0].num == cards[2].num || cards[2].num == cards[3].num && cards[2].num == cards[4].num || cards[1].num == cards[2].num && cards[1].num == cards[3].num)
		{
			return true;
		}
		return false;
	}
	public static int compareThreeOfAKind(Carta[] handBlack, Carta[] handWhite)
	{
		int tb = -1;
		int tw = -1;
		int solitaria1Black = 0;
		int solitaria2Black = 0;
		int solitaria1White = 0;
		int solitaria2White = 0;
		
		if(handBlack[0].num==handBlack[1].num && handBlack[0].num==handBlack[2].num)      {tb = handBlack[0].num; solitaria1Black = handBlack[4].num; solitaria2Black = handBlack[3].num;}
		else if(handBlack[1].num==handBlack[2].num && handBlack[1].num==handBlack[3].num) {tb = handBlack[1].num; solitaria1Black = handBlack[4].num; solitaria2Black = handBlack[0].num;}
		else if(handBlack[2].num==handBlack[3].num && handBlack[2].num==handBlack[4].num) {tb = handBlack[2].num; solitaria1Black = handBlack[1].num; solitaria2Black = handBlack[0].num;}
		if(handWhite[0].num==handWhite[1].num && handWhite[0].num==handWhite[2].num)      {tw = handWhite[0].num; solitaria1White = handWhite[4].num; solitaria2White = handWhite[3].num;}
		else if(handWhite[1].num==handWhite[2].num && handWhite[1].num==handBlack[3].num) {tw = handWhite[1].num; solitaria1White = handWhite[4].num; solitaria2White = handWhite[0].num;}
		else if(handWhite[2].num==handWhite[3].num && handWhite[2].num==handWhite[4].num) {tw = handWhite[2].num; solitaria1White = handWhite[1].num; solitaria2White = handWhite[0].num;}
		if(tb>tw) return 1;
		else if(tb<tw) return -1;
		else {
			if(solitaria1Black > solitaria1White) return 1;
			else if(solitaria1White > solitaria1Black) return -1;
			else if(solitaria2Black > solitaria2White) return 1;
			else if(solitaria2White > solitaria2Black) return -1;
			else return 0;
		}
	}
	
	public static boolean twoPairs(Carta[] x)
	{
		boolean enc = false;
		for(int i = 0; i<4;i++)
		{
			if(x[i].num == x[i+1].num)
				if(!enc)enc = true;
				else return true;
		}
		return false;
	}
	public static int compareTwoPairs(Carta[] black, Carta[] white)
	{
		int numPar1Black = 0; 
		int numPar2Black = 0;
		int numPar1White = 0;
		int numPar2White = 0;
		int solitariaBlack = 0;
		int solitariaWhite = 0;
		
		if(black[0].num != black[1].num){
			solitariaBlack = black[0].num;
			numPar1Black = black[3].num;
			numPar2Black = black[1].num;
		}
		else if(black[3].num != black[4].num){
			solitariaBlack = black[4].num;
			numPar1Black = black[2].num;
			numPar2Black = black[0].num;
		}
		else{
			solitariaBlack = black[2].num;
			numPar1Black = black[3].num;
			numPar2Black = black[0].num;
		}	
		if(white[0].num != white[1].num){
			solitariaWhite = white[0].num;
			numPar1White = white[3].num;
			numPar2White = white[1].num;
		}
		else if(white[3].num != white[4].num){
			solitariaWhite= white[4].num;
			numPar1White = white[2].num;
			numPar2White = white[0].num;
		}
		else{
			solitariaWhite = white[2].num;
			numPar1White = white[3].num;
			numPar2White = white[0].num;
		}
		if(numPar1Black > numPar1White) return 1;
		else if(numPar1White > numPar1Black) return -1;
		else{
			if(numPar2Black > numPar2White) return 1;
			else if(numPar2White > numPar2Black) return -1;
			else{
				if(solitariaBlack > solitariaWhite) return 1;
				else if(solitariaWhite > solitariaBlack) return -1;
				return 0;
			}
		}
	}
	
	public static boolean pair(Carta[] x)
	{
		for(int i = 0; i<4;i++)
		{
			if(x[i].num == x[i+1].num)return true;
		}
		return false;
	}
	public static int comparePair(Carta[] black, Carta[] white)
	{
		int numParBlack = 0; 
		int numParWhite = 0; 
		int posBlack = 0; 
		int posWhite = 0; 
		int z = 0; 
		int j = 0;
		int [] black2 = new int[3]; 
		int [] white2 = new int[3];
		
		for(int i = 0; i < 4; i++)
		{
			if(black[i].num == black[i+1].num) {numParBlack = black[i].num; posBlack = i;} 
			else if(black[i].num != numParBlack) {black2[j] = black[i].num; j++;}
			if(white[i].num == white[i+1].num) {numParWhite = white[i].num; posWhite = i;}
			else if(white[i].num != numParWhite) {white2[z] = white[i].num; z++;}
		}
		if (numParBlack > numParWhite) return 1;
		else if (numParWhite > numParBlack) return -1;
		else{
				if(posBlack != 3) black2[2] = black[4].num;
				if(posWhite != 3) white2[2] = white[4].num;
				for(int i = 2; i>=0; i--)
				{
					if (black2[i] > white2[i]) return 1;
					else if (white2[i] > black2[i]) return -1;
				}
				return 0;
			}
		
	}
	
	public static int compareHighCard(Carta[] black, Carta[] white)
	{
		for(int i = 4; i>=0 ; i--){
			if(black[i].num > white[i].num)return 1;
			else if(black[i].num < white[i].num) return -1;
		}
		return 0;
	}
	
	public static int hasHand(Carta[] hand){
		if(straightFlush(hand)) return 9;
		else if(fourOfAKind(hand)) return 8;
		else if(fullHouse(hand)) return 7;
		else if(flush(hand)) return 6;
		else if(straight(hand)) return 5;
		else if(threeOfAKind(hand)) return 4;
		else if(twoPairs(hand)) return 3;
		else if(pair(hand)) return 2;
		else return 1;
	}
	
	public static int winner(int b, int w, Carta[] black, Carta[] white)
	{
		if(b>w)return 1;
		else if(b<w)return -1;
		else {
				int result = 0;
				switch(b)
				{
					case 9: result = compareStraightFlush(black,white); break;
					case 8: result = compareFourOfAKind(black,white);   break;
					case 7: result = compareFullHouse(black,white);     break;
					case 6: result = compareFlush(black,white);         break;
					case 5: result = compareStraight(black,white);      break;
					case 4: result = compareThreeOfAKind(black,white);  break;
					case 3: result = compareTwoPairs(black,white);      break;
					case 2: result = comparePair(black,white);          break;
					case 1: result = compareHighCard(black,white);      break;
				}
				return result;
			}
	}

	public static void main(String args[]) {
		Scanner tc = new Scanner(System.in);
		String line;
		while(tc.hasNext()){
			line = tc.nextLine().trim().toLowerCase();
			if(line.length()==0) break;
			String[] lineSplitted = line.split(" ");
			Carta[] black = new Carta[5];
			Carta[] white = new Carta[5];
			int blackHand,whiteHand,auxNum,result;
			char auxChar;
			for(int i=0;i<5;i++){ 
				auxChar = lineSplitted[i].charAt(0);
				if(auxChar=='t') auxNum = 10;
				else if(auxChar=='j') auxNum = 11;
				else if(auxChar=='q') auxNum = 12;
				else if(auxChar=='k') auxNum = 13;
				else if(auxChar=='a') auxNum = 14;
				else auxNum = Character.getNumericValue(auxChar);
				black[i] = new Carta(auxNum,lineSplitted[i].charAt(1));
			} 
			for(int i=5;i<10;i++){ 
				auxChar = lineSplitted[i].charAt(0);
				if(auxChar=='t') auxNum = 10;
				else if(auxChar=='j') auxNum = 11;
				else if(auxChar=='q') auxNum = 12;
				else if(auxChar=='k') auxNum = 13;
				else if(auxChar=='a') auxNum = 14;
				else auxNum = Character.getNumericValue(auxChar);
				white[i-5] = new Carta(auxNum,lineSplitted[i].charAt(1));
			}
			Arrays.sort(black);
			Arrays.sort(white);
			blackHand = hasHand(black);
			whiteHand = hasHand(white);
			result = winner(blackHand,whiteHand,black,white);
			if (result == 1) System.out.println("Black wins.");
			else if(result == -1) System.out.println("White wins.");
			else System.out.println("Tie.");
		}
	}
}

