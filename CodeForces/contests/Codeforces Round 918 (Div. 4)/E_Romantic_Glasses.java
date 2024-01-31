import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E_Romantic_Glasses{

    private static void canImpress(int n, int[] glass){
        long sum = 0L;
        
        Map<Long, Integer> freq = new HashMap<>();
        freq.put(0L, 1);
        for(int i = 0; i < n; i++){
            glass[i] *= ((i % 2 == 1) ? -1 : 1);
            sum += glass[i];
            if(freq.containsKey(sum)){
                System.out.println("YES");
                return;
            }
            
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        System.out.println("NO");
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int n = Integer.parseInt(br.readLine());
            String inputs[] = br.readLine().split(" ");
            int[] glass = new int[n];
            for(int i = 0; i < n; i++){
                glass[i] = Integer.parseInt(inputs[i]);
            }

            canImpress(n, glass);
        }
        br.close();
    }
}