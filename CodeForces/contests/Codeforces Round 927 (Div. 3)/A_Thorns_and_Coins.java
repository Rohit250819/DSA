import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_Thorns_and_Coins{

  private static int solve(int idx, String path, int ans, int[] dp){
    if(idx >= path.length()) return ans;
    if(path.charAt(idx) == '@') ans += 1;
    else if(path.charAt(idx) == '*') return ans;

    if(dp[idx] != -1) return dp[idx];
    int path1 = solve(idx + 1, path, ans, dp);
    int path2 = solve(idx + 2, path, ans, dp);

    return dp[idx] = Math.max(path1, path2);
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String path = br.readLine();
      int[] dp = new int[n];
      Arrays.fill(dp, -1);
      System.out.println(solve(0, path, 0, dp));
    }

    br.close();
  }
}