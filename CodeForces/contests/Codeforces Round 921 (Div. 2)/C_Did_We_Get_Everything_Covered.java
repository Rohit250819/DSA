import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class C_Did_We_Get_Everything_Covered{

    private static void solve(int n, int k, int m, String str){
        Set<Character> set = new HashSet<>();
        String missing = "";
        for(char ch : str.toCharArray()){
            set.add(ch);
            if(set.size() == k){
                set.clear();
                missing = missing + ch;
            }
        }

        if(missing.length() >= n) System.out.println("YES");
        else{
            System.out.println("NO");
            char temp = 0;
            for(char ch = 'a'; ch < 'a' + k; ch++){
                if(!set.contains(ch)){
                    temp = ch;
                    break;
                }
            }

            while(missing.length() < n) missing = missing + temp;
            System.out.println(missing);
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while(testCases-- > 0){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int m = Integer.parseInt(input[2]);

            String str = br.readLine();

            solve(n, k, m, str);
        }

        br.close();
    }
}