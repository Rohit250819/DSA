import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D_Children_Holiday{

  static class Helper{
    long t, z, y;

    public Helper(long t, long z, long y){
      this.t = t;
      this.z = z;
      this.y = y;
    }
  }

  private static long blown(Helper x, long time){
    long result = 0;

    result += x.z * (time/(x.z * x.t + x.y));
    long rem = time % (x.z * x.t + x.y);
    if(rem >= x.z * x.t) result += x.z;
    else result += rem / x.t;

    return result;
  }

  private static boolean good(long time, List<Helper> h, long m){
    long result = 0;

    for(Helper i : h){
      result += blown(i, time);
    }

    return result >= m;
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long m = Long.parseLong(st.nextToken());
    long n = Long.parseLong(st.nextToken());

    List<Helper> h = new ArrayList<>();
    for(long i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      long t = Long.parseLong(st.nextToken());
      long z = Long.parseLong(st.nextToken());
      long y = Long.parseLong(st.nextToken());
      h.add(new Helper(t, z, y));
    }

    long l = -1;
    long r = (long)(2e9 + 1);

    while(r > l + 1){
      long mid = l + (r - l)/2;
      if(good(mid, h, m))
        r = mid;
      else
        l = mid;
    }

    System.out.println(r);

    for(int i = 0; i < n; i++){
      if(i > 0) System.out.print(" ");

      long x = blown(h.get(i), r);
      System.out.print(Math.min(m, x));
      m -= Math.min(m, x);
    }

    br.close();
  }
}