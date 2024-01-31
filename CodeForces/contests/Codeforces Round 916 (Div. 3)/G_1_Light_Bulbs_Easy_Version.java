import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class G_1_Light_Bulbs_Easy_Version{

    private static int calc(int l, int r, int[] g){
        int ans = 0;
        while(l < r){
            if(g[l] != -1){
                l = g[l];
            }
            else{
                l++;
                ans++;
            }
        }

        return ans;
    }

    private static void solve(int n, int[] bulbs){
        Random r = new Random();
        int[] g = new int[2*n];
        Arrays.fill(g, -1);
        long[] val = new long[n];

        for(int i = 0; i < n; i++)
            val[i] = r.nextLong();
        
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);
        long curr = 0;
        int minSet = 0;
        long ans = 1;
        int mod = 998244353;

        for(int i = 0; i < 2*n; i++){
            curr ^= val[bulbs[i]];
            if(curr == 0){
                minSet++;
                ans *= calc(map.get(0L), i + 1, g);
                ans %= mod;
            }else if(map.containsKey(curr)){
                g[map.get(curr)] = i + 1;
            }

            map.put(curr, i + 1);
        }

        System.out.println(minSet + " " + ans);

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] bulbs = new int[2*n];
            for(int i = 0; i < 2*n; i++)
                bulbs[i] = Integer.parseInt(input[i]) - 1;

            solve(n, bulbs);
        }
    }
}