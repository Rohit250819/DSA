import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_Assignment_and_Minimum{

  static class SegTree{
    int size;
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

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