import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Inversions{


    static class SegTree{
        int size;
        int[] sum;

        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            sum = new int[2*size];
        }
        

        void set(int i, int v, int x, int lx, int rx){
            if(rx - lx == 1){
                sum[x] = v;
                return;
            }

            int m = (lx + rx) / 2;
            if(i < m) set(i, v, 2 * x + 1, lx, m);
            else set(i, v, 2 * x + 2, m, rx);

            sum[x] = sum[2 * x + 1] + sum[2 * x + 2];
        }

        void set(int i, int v){
            set(i, v, 0, 0, size);
        }

        int calcSum(int l, int x, int lx, int rx){
            if(rx <= l) return 0;
            if(lx >= l) return sum[x];

            int m = (lx + rx) / 2;
            int s1 = calcSum(l, 2 * x + 1, lx, m);
            int s2 = calcSum(l, 2 * x + 2, m, rx);

            return s1 + s2;
        }

        int calcSum(int l){
            return calcSum(l, 0, 0, size);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        SegTree st = new SegTree();
        st.init(n);

        for(int i = 0; i < input.length; i++){
            int val = Integer.parseInt(input[i]);
            int idx = val - 1;
            st.set(idx, 1);
            System.out.print(st.calcSum(idx + 1) + " ");
        }
    }
}