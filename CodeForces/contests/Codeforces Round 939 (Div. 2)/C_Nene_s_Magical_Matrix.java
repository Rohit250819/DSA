import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Nene_s_Magical_Matrix{

  public static void solve(int n ){
    int sum = 0;

    for(int i = 1; i <= n; i++){
      sum += i * (2 * i - 1);
    }

    System.out.println(sum + " " + 2 * n + " ");

    for(int i = n - 1; i >= 0; i--){
      for(int type = 1; type <= 2; type++){
        System.out.print(type + " " + (i + 1) + " ");

        for(int p = 1; p <= n; p++){
          System.out.print(p + " ");
        }

        System.out.println();
      }
    }

  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());

      solve(n);
    }

    br.close();
  }
}