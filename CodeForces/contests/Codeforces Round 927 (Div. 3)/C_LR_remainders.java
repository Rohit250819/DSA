import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_LR_remainders{

  private static void solve(int n, int m, int[] arr, String command){
    int l = 0, r = n - 1;

    for(int i = 0; i < n - 1; i++){
      char ch = command.charAt(i);
      if(ch == 'L' ) l++;
      else if(ch == 'R') r--;
    }



    int[] product = new int[n];
    product[n - 1] = arr[l] % m;

    for(int i = n - 2; i >= 0; i--){
      char ch = command.charAt(i);
      if(ch == 'L'){
        product[i] = (product[i + 1] * arr[--l]) % m;
      }else{
        product[i] = (product[i + 1] * arr[++r]) % m;
      }
    }


    for(int val : product)
      System.out.print(val + " ");
    
    System.out.println();
  }


  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);

      String[] input1 = br.readLine().split(" ");
      int[] arr = new int[n];
      for(int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(input1[i]);
      }

      String command = br.readLine();

      solve(n, m, arr, command);
    }

    br.close();
  }
}