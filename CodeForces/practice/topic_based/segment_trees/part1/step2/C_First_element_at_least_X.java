import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_First_element_at_least_X{

    static class SegTree{
        int size;
        int[] max;

        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            max = new int[2 *size];
        }

        //by me
        // int find(int k, int x, int lx, int rx){
        //     if(rx - lx == 1){
        //         return lx;
        //     }

        //     int m = (lx + rx) / 2;
        //     if(k <= max[2 * x + 1]){
        //         return find(k, 2 * x + 1, lx, m);
        //     }else{
        //         return find(k, 2 * x + 2, m, rx);
        //     }
        // }

        // by codeforces official
        int find(int k, int x, int lx, int rx){
            if(max[x] < k) return -1;
            if(rx - lx == 1) return lx;
            int m = (lx + rx) / 2;
            int res = find(k, 2 * x + 1, lx, m);
            if(res == -1)
                res = find(k, 2 * x + 2, m, rx);

            return res;
        }


        int find(int k){
            return find(k, 0, 0, size);
        }

        void build(int[] arr, int x, int lx, int rx){
            if(rx - lx == 1){
                if(lx < arr.length)
                    max[x] = arr[lx];
                return;
            }

            int m = (lx + rx) / 2;
            build(arr, 2 * x + 1, lx, m);
            build(arr, 2 * x + 2, m, rx);

            max[x] = Math.max(max[2 * x + 1], max[2 * x + 2]);
        }

        void build(int[] arr){
            build(arr, 0, 0, size);
        }

        void set(int idx, int val, int x, int lx, int rx){
            if(rx - lx == 1){
                max[x] = val;
                return;
            }

            int m = (lx + rx) / 2;
            if(idx < m) set(idx, val, 2 * x + 1, lx, m);
            else set(idx, val, 2 * x + 2, m, rx);

            max[x] = Math.max(max[2 * x + 1] , max[2 * x + 2]);
        }

        void set(int idx, int val){
            set(idx, val, 0, 0, size);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input2[i]);
        }

        SegTree sg = new SegTree();
        sg.init(n);

        sg.build(arr);

        while(m-- > 0){
            String[] input3 = br.readLine().split(" ");
            int type = Integer.parseInt(input3[0]);
            if(type == 1){
                int idx = Integer.parseInt(input3[1]);
                int val = Integer.parseInt(input3[2]);
                sg.set(idx, val);
            }else{
                int x = Integer.parseInt(input3[1]);
                int ans = sg.find(x);
                if(ans > arr.length) System.out.println(-1);
                else System.out.println(ans);
            }
        }
    }
}