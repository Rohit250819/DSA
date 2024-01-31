import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Cryptography{
    static int r;
    static class Matrix{
        int a, b, c, d;

        Matrix(int a, int b, int c, int d){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    static class SegTree{
        int size;
        Matrix[] tree;

        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            tree = new Matrix[2 * size];

            for(int i = 0; i < 2 * size; i++){
                tree[i] = new Matrix(1, 0, 0, 1);
            }
        }

        Matrix combine(Matrix a, Matrix b){
            return new Matrix(
                (a.a * b.a + a.b * b.c) % r,
                (a.a * b.b + a.b * b.d) % r,
                (a.c * b.a + a.d * b.c) % r,
                (a.c * b.b + a.d * b.d) % r
            );
        }


        void build(Matrix[] a, int x, int lx , int rx){
            if(rx - lx == 1){
                if(lx < a.length)
                    tree[x] = a[lx];
                return;
            }

            int mid = (lx + rx) / 2;
            build(a, 2 * x + 1, lx, mid);
            build(a, 2 * x + 2, mid, rx);

            tree[x] = combine(tree[2 * x + 1], tree[2 * x + 2]);
        }

        void build(Matrix[] a){
            build(a, 0, 0, size);
        }

        Matrix calc(int L, int R, int x, int lx, int rx){
            if(lx >= R || rx <= L) return new Matrix(1, 0, 0, 1);
            if(lx >= L && rx <= R) return tree[x];

            int mid = (lx + rx) / 2;
            Matrix a = calc(L, R, 2 * x + 1, lx, mid);
            Matrix b = calc(L, R, 2 * x + 2, mid, rx);

            return combine(a, b);
        }

        Matrix calc(int L, int R){
            return calc(L, R, 0, 0, size);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

        Matrix[] arr = new Matrix[n];
        for(int i = 0; i < n; i++){
            String[] input2 = br.readLine().split(" ");
            String[] input3 = br.readLine().split(" ");
            br.readLine();
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input3[0]);
            int d = Integer.parseInt(input3[1]);
            arr[i] = new Matrix(a, b, c, d);
        }

        SegTree st = new SegTree();
        st.init(n);
        st.build(arr);

        while(m-- > 0){
            String[] input4 = br.readLine().split(" ");
            int L = Integer.parseInt(input4[0]);
            int R = Integer.parseInt(input4[1]);
            L--;
            Matrix result = st.calc(L, R);
            System.out.printf("%d %d\n%d %d\n", result.a, result.b, result.c, result.d);
            if (m > 0) System.out.println();

        }

        br.close();
    }
}