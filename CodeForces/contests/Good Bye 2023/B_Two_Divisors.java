import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Two_Divisors{
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static void solve(long a, long b){
        if(b % a == 0){
            System.out.println(b*b/a);
        }else{
            System.out.println((a * b)/gcd(a, b));
        }

    }

    public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCases = Integer.parseInt(br.readLine());
            while(testCases-- > 0){
                String[] inputs = br.readLine().split(" ");
                long a = Long.parseLong(inputs[0]);
                long b = Long.parseLong(inputs[1]);
    
                
    
                solve(a, b);
            }
            br.close();
        }
}
