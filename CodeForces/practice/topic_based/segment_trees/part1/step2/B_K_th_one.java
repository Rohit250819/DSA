import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_K_th_one{


    static class SegTree{
        int size;
        int[] sums;

        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            sums = new int[2 * size];
        }

        int find(int k, int x, int lx, int rx){
            if(rx - lx == 1){
                return lx;
            }

            int m = (lx + rx)/2;
            int sl = sums[2*x + 1];
            if(k < sl) return find(k, 2*x + 1, lx, m);
            else return find(k - sl, 2*x + 2, m, rx);

        }

        int find(int k){
            return find(k, 0, 0, size);
        }

        void build(int[] arr, int x, int lx, int rx){
            if(rx - lx == 1){
                if(lx < arr.length)
                    sums[x] = arr[lx];
                return;
            }

            int m = (lx + rx) / 2;
            build(arr, 2*x + 1, lx, m);
            build(arr, 2*x + 2, m, rx);

            sums[x] = sums[2*x + 1] + sums[2*x + 2];
        }

        void build(int[] arr){
            build(arr, 0, 0, size);
        }

        void set(int i, int v, int x, int lx, int rx){
            if(rx - lx == 1){
                sums[x] = v;
                return;
            }

            int m = (lx + rx) /2;

            if(i < m) set(i, v, 2*x + 1, lx, m);
            else set(i, v, 2*x + 2, m, rx);

            sums[x] = sums[2*x+ 1] + sums[2*x + 2];
        }

        void set(int i , int v){
            set(i, v, 0, 0, size);
        }
        
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input2[i]);
        }

        SegTree st = new SegTree();
        st.init(n);
        st.build(arr);

        while(m-- > 0){
            String[] input3 = br.readLine().split(" ");
            int type = Integer.parseInt(input3[0]);
            
            if(type == 1){
                int idx = Integer.parseInt(input3[1]);
                // st.set(idx, 1 -arr[idx]);//giving error with this
                arr[idx] = 1- arr[idx];
                st.set(idx, arr[idx]);
            }else{
                int k = Integer.parseInt(input3[1]);
                System.out.println(st.find(k));
            }
        }
    }
}