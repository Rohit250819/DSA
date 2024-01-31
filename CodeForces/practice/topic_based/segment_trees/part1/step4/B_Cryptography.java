import java.util.Scanner;

class B_Cryptography {
    static class Matrix {
        int a, b, c, d;

        public Matrix(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    static class SegTree {
        int size;
        Matrix[] tree;

        Matrix combine(Matrix a, Matrix b) {
            return new Matrix(
                (int) ((1L * a.a * b.a + 1L * a.b * b.c) % r),
                (int) ((1L * a.a * b.b + 1L * a.b * b.d) % r),
                (int) ((1L * a.c * b.a + 1L * a.d * b.c) % r),
                (int) ((1L * a.c * b.b + 1L * a.d * b.d) % r)
            );
        }

        void build(Matrix[] a) {
            size = 1;
            while (size < a.length) size *= 2;
            tree = new Matrix[2 * size];
            for (int i = 0; i < 2 * size; i++) {
                tree[i] = new Matrix(1, 0, 0, 1);
            }
            build(a, 0, 0, size);
        }

        void build(Matrix[] a, int x, int lx, int rx) {
            if (rx == lx + 1) {
                if (lx < a.length) {
                    tree[x] = a[lx];
                }
            } else {
                int m = (lx + rx) / 2;
                build(a, 2 * x + 1, lx, m);
                build(a, 2 * x + 2, m, rx);
                tree[x] = combine(tree[2 * x + 1], tree[2 * x + 2]);
            }
        }

        Matrix calc(int L, int R) {
            return calc(L, R, 0, 0, size);
        }

        Matrix calc(int L, int R, int x, int lx, int rx) {
            if (lx >= R) return new Matrix(1, 0, 0, 1);
            if (rx <= L) return new Matrix(1, 0, 0, 1);
            if (lx >= L && rx <= R) return tree[x];
            int m = (lx + rx) / 2;
            return combine(calc(L, R, 2 * x + 1, lx, m), calc(L, R, 2 * x + 2, m, rx));
        }
    }

    static int r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            r = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            Matrix[] a = new Matrix[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Matrix(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            }

            SegTree st = new SegTree();
            st.build(a);

            int L, R;
            while (m-- > 0) {
                L = sc.nextInt();
                R = sc.nextInt();
                --L;
                Matrix result = st.calc(L, R);
                System.out.printf("%d %d\n%d %d\n", result.a, result.b, result.c, result.d);
                if (m > 0) System.out.println();
            }
        }

        sc.close();
    }
}
