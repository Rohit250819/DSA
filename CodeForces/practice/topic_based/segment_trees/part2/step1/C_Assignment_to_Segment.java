import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Assignment_to_Segment {

  static class SegTree{
    int size;
    int operations[];
    int NO_OPERATION = Integer.MAX_VALUE;

    void init(int n){
      size = 1;
      while(size < n) size *= 2;
      operations = new int[2 * size];
    }

    int assign(int a, int b){
      if(b == NO_OPERATION) return a;
      return b;
    }

    void propagate(int x, int lx, int rx){
      if(rx - lx == 1) return;
      operations[2 * x + 1] = assign(operations[2 * x + 1], operations[x]);
      operations[2 * x + 2] = assign(operations[2 * x + 2], operations[x]);
      operations[x] = NO_OPERATION;
    }

    void modify(int l, int r, int v, int x, int lx, int rx){
      propagate(x, lx, rx);
      if(lx >= r || rx <= l) return;
      else if(lx >= l && rx <= r){
        operations[x] = assign(operations[x], v);
        return;
      }

      int mid = (lx + rx) / 2;
      modify(l, r, v, 2 * x + 1, lx, mid);
      modify(l, r, v, 2 * x + 2, mid, rx);
    }

    void modify(int l, int r, int v){
      modify(l, r, v, 0, 0, size);
    }

    int get(int idx, int x, int lx, int rx){
      propagate(x, lx, rx);
      if(rx - lx == 1) return operations[x];

      int mid = (lx + rx) / 2;
      int res;

      if(idx < mid) res = get(idx, 2 * x + 1, lx, mid);
      else res = get(idx, 2 * x + 2, mid, rx);

      return res;

    }

    int get(int idx){
      return get(idx, 0, 0, size);
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
        st.modify(l, r, v);
      }else{
        int idx = Integer.parseInt(input2[1]);
        System.out.println(st.get(idx));
      }
    }


    br.close();
  }
}