import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_Summation_Game {

    private static void solve(int n, int k, int x, int[] A) {
        Arrays.sort(A, 1, n + 1);
        reverse(A, 1, n + 1);

        for (int i = 1; i <= n; i++) {
            A[i] += A[i - 1];
        }

        int sum = A[n];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i <= k; i++){
            // ans = Math.max(ans, sum - 2 * (A[Math.min(i + x, n)] - A[i]) - A[i]);
            ans = Math.max(ans, sum - 2 *A[Math.min(i + x, n)] + A[i]);//just modified the above line
        }

        System.out.println(ans);
    }

    private static void reverse(int[] arr, int from, int to) {
        while (from < to) {
            int temp = arr[from];
            arr[from] = arr[to - 1];
            arr[to - 1] = temp;
            from++;
            to--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);

            String[] input2 = br.readLine().split(" ");
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i + 1] = Integer.parseInt(input2[i]);
            }

            solve(n, k, x, arr);
        }
        br.close();
    }
}
