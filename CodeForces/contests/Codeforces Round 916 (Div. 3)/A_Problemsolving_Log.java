import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Problemsolving_Log{

    private static void problemsSolved(int contestDuration, String contestLog){
        int[] timeSpendAtEachProblem = new int[27];
        int solved = 0;
        for(char ch : contestLog.toCharArray()){
            int problemNum = ch - 64;
            timeSpendAtEachProblem[problemNum]++;
        }

        for(int i = 1; i <= 26; i++){
            if(timeSpendAtEachProblem[i] >= i)
                solved++;
        }

        System.out.println(solved);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            int contestDuration = Integer.parseInt(br.readLine());
            String contestLog = br.readLine();

            problemsSolved(contestDuration, contestLog);
        }

        br.close();
    }
}