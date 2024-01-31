import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Quests{

    private static void solve(int n, int k, int[] a, int[] b){
        long sum = 0;
        long result = Long.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < Math.min(n, k); i++){
            sum += a[i];
            max = Math.max(max, b[i]);
            result = Math.max(result, sum + max* (k - i - 1));
        }

        System.out.println(result);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            String[] first = br.readLine().split(" ");
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(first[i]);
            }

            String[] second = br.readLine().split(" ");
            int[] b = new int[n];
            for(int i = 0; i < n; i++){
                b[i] = Integer.parseInt(second[i]);
            }
            solve(n, k, a, b);
        }

        br.close();
        
    }
}