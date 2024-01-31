import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Can_I_Square{

    private static boolean check(int n, int[] buckets){
        long sum = 0L;

        for(int b : buckets)
            sum += (long)b;

        long sqrt = (long) Math.ceil(Math.sqrt(sum));
        if(sqrt * sqrt != sum)
            return false;
        
        return true;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int noOfBuckets = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            int[] buckets = new int[noOfBuckets];
            for(int i = 0; i < noOfBuckets; i++){
                buckets[i] = Integer.parseInt(inputs[i]);
            }


            if(check(noOfBuckets, buckets)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}