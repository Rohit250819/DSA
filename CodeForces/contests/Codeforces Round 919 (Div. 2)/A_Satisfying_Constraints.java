import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A_Satisfying_Constraints{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int n = Integer.parseInt(br.readLine());
            int left = 0;
            int right = (int)1e9;
            List<Integer> exclude = new ArrayList<>();

            while(n-- > 0){
                String[] input = br.readLine().split(" ");
                int operation = Integer.parseInt(input[0]);
                int val = Integer.parseInt(input[1]);

                if(operation == 1) left = Math.max(left, val);
                else if(operation == 2) right = Math.min(right, val);
                else exclude.add(val);
            }

            // System.out.println("[" + left + "," + right + "]");

            int ans = right  - left + 1;
            for(int e : exclude){
                if(e >= left && e <= right)
                    ans--;
            }

            if(left > right) System.out.println(0);
            else System.out.println(ans);
        }

        br.close();
    }
}