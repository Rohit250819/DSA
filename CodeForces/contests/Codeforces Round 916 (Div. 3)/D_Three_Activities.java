import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_Three_Activities{

    private static int[] getBestThree(int[] a){
        int max1 = -1, max2 = -1, max3 = -1;

        for(int i = 0; i < a.length; i++){
            if(max1 == -1 || a[i] > a[max1]){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }else if(max2 == -1 || a[i] > a[max2]){
                max3 = max2;
                max2 = i;
            }else if(max3 == -1 || a[i] > a[max3]){
                max3 = i;
            }
        }

        return new int[] {max1, max2, max3};
    }

    private static void solve(int days, int[] skiing, int[] movie, int[] boardGame){
        int ans = 0;
        
        for(int x : getBestThree(skiing)){
            for(int y : getBestThree(movie)){
                for(int z : getBestThree(boardGame)){
                    if(x != y && x != z && y != z){
                        ans = Math.max(ans, skiing[x] + movie[y] + boardGame[z]);
                    }
                }
            }
        }

        System.out.println(ans);
        
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int days = Integer.parseInt(br.readLine());
            int[] skiing = new int[days];
            String[] input1 = br.readLine().split(" ");
            for(int i = 0; i < days; i++)
                skiing[i] = Integer.parseInt(input1[i]);
            
            int[] movie = new int[days];
            String[] input2 = br.readLine().split(" ");
            for(int i = 0; i < days; i++)
                movie[i] = Integer.parseInt(input2[i]);
            
            int[] boardGame = new int[days];
            String[] input3 = br.readLine().split(" ");
            for(int i = 0; i < days; i++)
                boardGame[i] = Integer.parseInt(input3[i]);
            
            solve(days, skiing, movie, boardGame);
        }
    }
}