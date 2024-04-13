import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Nene_and_the_Card_Game{

  private static void solve(int n, int[] cards){
    int[] freq = new int[n + 1];
    int ans = 0;

    for(int card : cards){
      freq[card]++;
    }

    for(int f : freq){
      if(f == 2) ans++;
    }

    System.out.println(ans);
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String[] input = br.readLine().split(" ");

      int[] cards = new int[n];
      for(int i = 0; i < n; i++){
        cards[i] = Integer.parseInt(input[i]);
      }

      solve(n, cards);

    }

    br.close();
  }
}