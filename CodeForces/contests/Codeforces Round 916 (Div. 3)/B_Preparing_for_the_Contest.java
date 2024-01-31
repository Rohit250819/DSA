import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_Preparing_for_the_Contest{

    private static void orderOfProblems(int n, int k){
        int[] order = new int[n];
        if(k == 0){
            for(int i = 0; i < n; i++){
                order[i]  = n - i;
            }

            for(int o : order){
            System.out.print(o + " ");
        }
            System.out.println();
            return;
        }
        for(int i = 0; i < n; i++){
            order[i] = i + 1;
        }
        
        int start = k, end = n - 1;
        while(start < end){
            int temp = order[start];
            order[start] = order[end];
            order[end] = temp;
            start++;
            end--;
        }

        for(int o : order){
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            orderOfProblems(n, k);
        }
        br.close();
    }
}