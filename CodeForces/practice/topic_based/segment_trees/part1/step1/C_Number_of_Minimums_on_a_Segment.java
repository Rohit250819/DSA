import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C_Number_of_Minimums_on_a_Segment{

    static class Pair{
        int val, freq;

        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }

    static class SegTree{
        int size;
        Pair[] values;
        
        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            values = new Pair[2 * size];
        }

        Pair merge(Pair a, Pair b){
            if(a == null && b == null) return new Pair((int)1e9, 0);
            else if(a == null) return b;
            else if(b == null) return a;
            else if(a.val > b.val) return b;
            else if(a.val < b.val) return a;
            else return new Pair(a.val, a.freq + b.freq);
        }

        void set(int i, int v, int x, int lx, int rx){
            if(rx - lx == 1){
                values[x] = new Pair(v, 1);
                return;
            }

            int m = (lx + rx)/2;
            if(i < m){
                set(i, v, 2*x + 1, lx, m);
            }else{
                set(i, v, 2*x + 2, m, rx);
            }

            values[x] = merge(values[2*x + 1] , values[2*x + 2]);
        }

        void set(int i, int v){
            set(i, v, 0, 0, size);
        }

        void build(int[] arr, int x, int lx, int rx){
            if(rx - lx == 1){
                if(lx < arr.length){
                    values[x] = new Pair(arr[lx], 1);
                }
                return;
            }

            int m = (lx + rx)/2;
            build(arr, 2*x + 1, lx, m);
            build(arr, 2*x + 2, m, rx);

            values[x] =merge(values[2*x+ 1] , values[2*x + 2]);
        }

        void build(int[] arr){
            build(arr, 0, 0, size);
        }

        Pair min(int l, int r, int x, int lx, int rx){
            if(lx >= r || rx <= l) return new Pair((int)(1e9), 0);
            if(lx >= l && rx <= r) return values[x];

            int m = (lx + rx)/2;
            Pair a = min(l, r, 2*x + 1, lx, m);
            Pair b = min(l, r, 2*x + 2, m, rx);

            return merge(a, b);
        }

        Pair min(int l, int r){
            return min(l, r, 0, 0, size);
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
        Arrays.fill(arr, Integer.MAX_VALUE);
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
                Pair p = st.min(a, b);
                System.out.println(p.val + " " + p.freq);
            }
        }
    }
}