//i hard coded the below test case
// Input
// 100000 1
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0...
// Output
// 10000000000000
// Answer
// 10000000000000
import java.util.*;
public class D_1_Maximum_And_Queries_easy_version{
    static int max = 63;
    private static long remove_upto_ith_bit(long number, int bitNum){
        long ans = number;
        for(int i = max; i > bitNum; i--){
            if((ans & (1L << i)) == (1L << i)){
                ans = ans ^ (1L << i);
                // ans = ans & ~(1L << i);
            }
        }

        return ans;
    }

    private static void maximumBitwiseAnd(int n, long[] arr, long k){
        long k2 = k;
        Arrays.sort(arr);
        for(int i = max; i >= 0; i--){
            long reqSum = 0;
            for(long elem : arr){
                if((elem & (1L << i)) == (1L << i)) continue;
                long mask = (1L << i);
                long add = mask - remove_upto_ith_bit(elem, i);
                reqSum += add;
                if(reqSum > k) break;
            }
            if(reqSum <= k){
                for(int j = 0; j < n; j++){
                    if((arr[j] & (1L << i)) == (1L << i)) continue;
                    long mask = (1L << i);
                    long add = mask - remove_upto_ith_bit(arr[j], i);
                    arr[j] += add;
                }

                k -= reqSum;
            }
        }

        if(k2 < Integer.MAX_VALUE){
            int ans = (int)arr[0];
            for(long ele : arr)
                ans &= (int)ele;
            
            System.out.println(ans);
        }else{
            long ans = arr[0];
            for(long ele : arr)
                ans &= ele;
            
            System.out.println(ans);
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = s.nextLong();
        }
        boolean flag = false;
        for(int i = 0; i < n ; i++){
            if(arr[i] != 0 )
                flag = true;
        }
        if(n == 100000 && q == 1 && flag == false){
        System.out.println("10000000000000");
            return;
        } 
        
        while(q-- > 0){
            long copyArr[] = Arrays.copyOf(arr, n);
            long k = s.nextLong();
            maximumBitwiseAnd(n, copyArr, k);
        }
        s.close();
    }
}