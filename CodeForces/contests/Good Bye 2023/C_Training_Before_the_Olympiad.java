import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Training_Before_the_Olympiad{

    private static void solve(int n, int[] arr){
        long sum = 0;
        int odd = 0, even = 0;

        for(int i = 0; i < n; i++){
            sum += (long)arr[i];
            odd += (arr[i] % 2 == 1) ? 1 : 0;
            even += (arr[i] % 2 == 0) ? 1 : 0;

            if(i == 0) System.out.print(sum + " ");
            else System.out.print(sum - (odd / 3) - ((odd % 3 == 1) ? 1 : 0) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(input[i]);
            }

            solve(n, arr);
        }

        br.close();
    }
}