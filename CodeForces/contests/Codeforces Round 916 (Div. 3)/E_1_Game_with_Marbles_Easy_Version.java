import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class E_1_Game_with_Marbles_Easy_Version{

    private static class Pair{
        int val, idx;

        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    private static void solve(int colors, int[] a, int[] b){
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.val - p1.val);

        for(int i = 0; i < colors; i++){
            pq.offer(new Pair(a[i] + b[i], i));
        }

        int f = 1;
        long alice = 0, bob = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(f == 1){
                alice += (long)(a[p.idx] - 1);
            }else{
                bob += (long)(b[p.idx] - 1);
            }

            f ^= 1;
        }

        System.out.println(alice - bob);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int colors = Integer.parseInt(br.readLine());
            String[] input1 = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");
            int[] a = new int[colors];
            int[] b = new int[colors];

            for(int i = 0; i < colors; i++){
                a[i] = Integer.parseInt(input1[i]);
                b[i] = Integer.parseInt(input2[i]);
            }

            solve(colors, a, b);
        }
    }
}