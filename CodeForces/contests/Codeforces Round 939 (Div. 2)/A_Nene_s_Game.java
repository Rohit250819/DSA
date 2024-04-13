import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Nene_s_Game{

  public static void solve(int k, int q, int[] a, int[] n){
    for(int i = 0; i < q; i++){
      if(n[i] < a[0]) System.out.print(n[i] + " ");
      else System.out.print((a[0] - 1) + " ");
    }
    System.out.println();
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      String[] input1 = br.readLine().split(" ");
      String[] input2 = br.readLine().split(" ");
      String[] input3 = br.readLine().split(" ");

      int k = Integer.parseInt(input1[0]);
      int q = Integer.parseInt(input1[1]);

      int[] a = new int[k];

      for(int i = 0; i < k; i++){
        a[i] = Integer.parseInt(input2[i]);
      }

      int[] n = new int[q];

      for(int i = 0; i < q; i++){
        n[i] = Integer.parseInt(input3[i]);
      }

      solve(k, q, a, n);
    }

    br.close();
  }
}