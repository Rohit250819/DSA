import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Segment_with_the_Maximum_Sum{

    static class Pair{
        long seg, pref, suff, sum;

        Pair(long seg, long pref, long suff, long sum){
            this.seg = seg;
            this.pref = pref;
            this.suff = suff;
            this.sum = sum;
        }
    }

    static class SegTree{
        int size;
        Pair[] values;
        Pair NEUTRAL_ELEMENT = new Pair(0, 0, 0, 0);
        
        void init(int n){
            size = 1;
            while(size < n) size *= 2;
            values = new Pair[2 * size];
        }

        Pair single(int a){
            if(a > 0){
                return new Pair(a, a, a, a);
            }else{
                return new Pair(0, 0, 0, a);
            }
        }

        Pair merge(Pair a, Pair b){
            if(a == null && b == null) return NEUTRAL_ELEMENT;
            if(a == null) return b;
            if(b == null) return a;
            return new Pair(Math.max(a.seg, Math.max(b.seg, a.suff + b.pref)),//maximum sum of segment
                            Math.max(a.pref, a.sum + b.pref),//maximum pref
                            Math.max(b.suff, b.sum + a.suff),//maximum suff
                            a.sum + b.sum//sum of segments
            );
        }

        Pair calc(int l, int r, int x, int lx, int rx){
            if(lx >= r || rx <= l) return NEUTRAL_ELEMENT;
            if(lx >= l && rx <= r) return values[x];

            int m = (lx + rx)/2;
            Pair p1 = calc(l, r, 2 * x + 1, lx, m);
            Pair p2 = calc(l, r, 2 * x + 2, m, rx);

            return merge(p1, p2);

        }

        Pair calc(int l, int r){
            return calc(l, r, 0, 0, size);
        }

        void build(int[] arr, int x, int lx, int rx){
            if(rx - lx == 1){
                if(lx < arr.length){
                    values[x] = single(arr[lx]);
                }
                return;
            }

            int m = (lx + rx)/2;
            build(arr, 2 * x + 1, lx, m);
            build(arr, 2 * x + 2 , m, rx);

            values[x] = merge(values[2 * x + 1], values[2 * x + 2]);
        }

        void build(int[] arr){
            build(arr, 0, 0, size);
        }

        void set(int idx, int val, int x, int lx, int rx){
            if(rx - lx == 1){
                values[x] = single(val);
                return;
            }

            int m = (lx + rx)/2;
            if(idx < m){
                set(idx, val, 2 * x + 1, lx, m);
            }else{
                set(idx, val, 2 * x + 2, m, rx);
            }

            values[x] = merge(values[2 * x + 1], values[2 * x + 2]);
        }

        void set(int idx, int val){
            set(idx, val, 0, 0, size);
        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input0 = br.readLine().split(" ");
        int n = Integer.parseInt(input0[0]);
        int m = Integer.parseInt(input0[1]);

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i <n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        SegTree sg = new SegTree();
        sg.init(n);
        sg.build(arr);
        System.out.println(sg.calc(0, n).seg);

        while(m-- > 0){
            String[] input2 = br.readLine().split(" ");
            int idx = Integer.parseInt(input2[0]);
            int val = Integer.parseInt(input2[1]);

            sg.set(idx, val);
            System.out.println(sg.calc(0, n).seg);
        }
    }
}