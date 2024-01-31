import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Sign_alternation {

    static class SegTree {
        int size;
        long[] sum;

        void init(int n) {
            size = 1;
            while (size < n)
                size *= 2;
            sum = new long[2 * size];
        }

        long sum(int l, int r, int x, int lx, int rx) {
            if (lx >= r || rx <= l)
                return 0L;
            if (lx >= l && rx <= r)
                return sum[x];

            int mid = (lx + rx) / 2;
            long s1 = sum(l, r, 2 * x + 1, lx, mid);
            long s2 = sum(l, r, 2 * x + 2, mid, rx);

            return s1 + s2;
        }

        long sum(int l, int r) {
            return sum(l, r, 0, 0, size);
        }

        void set(int idx, int v, int x, int lx, int rx) {
            if (rx - lx == 1) {
                sum[x] = v;
                return;
            }

            int mid = (lx + rx) / 2;
            if (idx < mid)
                set(idx, v, 2 * x + 1, lx, mid);
            else
                set(idx, v, 2 * x + 2, mid, rx);

            sum[x] = sum[2 * x + 1] + sum[2 * x + 2];
        }

        void set(int idx, int v) {
            set(idx, v, 0, 0, size);
        }

        void build(int[] arr, int x, int lx, int rx) {
            if (rx - lx == 1) {
                if (lx < arr.length) {
                    if (lx % 2 == 1)
                        sum[x] = -arr[lx];
                    else
                        sum[x] = arr[lx];
                }
                return;
            }

            int mid = (lx + rx) / 2;
            build(arr, 2 * x + 1, lx, mid);
            build(arr, 2 * x + 2, mid, rx);

            sum[x] = sum[2 * x + 1] + sum[2 * x + 2];
        }

        void build(int[] arr) {
            build(arr, 0, 0, size);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        SegTree st = new SegTree();
        st.init(n);
        st.build(arr);

        int m = Integer.parseInt(br.readLine());

        // for(int i = 0; i < st.sum.length; i++){//debug
        // System.out.print(st.sum[i] + " ");
        // }
        // System.out.println();

        while (m-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int type = Integer.parseInt(input2[0]);

            if (type == 0) {
                int idx = Integer.parseInt(input2[1]) - 1;
                int val = Integer.parseInt(input2[2]);
                if (idx % 2 == 0) {
                    st.set(idx, val);
                } else {
                    st.set(idx, -val);
                }
            } else {
                int l = Integer.parseInt(input2[1]) - 1;
                int r = Integer.parseInt(input2[2]);

                long sum = st.sum(l, r);
                if (l % 2 == 0)
                    System.out.println(sum);
                else
                    System.out.println(-sum);
            }
        }

        br.close();
    }
}