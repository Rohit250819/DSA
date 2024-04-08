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
    // calculating prefix
    long[] pref = new long[n];
    pref[0] = ships.get(0);

    for (int i = 1; i < n; i++) {
      pref[i] = pref[i - 1] + ships.get(i);
    }

    // calculating suffix
    long[] suff = new long[n];
    suff[n - 1] = ships.get(n - 1);

    for (int i = n - 2; i >= 0; i--) {
      suff[i] = suff[i + 1] + ships.get(i);
    }

    reverse(suff);

    int lb1 = lowerBound(pref, (k + 1)/2);
    int lb2 = lowerBound(suff, k/2);

    reverse(suff);

    lb2 = n - lb2 - 1;

    if(lb1 > lb2){
      System.out.println(n);
    }else if(lb1 < lb2){
      int ans = 0;

      if(lb1 > 0 && pref[lb1] > (k + 1)/2) ans += lb1;
      else ans += (lb1 + 1);

      if(lb2 < n && suff[lb2] > k/2) ans += (n - lb2 - 1);
      else ans += (n - lb2);

      System.out.println(ans);
    }else{
      long total = 0;
      for(long num : ships){
        total += num;
      }

      if(total > k) System.out.println(n - 1);
      else System.out.println(n);
    }


  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testCases = Integer.parseInt(br.readLine());

    while (testCases-- > 0) {
      String[] input1 = br.readLine().split(" ");
      String[] input2 = br.readLine().split(" ");

      int n = Integer.parseInt(input1[0]);
      long k = Integer.parseInt(input1[1]);

      List<Long> ships = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        ships.add(Long.parseLong(input2[i]));
      }

      solve(n, k, ships);
    }

    br.close();
  }
}