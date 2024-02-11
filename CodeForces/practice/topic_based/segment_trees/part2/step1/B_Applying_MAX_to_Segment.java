import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Applying_MAX_to_Segment{

  static class SegTree{
    int size;
    int[] max;

    void init(int n){
      size = 1;
      while(size < n) size *= 2;
      max = new int[2 * size];
    }

    int get(int idx, int x, int lx, int rx){
      if(rx - lx == 1) return max[x];

      int mid = (lx + rx) / 2;
      int res = 0;
      if(idx < mid) res = get(idx, 2 * x + 1, lx, mid);
      else res = get(idx, 2 * x + 2, mid, rx);

      return Math.max(res, max[x]);
    }

    int get(int idx){
      return get(idx, 0, 0, size);
    }

    void add(int l, int r, int v, int x, int lx, int rx){
      if(lx >= r || rx <= l) return ;
      else if(lx >= l && rx <= r){
        max[x] = Math.max(max[x], v);
        return;
      }

      int mid = (lx + rx) / 2;
      add(l, r, v, 2 * x + 1, lx, mid);
      add(l, r, v, 2 * x + 2, mid, rx);
    }

    void add(int l, int r, int v){
      add(l, r, v, 0, 0, size);
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
        int idx = Integer.parseInt(input2[1]);
        System.out.println(st.get(idx));
      }
    }

    br.close();
  }
}