import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Make_It_Ugly{

  private static void solve(int n, int[] arr){
    for(int i = 1; i < n - 1; i++){
      if(arr[i - 1] == arr[i + 1] && arr[i] != arr[i - 1]){
        System.out.println(i);
        return;
      }
    }

    System.out.println(-1);
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

      solve(n, arr);
    }

    br.close();
  }
}