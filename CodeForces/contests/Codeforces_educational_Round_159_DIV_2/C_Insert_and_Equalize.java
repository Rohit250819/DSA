import java.util.*;

public class C_Insert_and_Equalize{

    private static long gcd(long a, long b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }

    private static void minOperations(int n, long[] arr){
        if(n == 1){
            System.out.println(1);
            return;
        }

        Arrays.sort(arr);
        long curr_gcd = arr[1] - arr[0];
        for(int i = 1; i < n; i++){
            curr_gcd = gcd(arr[i] - arr[i - 1], curr_gcd);
        }

        long newElement = Long.MAX_VALUE;
        for(int i = n - 1; i > 0; i--){
            if(arr[i] - arr[i - 1] > curr_gcd){
                newElement = arr[i] - curr_gcd;
                break;
            }
        }

        if(newElement == Long.MAX_VALUE)
            newElement = arr[n - 1] + curr_gcd;

        long ans = 0;
        if(newElement > arr[n - 1]){
            for(int i = 0; i < n; i++){
                ans += (newElement - arr[i]) / curr_gcd;
            }
        }else{
            for(int i = 0; i < n; i++){
                ans += (arr[n - 1] - arr[i]) / curr_gcd;
            }
            ans += (arr[n - 1] - newElement)/curr_gcd;
        }

        System.out.println(ans);
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        s.nextLine();
        while(testCases-- > 0){
            int n = s.nextInt();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++){
                arr[i] = s.nextLong();
            }

            minOperations(n, arr);
        }
        s.close();
    }
}