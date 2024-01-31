import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_Addition_to_Segment{

    public static class SegTree{
        int size;
        long[] sum;

        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            sum = new long[2 * size];
        }

        // long find(int idx, int x, int lx, int rx){
        //     if(rx - lx == 1){
        //         return sum[x];
        //     }

        //     int mid = (lx + rx) / 2;
        //     if(idx < mid) return find(idx, 2 * x + 1, lx, mid);
        //     else return find(idx, 2 * x + 2, mid, rx);

        // }

        // long find(int idx){
        //     return find(idx, 0, 0, size);
        // }

        // int find2(int idx, int x, int lx, int rx){
        //     if(rx - lx == 1){
        //         return x;
        //     }

        //     int mid = (lx + rx) / 2;
        //     if(idx < mid) return find2(idx, 2 * x + 1, lx, mid);
        //     else return find2(idx, 2 * x + 2, mid, rx);

        // }

        // int find2(int idx){
        //     return find2(idx, 0, 0, size);
        // }


        long sum(int l, int r, int x, int lx, int rx){
            if(lx >= r || rx <= l) return 0;
            else if(lx >= l && rx <= r) return sum[x];

            int mid = (lx + rx) / 2;
            long s1 = sum(l, r, 2 * x + 1, lx, mid);
            long s2 = sum(l, r, 2 * x + 2, mid, rx);

            return s1 + s2;
        }

        long sum(int l, int r){
            return sum(l, r, 0, 0, size);
        }

        void set(int i, long v, int x, int lx, int rx){
            if(i >= rx || i < lx) return;//VVI

            if(rx - lx == 1){
                sum[x] += v;
                return;
            }

            int mid = (lx + rx) / 2;
            if(i < mid) set(i, v, 2 * x + 1, lx, mid);
            else set(i, v, 2 * x + 2, mid, rx);

            sum[x] = sum[2 * x + 1] + sum[2 * x + 2];
        }

        void set(int i, long v){
            set(i, v, 0, 0, size);
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
            String input2[] = br.readLine().split(" ");
            int operation = Integer.parseInt(input2[0]);

            if(operation == 1){
                int l = Integer.parseInt(input2[1]);
                int r = Integer.parseInt(input2[2]);
                int v = Integer.parseInt(input2[3]);


                // int idx = st.find2(l);
                // int idx2 = st.find2(r);

                //debug
                // System.out.print(idx + " ");
                // System.out.println(idx2 + " ");

                // for(int i = idx; i < idx2; i++){
                //     st.sum[i] = st.sum[i] + (long)v;
                // }

                // for(int i = 7; i < 15; i++){//debug
                //     System.out.print(st.sum[i] + " ");
                // }
                // System.out.println();

                st.set(l, v);
                st.set(r,- v);

            }else{
                int i = Integer.parseInt(input2[1]);
                // System.out.println(st.find(i));
                System.out.println(st.sum(0, i + 1));
            }
        }
    }
}