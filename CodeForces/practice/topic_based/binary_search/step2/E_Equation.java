import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_Equation{

  private static double check(double mid){
    return mid * mid + Math.sqrt(mid);
  }

  private static void solve(double C){
    double l = 0, r = 1e10;

    for(int i = 0; i <= 50; i++){
      double mid = l + (r - l)/2;
      if(check(mid) >= C){
        r = mid;
      }else{
        l = mid;
      }
    }
    System.out.println(r);
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    double C = Double.parseDouble(br.readLine());

    solve(C);

    
  }
}