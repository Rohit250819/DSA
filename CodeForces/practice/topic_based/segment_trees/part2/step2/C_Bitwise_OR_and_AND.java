import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Bitwise_OR_and_AND{

  static class SegTree{
    int size;
    int[] operations;
    int[] values;
    int NEUTRAL_ELEMENT = -1;

    int or_op(int a, int b){
      return a | b;
    }

    int and_op(int a, int b){
      return a & b;
    }

    void init(int n){
      size = 1;
      while(size < n) size *= 2;
      operations = new int[2 * size];
      values = new int[2 * size];
    }

    void modify(int l, int r, int v, int x, int lx, int rx){
      if(lx >= r || rx <= l) return;
      else if(lx >= l && rx <= r){
        operations[x] = or_op(operations[x], v);
        values[x] = or_op(values[x], v);
        return;
      }

      int mid = (lx + rx) / 2;
      modify(l, r, v, 2 * x + 1, lx, mid);
      modify(l , r, v, 2 * x + 2, mid, rx);
      values[x] = and_op(values[2 * x + 1], values[2 * x + 2]);
      values[x] = or_op(values[x], operations[x]);
    }

    void modify(int l, int r, int v){
      modify(l, r, v, 0, 0, size);
    }

    int calc(int l, int r, int x, int lx, int rx){
      if(lx >= r || rx <= l) return NEUTRAL_ELEMENT;
      else if(lx >= l && rx <= r){
        return values[x];
      }

      int mid = (lx + rx) / 2;
      int m1 = calc(l, r, 2 * x + 1, lx, mid);
      int m2 = calc(l, r, 2 * x + 2, mid, rx);
      int res = and_op(m1, m2);
      res = or_op(res, operations[x]);
      return res;
    }

    int calc(int l, int r){
      return calc(l, r, 0, 0, size);
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
      String[] input1 = br.readLine().split(" ");
      int type = Integer.parseInt(input1[0]);
      if(type == 1){
        int l = Integer.parseInt(input1[1]);
        int r = Integer.parseInt(input1[2]);
        int v = Integer.parseInt(input1[3]);

        st.modify(l, r, v);
      }else{
        int l = Integer.parseInt(input1[1]);
        int r = Integer.parseInt(input1[2]);
        System.out.println(st.calc(l, r));
      }
    }

    br.close();
  }
}