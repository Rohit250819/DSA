import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C_inhabit_of_the_Deep_Sea {

  private static void reverse(long[] arr) {
    int n = arr.length;
    int start = 0, end = n - 1;

    while (start < end) {
      long temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  private static int lowerBound(long[] arr, long target) {
    // Arrays.sort(arr);
    int n = arr.length;
    int floor = -1, low = 0, high = n - 1;

    while(low <= high){
      int mid = low + (high - low)/2;

      if(arr[mid] == target){
        return mid;
      }else if(arr[mid] > target){
        high = mid - 1;
      }else{
        floor = mid;
        low = mid + 1;
      }
    }

    return floor;
  }

  private static void solve(int n, long k, List<Long> ships) {
    // base case
    long total = 0;

    for(long num : ships)
      total += num;
    
    if(k >= total){
      System.out.println(n);
      return;
    }
    long ans = 0;
    long rem = k / 2;
    if(k % 2 == 0){
      long pp = rem;

      for(int i = 0; i < n; i++){
        if(ships.get(i) <= pp){
          pp -= ships.get(i);
          ans++;
        }else{
          break;
        }
      }

      pp = rem;

      for(int i = n - 1; i >= 0; i--){
        if(ships.get(i) <= pp){
          pp -= ships.get(i);
          ans++;
        }else{
          break;
        }
      }

    }else{
      long pp = rem + 1;

      for(int i = 0; i < n; i++){
        if(ships.get(i) <= pp){
          pp -= ships.get(i);
          ans++;
        }else{
          break;
        }
      }

      pp = rem;

      for(int i = n - 1; i >= 0; i--){
        if(ships.get(i) <= pp){
          pp -= ships.get(i);
          ans++;
        }else{
          break;
        }
      }

    }

    System.out.println(ans);


  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCases = Integer.parseInt(br.readLine());

    while (testCases-- > 0) {
      String[] input1 = br.readLine().split(" ");
      String[] input2 = br.readLine().split(" ");

      int n = Integer.parseInt(input1[0]);
      long k = Long.parseLong(input1[1]);

      List<Long> ships = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        ships.add(Long.parseLong(input2[i]));
      }

      solve(n, k, ships);
    }

    br.close();
  }
}