import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Rudolf_and_121{

  private static void solve(int n, int[] arr){
    for(int i = 0; i < n - 2; i++){
      if(arr[i] < 0) break;
      arr[i + 1] -= 2 * arr[i];
      arr[i + 2] -= arr[i];
      arr[i] = 0;
    }

    for(int e : arr){
      if(e != 0){
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");
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