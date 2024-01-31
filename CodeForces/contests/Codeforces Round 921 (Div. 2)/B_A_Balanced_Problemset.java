import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_A_Balanced_Problemset{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while(testCases-- > 0){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            int ans = 1;

            for(int i = 1; i * i <= x; i++){
                if(x % i == 0){
                    if(x / i >= n){
                        ans = Math.max(ans, i);
                    }

                    if(i >= n){
                        ans = Math.max(ans, x / i);
                    }
                }
            }

            System.out.println(ans);

        }

        br.close();
    }
}