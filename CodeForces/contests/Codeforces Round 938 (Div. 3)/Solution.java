import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{

  private static void solve(int n, int a, int b){
    int totalCost = 0;
    if(2 * a > b){
      if(n % 2 == 0) totalCost = (n / 2) * b;
      else totalCost = (n / 2) * b + a;
    }else{
      totalCost = n * a;
    }

    System.out.println(totalCost);
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      String[] input = br.readLine().split(" ");

      int n = Integer.parseInt(input[0]);
      int a = Integer.parseInt(input[1]);
      int b = Integer.parseInt(input[2]);

      solve(n, a, b);
    }

    br.close();
  }
}