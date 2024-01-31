import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D_Unnatural_Language_Processing{

    private static void solve(int n, String word){
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(char ch : word.toCharArray())
            st.push(ch);

        while(!st.isEmpty()){
            int x = 0;
            if(st.peek() == 'a' || st.peek() == 'e')
                x = 2;
            else x = 3;

            while(x-- > 0){
                res.append(st.pop());
            }
            res.append(".");
        }

        res.deleteCharAt(res.length() - 1);
        res.reverse();

        System.out.println(res);
        
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int n = Integer.parseInt(br.readLine());
            String word = br.readLine();


            solve(n, word);

        }
        br.close();
    }
}