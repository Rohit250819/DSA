import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Closest_to_the_Right{

  private static void solve(int[] arr, int n, int x){
    int left = -1, right = n;

    while(right > (left + 1)){
      int mid = left + (right - left)/2;

      if(arr[mid] >= x){
        right = mid;
      }else{
        left = mid;
      }
    }

    System.out.println(right + 1);
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
    int[] query = new int[k];
    for(int i = 0; i < k; i++){
      query[i] = Integer.parseInt(input3[i]);
    }

    for(int i = 0; i < k; i++){
      solve(arr, n, query[i]);
    }

    br.close();
  }
}