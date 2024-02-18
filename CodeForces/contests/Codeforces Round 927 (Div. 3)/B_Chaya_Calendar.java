import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_Chaya_Calendar{

  private static void solve(int n, int[] arr){
    ArrayList<Integer> list = new ArrayList<>();
    list.add(arr[0]);

    for(int i = 1; i < n; i++){
      int temp = arr[i];
      if(temp > list.get(list.size() - 1)){
        list.add(temp);
      }else{
        while(temp <= list.get(list.size() - 1)){
          temp += arr[i];
        }

        list.add(temp);
      }
    }

    System.out.println(list.get(list.size() - 1));
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