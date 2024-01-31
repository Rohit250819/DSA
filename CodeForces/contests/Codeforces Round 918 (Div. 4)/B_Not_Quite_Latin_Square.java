import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_Not_Quite_Latin_Square{

    private static void helper(String a, String b, String c){
        boolean flag = false;
            boolean[] letters = new boolean[3];
            for(int i = 0; i < a.length(); i++){
                char ch = a.charAt(i);
                if(ch != '?'){
                    letters[ch - 'A'] = true;
                }
                if(ch == '?')
                    flag = true;
            }

            if(flag){
                if(!letters[0])
                    System.out.println('A');
                else if(!letters[1])
                    System.out.println('B');
                else
                    System.out.println('C');

                return;
            }

            Arrays.fill(letters, false);
            for(int i = 0; i < b.length(); i++){
                char ch = b.charAt(i);
                if(ch != '?'){
                    letters[ch - 'A'] = true;
                }
                if(ch == '?')
                    flag = true;
            }

            if(flag){
                if(!letters[0])
                    System.out.println('A');
                else if(!letters[1])
                    System.out.println('B');
                else
                    System.out.println('C');
                
                return ;
            }

            Arrays.fill(letters, false);
            for(int i = 0; i < c.length(); i++){
                char ch = c.charAt(i);
                if(ch != '?'){
                    letters[ch - 'A'] = true;
                }
                if(ch == '?')
                    flag = true;
            }

            if(flag){
                if(!letters[0])
                    System.out.println('A');
                else if(!letters[1])
                    System.out.println('B');
                else
                    System.out.println('C');

                return;
            }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            String a = br.readLine();
            String b = br.readLine();
            String c = br.readLine();
            
            helper(a, b, c);
            
        }
    }
}