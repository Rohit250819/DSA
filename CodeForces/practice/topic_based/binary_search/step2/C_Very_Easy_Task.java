// @author->Rohit Kumar
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Very_Easy_Task{

  private static boolean good(int n, int x, int y, int time){
    if(time < Math.min(x, y)) return false;

    int cnt = 1;
    time -= Math.min(x, y);
    cnt += time/x + time/y;

    return cnt >= n;
  }

  private static void solve(int n, int x, int y){
    int left = 0, right = Math.max(x, y) * n;

    while(right > (left + 1)){
      int mid = left + (right - left)/2;

      if(good(n, x, y, mid))
        right = mid;
      else
        left = mid;
    }

    System.out.println(right);
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    
    int n = Integer.parseInt(input[0]);
    int x = Integer.parseInt(input[1]);
    int y = Integer.parseInt(input[2]);

    solve(n, x, y);

    br.close();
  }
}