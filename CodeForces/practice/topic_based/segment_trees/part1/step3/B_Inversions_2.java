import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_Inversions_2{

    static class SegTree{
        int size;
        int[] sum;

        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            sum = new int[2 * size];
        }

        int find(int k, int x, int lx, int rx){
            if(rx - lx == 1) return lx;

            int m = (lx + rx) / 2;
            int sl = sum[2 * x + 2];
            if(k < sl) return find(k , 2 * x + 2, m, rx);
            else return find(k - sl, 2 * x + 1, lx, m);
        }

        int find(int k){
            return find(k, 0, 0, size);
        }

        void build(int[] arr, int x, int lx, int rx){
            if(rx - lx == 1){
                if(lx < arr.length) sum[x] = arr[lx];
                return;
            }

            int m = (lx + rx) / 2;
            build(arr, 2 * x + 1, lx, m);
            build(arr, 2 * x + 2, m, rx);

            sum[x] = sum[2 * x + 1] + sum[2 * x + 2];
        }

        void build(int[] arr){
            build(arr, 0, 0, size);
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
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] kth = new int[n];
        for(int i = 0; i < n; i++){
            kth[i] = Integer.parseInt(input[i]);
        }
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        
        SegTree st = new SegTree();
        st.init(n);
        st.build(arr);
        int[] ans = new int[n];


        // for(int s : st.sum)//for debug
        //     System.out.print(s + " ");

        System.out.println();

        for(int i = n - 1; i >= 0; i--){
            int idx = st.find(kth[i]);
            st.set(idx, 0);
            ans[i] = idx + 1;
        }

        for(int e : ans)
            System.out.print(e + " ");

        br.close();

    }
}