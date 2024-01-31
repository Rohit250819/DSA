import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_We_Got_Everything_Covered {

    private static void solve(int n, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (char ch = 'a'; ch < 'a' + k; ch++) {
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            solve(n, k);
        }
        br.close();
    }
}