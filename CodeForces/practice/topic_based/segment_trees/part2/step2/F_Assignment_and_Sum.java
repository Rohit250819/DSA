import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F_Assignment_and_Sum{

  static class SegTree{
    int size;
    long[] operations;
    long[] values;
    long NEUTRAL_ELEMENT = 0;
    long NO_OPERATION = Long.MAX_VALUE - 1;

    void init(int n){
      size = 1;
      while(size < n) size *= 2;
      operations = new long[2 * size];
      values = new long[2 * size];
    }

    long modify_op(long a, long b, int len){
      if(b == NO_OPERATION) return a;
      return b*len ;
    }

    long calc_op(long a, long b){
      return a + b;
    }

    void propagate(int x, int lx, int rx){
      if(rx - lx == 1) return;
      int mid = (lx + rx) / 2;
      operations[2 * x + 1] = modify_op(operations[2 * x + 1], operations[x], 1);
      values[2 * x + 1] = modify_op(values[2 * x + 1], operations[x], mid - lx);
      operations[2 * x + 2] = modify_op(operations[2 * x + 2], operations[x], 1);
      values[2 * x + 2] = modify_op(values[2 * x + 2], operations[x], rx - mid);

      operations[x] = NO_OPERATION;
    }

    void modify(int l, int r, int v, int x, int lx, int rx){
      propagate(x, lx, rx);
      if(lx >= r || rx <= l) return;
      else if(lx >= l && rx <= r){
        operations[x] = modify_op(operations[x], v, 1);
        values[x] = modify_op(values[x], v, rx - lx);
        return;
      }

      int mid = (lx + rx) / 2;
      modify(l, r, v, 2 * x + 1, lx, mid);
      modify(l, r, v, 2 * x + 2, mid, rx);
      values[x] = calc_op(values[2 * x + 1], values[2 * x + 2]);
    }

    void modify(int l, int r, int v){
      modify(l, r, v, 0, 0, size);
    }

    long calc(int l, int r, int x, int lx, int rx){
      propagate(x, lx, rx);
      if(lx >= r || rx <= l) return NEUTRAL_ELEMENT;
      else if(lx >= l && rx <= r) return values[x];

      int mid = (lx + rx) / 2;
      long m1 = calc(l, r, 2 * x + 1, lx, mid);
      long m2 = calc(l, r, 2 * x + 2, mid, rx);
      long res = calc_op(m1, m2);
      return res;
    }

    long calc(int l, int r){
      return calc(l, r, 0, 0, size);
    }
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input1 = br.readLine().split(" ");
    int n = Integer.parseInt(input1[0]);
    int m = Integer.parseInt(input1[1]);

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
        int l = Integer.parseInt(input2[1]);
        int r = Integer.parseInt(input2[2]);

        System.out.println(st.calc(l, r));
      }
    }

    br.close();
  }
}