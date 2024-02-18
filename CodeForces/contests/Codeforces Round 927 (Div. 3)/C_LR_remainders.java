import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_LR_remainders{

  private static void solve(int n, int m, int[] arr, String command){
    long product = 1;
    for(int e : arr){
      product *= (long)e;
    }

    System.out.print(product % (long)m + " ");
    int start = 0;
    int end = n - 1;

    for(int i = 0; i < n - 1; i++){
      char ch = command.charAt(i);
      if(ch == 'L'){
        product /= arr[start++];
        System.out.print(product % (long)m + " ");
      }else{
        product /= arr[end--];
        System.out.print(product % (long)m + " ");
      }
    }
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