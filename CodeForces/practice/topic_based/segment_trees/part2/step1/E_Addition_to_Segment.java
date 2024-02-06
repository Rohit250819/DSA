import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_Addition_to_Segment{
  public static class Segtree{
    int size;
    long[] operations;

    void init(int n){
      size = 1;

      while(size < n)
        size *= 2;

      operations = new long[2 * size];
    }

    void add(int l, int r, int v, int x, int lx, int rx){
      if(lx >= r || rx <= l) return;
      else if(lx >= l && rx <= r){
        operations[x] += v;
        return;
      }

      int mid = (lx + rx) / 2;
      add(l, r, v, 2 * x + 1, lx, mid);
      add(l, r, v, 2 * x + 2, mid, rx);
    }

    void add (int l, int r, int v){
      add(l, r, v, 0, 0, size);
    }

    long get(int idx, int x, int lx, int rx){
      if(rx - lx == 1) return operations[x];

      int mid = (lx + rx) / 2;
      long res = 0;
      if(idx < mid) res = get(idx, 2 * x + 1, lx, mid);
      else res = get(idx, 2 * x + 2, mid, rx);

      return res + operations[x];
    }

    long get(int idx){
      return get(idx, 0, 0, size);
    }
  }
// solved using mass operation method
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    //initilizing segment tree
    Segtree st = new Segtree();
    st.init(n);

    while(m-- > 0){
      String[] input2 = br.readLine().split(" ");
      int type = Integer.parseInt(input2[0]);

      if(type == 1){
        int l = Integer.parseInt(input2[1]);
        int r = Integer.parseInt(input2[2]);
        int val = Integer.parseInt(input2[3]);
        st.add(l, r, val);
      }else{
        int i = Integer.parseInt(input2[1]);
        System.out.println(st.get(i));
      }

    }

    br.close();
  }
}