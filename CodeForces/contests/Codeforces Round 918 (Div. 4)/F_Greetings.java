import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class F_Greetings{

    //***Gives TLE***
    // private static void solve(int n, long[][] positions){
    //     Arrays.sort(positions, Comparator.comparingLong(a -> a[0]));
    //     TreeSet<Long> ts = new TreeSet<>();
    //     long ans = 0;

    //     for(long[] pos : positions){
    //         long start = pos[0];
    //         long end = pos[1];

    //         ans += ts.size() - ts.headSet(end).size();
    //         ts.add(end);
    //     }

    //     System.out.println(ans);
    // }

    private static int bs(List<Long> list, long e){
        int aus = list.size();
        int left = 0, right = list.size() - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(list.get(mid) > e){
                aus = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return aus;
    }

    private static void solve(int n, long[][] positions){
        Arrays.sort(positions, (a, b) ->{
            return (int) (a[1] - b[1]);
        });

        long ans = 0L;
        List<Long> list = new ArrayList<>();
        list.add(positions[0][0]);

        for(int i = 1; i < n; i++){
            if(list.get(i - 1) < positions[i][0])
                list.add(positions[i][0]);
            else{
                int pos = bs(list, positions[i][0]);
                ans += (long)(i - pos);
                list.add(pos,positions[i][0]);
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int n = Integer.parseInt(br.readLine());
            long[][] positions = new long[n][2];

            for(int i = 0; i < n; i++){
                String[] input = br.readLine().split(" ");
                positions[i][0] = Long.parseLong(input[0]);
                positions[i][1] = Long.parseLong(input[1]);
            }

            solve(n, positions);
        }

        br.close();
    }
}