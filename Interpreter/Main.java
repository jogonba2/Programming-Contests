import java.util.Scanner;

class Main{
	
	public static boolean isHalt(int inst){
		if(inst==100) return true;
		return false;
	}
	
	public static int exec(int[] RAM,int[] REG){
		int numInst = 0;
		int iInst   = 0;
		int actInst = RAM[iInst];
		boolean jump = false;
		actInst = actInst%1000;
		while(!isHalt(actInst)){
			if(actInst/100==2){
				REG[(actInst/10)%10]  = actInst%10;
				REG[(actInst/10)%10] %= 1000;
				iInst++;
			}
			else if(actInst/100==3){
				REG[(actInst/10)%10] += actInst%10;
				REG[(actInst/10)%10] %= 1000;
				iInst++;
			}
			else if(actInst/100==4){
				REG[(actInst/10)%10] *= actInst%10;
				REG[(actInst/10)%10] %= 1000;
				iInst++;
			}
			else if(actInst/100==5){
				REG[(actInst/10)%10]  = REG[actInst%10];
				REG[(actInst/10)%10] %= 1000;
				iInst++;
			}
			else if(actInst/100==6){
				REG[(actInst/10)%10] += REG[actInst%10];
				REG[(actInst/10)%10] %= 1000;
				iInst++;
			}
			else if(actInst/100==7){
				REG[(actInst/10)%10] *= REG[actInst%10];
				REG[(actInst/10)%10] %= 1000;
				iInst++;
			}
			else if(actInst/100==8){
				REG[(actInst/10)%10]  = RAM[REG[actInst%10]];
				REG[(actInst/10)%10] %= 1000;
				iInst++;
			}
			else if(actInst/100==9){
				RAM[REG[actInst%10]]       = REG[(actInst/10)%10];
				RAM[actInst%10] %= 1000;
				iInst++;
			}
			else if(actInst/100==0){
				if(REG[actInst%10]!=0){
					iInst = REG[(actInst/10)%10];
				}
				else iInst++;
			}
			numInst += 1;
			actInst = RAM[iInst]%1000;
		}
		return numInst+1;				
	}
	
	public static void main (String args[]) {
		Scanner tc   = new Scanner(System.in);
		int nCases = tc.nextInt();
		int[] res = new int[nCases];
		tc.nextLine(); // Limpiar buffer
		String linea;
		linea = tc.nextLine().trim();
		for(int i=0;i<nCases;i++){
			int[] RAM = new int[1000];
			int[] REG = new int[10];	
			int iRam = 0;
			int actInst;
			String line = tc.nextLine().trim();
			while(!line.isEmpty()){
				actInst = Integer.valueOf(line.trim());
				RAM[iRam++] = actInst%1000;
				try{
					line = tc.nextLine().trim();
				}catch(Exception e){ break; }
			}
			res[i] = exec(RAM,REG);
		}
		for(int i=0;i<nCases;i++){
			if(i<nCases-1) System.out.println(res[i]+"\n");	
			else           System.out.println(res[i]);
		}
	}
}

