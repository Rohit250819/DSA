import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class C_Nested_Segments{

    static class SegTree{
        int size;
        long[] sum;

        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            sum = new long[2 * size];
        }


        long sum(int l, int r, int x, int lx, int rx){
            if(lx >= r || rx <= l) return 0;
            if(lx >= l && rx <= r) return sum[x];

            int m = (lx + rx) / 2;
            long s1 = sum(l, r, 2 * x + 1, lx, m);
            long s2 = sum(l, r, 2 * x + 2, m, rx);

            return s1 + s2;
        }

        long sum(int l, int r){
            return sum(l, r, 0, 0, size);
        }

        // void build(int[] arr, int x, int lx, int rx){
        //     if(rx - lx == 1){
        //         if(lx < arr.length) sum[x] = arr[lx];
        //         return;
        //     }

        //     int m = (lx + rx) / 2;
        //     build(arr, 2 * x + 1, lx, m);
        //     build(arr, 2 * x + 2, m, rx);

        //     sum[x] = sum[2 * x + 1] + sum[2 * x + 2];
        // }

        // void build(int[] arr){
        //     build(arr, 0, 0, size);
        // }

        void set(int i, int v, int x, int lx, int rx){
            if(rx - lx == 1){
                sum[x] = v;
                return;
            }

            int m = (lx + rx) / 2;
            if(i < m) set(i, v, 2 * x  + 1, lx, m);
            else set(i, v, 2 * x + 2, m, rx);

            sum[x] = sum[2 * x + 1] + sum[2 * x + 2];
        }

        void set(int i, int v){
            set(i, v, 0, 0, size);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[2*n];
        for(int i = 0; i < 2 * n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        // for(int e: arr)//debug
        //     System.out.print(e + " ");

        int[][] interval = new int[n][3];
        for(int a[] : interval)
            Arrays.fill(a, -1);

        for(int i = 0; i < arr.length; i++){
            interval[arr[i] - 1][2] = arr[i] - 1;
            if(interval[arr[i] - 1][0] == -1) interval[arr[i] - 1][0] = i;
            else interval[arr[i] - 1][1] = i;
        }

        Arrays.sort(interval, Comparator.comparingInt(a -> a[1]));

        // for(int[] a: interval)//debug
        //     System.out.println(a[0] + " " + a[1] + " " + a[2]);

        SegTree st = new SegTree();
        st.init(2 * n);
        long[] ans = new long[n];

        for(int i = 0; i < n; i++){
            int idx = interval[i][2] ;
            int l = interval[i][0] ;
            int r = interval[i][1];

            ans[idx] = st.sum(l, r);
            st.set(l, 1);
        }

        for(long e : ans)
            System.out.print(e + " ");

        br.close();
    }
}