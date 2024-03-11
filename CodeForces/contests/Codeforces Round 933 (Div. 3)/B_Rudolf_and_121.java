import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Rudolf_and_121{
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String[] input = br.readLine().split(" ");

      long[] arr = new long[n];
      for(int i = 0; i < n; i++){
        arr[i] = Long.parseLong(input[i]);
      }
      
      long num = 0;
      for(int i = 0; i < n; i++){
        num = num * 10 + arr[i];
      }

      // System.out.println(num);
      boolean flag = false;
      for(int i = 2; i < n; i++){
        if(arr[i] == 0){
          flag = true;
        }
      
      }
      if(flag) System.out.println("NO");
      else if(num % 121L == 0) System.out.println("YES");
      else System.out.println("NO");
    }

    br.close();
  }
}