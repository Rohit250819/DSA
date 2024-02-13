import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_Following_the_String{

  private static void solve(int n, int[] arr){
    StringBuilder ans = new StringBuilder();
        List<Integer>[] freq = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            freq[i] = new ArrayList<>();
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            freq[0].add(ch - 'a');
        }

        int nextFreq = 0;

        for (int i = 0; i < n; i++) {
            if (!freq[arr[i]].isEmpty()) {
                ans.append((char) (freq[arr[i]].get(0) + 'a'));
                int temp = freq[arr[i]].remove(0);
                nextFreq = Math.max(nextFreq, arr[i] + 1);
                freq[nextFreq].add(temp);
            } 
        }

        System.out.println(ans);
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());
    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String[] input = br.readLine().split(" ");
      int[] arr = new int[n];

      for(int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(input[i]);
      }
      
      solve(n, arr);
    }

    br.close();
  }
}