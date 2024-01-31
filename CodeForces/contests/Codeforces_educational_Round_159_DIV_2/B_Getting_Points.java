import java.util.*;
public class B_Getting_Points{

    private static long calc(long k, long tasks, long t, long l){
        return k*l + Math.min(tasks, 2 * k)*t;
    }

    private static void maximumRestDays(long n, long P, long l, long t){
        long tasks = (long)Math.ceil(n / (double)7);
        long left = 0;
        long right = n;

        while(right - left > 1){
            long mid = left + (right - left)/2;
            if(calc(mid, tasks, t, l) >= P){
                right = mid;
            }else{
                left = mid;
            }
        }

        System.out.println(n - right);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        while(testCases-- > 0){
            long n = s.nextLong();
            long P = s.nextLong();
            long l = s.nextLong();
            long t = s.nextLong();

            maximumRestDays(n, P, l, t);
        }
        s.close();
    }
}