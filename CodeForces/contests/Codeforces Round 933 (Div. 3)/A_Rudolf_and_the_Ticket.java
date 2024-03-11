import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Rudolf_and_the_Ticket{
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      String[] input1 = br.readLine().split(" ");
      String[] input2 = br.readLine().split(" ");
      String[] input3 = br.readLine().split(" ");

      int n = Integer.parseInt(input1[0]);
      int m = Integer.parseInt(input1[1]);
      int k = Integer.parseInt(input1[2]);

      int[] left = new int[n];
      for(int i = 0; i < n; i++){
        left[i] = Integer.parseInt(input2[i]);
      }
      int[] right = new int[m];
      for(int i = 0; i < m; i++){
        right[i] = Integer.parseInt(input3[i]);
      }

      int ans = 0;
      for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
          if(left[i] + right[j] <= k) ans++;
        }
      }

      System.out.println(ans);
    }

    br.close();
  }
}