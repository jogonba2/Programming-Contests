import java.util.Arrays;
import java.util.Scanner;
 
public class Main2{
 
 public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  final int maxM = 50;
  final int maxN = 1000;
  char[][] DNA = new char[maxM][maxN];
  int[] countACGT = new int[26];
 
  while (input.hasNext()) {
   int T = input.nextInt();
 
   while (T > 0) {
    int m = input.nextInt();
    int n = input.nextInt();
 
    for (int i = 0; i < m; ++i) {
     DNA[i] = input.next().toCharArray();
    }
 
    StringBuilder consensusString = new StringBuilder();
    int consensusError = 0;
    for (int i = 0; i < n; ++i) {
     Arrays.fill(countACGT, 0);
     for (int j = 0; j < m; ++j) {
      ++countACGT[DNA[j][i] - 'A'];
     }
 
     int maxCount = Integer.MIN_VALUE;
     int maxIndex = -1;
     for (int j = 0; j < countACGT.length; ++j) {
      if (maxCount < countACGT[j]) {
       maxCount = countACGT[j];
       maxIndex = j;
      }
     }
 
     consensusString.append((char) ('A' + maxIndex));
     consensusError += m - maxCount;
    }
 
    System.out.println(consensusString);
    System.out.println(consensusError);
 
    --T;
   }
  }
 }
}
