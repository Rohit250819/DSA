import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Addition_and_Minimum{

  static class SegTree{
    int size;
    long[] operations;
    long[] mins;

    void init(int n){
      size = 1;
      while(size < n) size *= 2;
      operations = new long[2 * size];
      mins = new long[2 * size];
    }

    void add(int l, int r, int v, int x, int lx, int rx){
      if(lx >= r || rx <= l) return;
      else if(lx >= l && rx <= r){
        operations[x] += v;
        mins[x] += v;
        return;
      }

      int mid = (lx + rx) / 2;
      add(l, r, v, 2 * x + 1, lx, mid);
      add(l, r, v, 2 * x + 2, mid, rx);
      mins[x] = Math.min(mins[2 * x + 1], mins[2 * x + 2]) + operations[x];
    }

    void add(int l, int r, int v){
      add(l, r, v, 0, 0, size);
    }

    long min(int l, int r, int x, int lx, int rx){
      if(lx >= r || rx <= l) return Long.MAX_VALUE;
      else if(lx >= l && rx <= r) return mins[x];

      int mid = (lx + rx) / 2;
      long m1 = min(l, r, 2 * x + 1, lx, mid);
      long m2 = min(l, r, 2 * x + 2, mid, rx);

      return Math.min(m1, m2) + operations[x];
    }

    long min(int l, int r){
      return min(l, r, 0, 0, size);
    }
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    SegTree st = new SegTree();
    st.init(n);

    while(m-- > 0){
      String[] input2 = br.readLine().split(" ");
      int type = Integer.parseInt(input2[0]);

      if(type == 1){
        int l = Integer.parseInt(input2[1]);
        int r = Integer.parseInt(input2[2]);
        int v = Integer.parseInt(input2[3]);

        st.add(l, r, v);
      }else{
        int l = Integer.parseInt(input2[1]);
        int r = Integer.parseInt(input2[2]);

        System.out.println(st.min(l, r));
      }

    }

    br.close();
  }
}