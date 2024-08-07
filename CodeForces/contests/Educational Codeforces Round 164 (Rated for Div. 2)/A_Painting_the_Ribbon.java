import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Painting_the_Ribbon{

  private static void solve(int n, int m, int k){
    if(m == 1){
      System.out.println("NO");
      return;
    }

    int x = (n + (m - 1))/m;//ceil value of n / m;
    x = n - x;

    if(k >= x) System.out.println("NO");
    else System.out.println("YES");
    
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      String[] input = br.readLine().split(" ");

      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);
      int k = Integer.parseInt(input[2]);

      solve(n, m, k);
    }

    br.close();
  }
}