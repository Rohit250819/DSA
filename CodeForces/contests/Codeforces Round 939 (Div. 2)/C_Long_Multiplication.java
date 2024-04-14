import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Long_Multiplication{

  private static void solve(String x, String y){
    int n = x.length();
    String fa = "";
    String fb = "";

    for(int i = 0; i < n; i++){
      char cx = x.charAt(i);
      char cy = y.charAt(i);

      char max = cx > cy ? cx : cy;
      char min = cx < cy ? cx : cy;

      if(fa.compareTo(fb) > 0){
        fa += min;
        fb += max;
      }else{
        fa += max;
        fb += min;
      }
    }

    System.out.println(fa);
    System.out.println(fb);

  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      String x = br.readLine();
      String y = br.readLine();

      solve(x, y);
    }

    br.close();
  }
}