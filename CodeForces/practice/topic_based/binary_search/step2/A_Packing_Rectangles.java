import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Packing_Rectangles{

  private static boolean good(long w, long h, long n, long x){
    return (x / w) * (x / h) >= n;
  }

  private static void solve(long w, long h, long n){
    long left = 0;
    long right = 1;

    while(!good(w, h, n, right)) right *= 2;

    while(right > (left + 1)){
      long mid = left + (right - left)/2;
      
      if(good(w, h, n, mid))
          right = mid;
      else
          left = mid;
    }

    System.out.println(right);
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    long w = Long.parseLong(input[0]);
    long h = Long.parseLong(input[1]);
    long n = Long.parseLong(input[2]);

    solve(w, h, n);

    br.close();
  }
}