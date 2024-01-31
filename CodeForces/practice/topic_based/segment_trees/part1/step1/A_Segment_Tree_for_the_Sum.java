import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Segment_Tree_for_the_Sum{

    static class SegTree{
        int size;
        long[] sums;
        
        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            sums = new long[2 * size];
        }

        void set(int i, int v, int x, int lx, int rx){
            if(rx - lx == 1){
                sums[x] = v;
                return;
            }

            int m = (lx + rx)/2;
            if(i < m){
                set(i, v, 2*x + 1, lx, m);
            }else{
                set(i, v, 2*x + 2, m, rx);
            }

            sums[x] = sums[2*x + 1] + sums[2*x + 2];
        }

        void set(int i, int v){
            set(i, v, 0, 0, size);
        }

        void build(int[] arr, int x, int lx, int rx){
            if(rx - lx == 1){
                if(lx < arr.length){
                    sums[x] = arr[lx];
                }
                return;
            }

            int m = (lx + rx)/2;
            build(arr, 2*x + 1, lx, m);
            build(arr, 2*x + 2, m, rx);

            sums[x] = sums[2*x+ 1] + sums[2*x + 2];
        }

        void build(int[] arr){
            build(arr, 0, 0, size);
        }

        long sum(int l, int r, int x, int lx, int rx){
            if(lx >= r || rx <= l) return 0L;
            if(lx >= l && rx <= r) return sums[x];

            int m = (lx + rx)/2;
            long s1 = sum(l, r, 2*x + 1, lx, m);
            long s2 = sum(l, r, 2*x + 2, m, rx);

            return s1 + s2;
        }

        long sum(int l, int r){
            return sum(l, r, 0, 0, size);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        SegTree st = new SegTree();
        st.init(n);

        String[] input2 = br.readLine().split(" ");

        // for(int i = 0; i < n; i++){
        //     st.set(i, Integer.parseInt(input2[i]));
        // }
        //optimizing
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input2[i]);
        }

        st.build(arr);

        while(m-- > 0){
            String[] input3 = br.readLine().split(" ");
            int type = Integer.parseInt(input3[0]);
            int a = Integer.parseInt(input3[1]);
            int b = Integer.parseInt(input3[2]);

            if(type == 1){
                st.set(a, b);
            }else{
                System.out.println(st.sum(a, b));
            }
        }
        br.close();
    }
}