import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Binary_Search{

  private static void solve(int[] arr, int x, int n){
    int left = 0, right = n - 1;

    while(left <= right){
      int mid = left + (right - left)/2;

      if(arr[mid] == x){
        System.out.println("YES");
        return;
      }else if(arr[mid] > x){
        right = mid - 1;
      }else{
        left = mid + 1;
      }
    }

    System.out.println("NO");
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    String[] input2 = br.readLine().split(" ");
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(input2[i]);
    }

    String[] input3 = br.readLine().split(" ");
    int[] find = new int[k];
    for(int i = 0; i < k; i++){
      find[i] = Integer.parseInt(input3[i]);
    }

    for(int x : find){
      solve(arr, x, n);
    }

    br.close();
  }
}