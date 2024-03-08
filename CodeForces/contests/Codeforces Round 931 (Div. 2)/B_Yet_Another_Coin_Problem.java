import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Yet_Another_Coin_Problem{

  private static void solve(int n, int[] arr){

  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());
    while(testCases-- > 0){
      int[] arr = {1, 3, 6, 10 , 15};
      int n = Integer.parseInt(br.readLine());
      solve(n, arr);
    }

    br.close();
  }
}