import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Make_It_Ugly{

  private static void solve(int n, int[] arr){
    int keyElement = arr[0];

    //i checked from both sides of the array

    int minToRemove = Integer.MAX_VALUE;
    int interval = 0;

    for(int i = 0; i < n; i++){
      if(arr[i] == keyElement){
        interval++;
      }else{
        minToRemove = Math.min(interval, minToRemove);
        interval = 0;
      }
    }

    interval = 0;

    for(int i = n - 1; i >= 0; i--){
      if(arr[i] == keyElement){
        interval++;
      }else{
        minToRemove = Math.min(interval, minToRemove);
        interval = 0;
      }
    }
    
    if(minToRemove == Integer.MAX_VALUE) System.out.println(-1);
    else System.out.println(minToRemove);
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