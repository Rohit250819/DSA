import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Too_Min_Too_Max{

  solve(int idx, int[] arr){
    return solve()
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String[] input = br.readLine().split(" ");
      int[] arr = new int[n];

      for(int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(input[i]);
      }

      solve(0, arr);
    }

    br.close();
  }
}