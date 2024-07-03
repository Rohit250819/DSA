import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D_Fast_search{

  private static int closest_to_the_left(int[] arr, int n, int l){
    int left = -1, right = n;

    while(right > (left + 1)){
      int mid = left + (right - left)/2;

      if(arr[mid] < l){
        left = mid;
      }else{
        right = mid;
      }
    }

    return right;
  }

  private static int closest_to_the_right(int[] arr, int n, int r){
    int left = -1, right = n;

    while(right > (left + 1)){
      int mid = left + (right - left)/2;

      if(arr[mid] > r){
        right = mid;
      }else{
        left = mid;
      }
    }

    return left;
  }

  private static void solve(int[] arr, int n, int l, int r){

    int left = closest_to_the_left(arr,n, l);
    int right = closest_to_the_right(arr,n, r);

    System.out.print(right - left + 1 + " ");
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");
    int[] arr = new int[n];
    
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(arr);

    int k = Integer.parseInt(br.readLine());
    while(k-- > 0){
      String[] input2 = br.readLine().split(" ");
      int l = Integer.parseInt(input2[0]);
      int r = Integer.parseInt(input2[1]);

      solve(arr, n, l, r);
    }

    br.close();
  }
}