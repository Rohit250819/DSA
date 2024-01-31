import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_2023{

    public static void solve(int n, int k, int[] b){
        long product = 1;
        for(int e : b)
            product *= (long)e;
        
        if(2023L % product != 0){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        System.out.print(2023L / product + " ");
        k -= 1;
        while(k-- > 0){
            System.out.print(1 + " ");
        }
        System.out.println();

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            inputs = br.readLine().split(" ");
            int[] b = new int[n];
            for(int i = 0; i < n; i++){
                b[i] = Integer.parseInt(inputs[i]);
            }

            solve(n, k, b);
        }
        br.close();
    }
}