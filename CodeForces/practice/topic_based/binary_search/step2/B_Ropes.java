// @author->Rohit Kumar
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Ropes{


  private static boolean good(int[]arr, int n, int k, double x){
    int s = 0;
    for(int i = 0; i < n; i++){
      s += Math.floor(arr[i]/x);
    }

    return s >= k;
  }

  private static void solve(int[] arr, int n, int k){
    double l = 0, r = 1e8;
    for(int i = 0; i < 100; i++){
      double mid = l + (r - l)/2;
      if(good(arr, n, k, mid)){
        l = mid;
      }else{
        r = mid;
      }
      // System.out.println(i + "l->"+l + " r->"+r);
    }

    System.out.println(l);
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(br.readLine());
    }

    solve(arr, n, k);

    br.close();
  }
}