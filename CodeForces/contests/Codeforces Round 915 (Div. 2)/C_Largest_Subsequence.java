import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class C_Largest_Subsequence{

    private static void possibleToSort(int n, String str){
        boolean flag = true;
        for(int i = 1; i < n; i++){
            if(str.charAt(i) < str.charAt(i - 1)){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println(0);
            return;
        }
        Stack<Integer> st = new Stack<>();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            while(!st.isEmpty() && !list.isEmpty() && str.charAt(st.peek()) < ch){
                st.pop();
                list.remove(list.size() - 1);
            }
            st.push(i);
            list.add(ch);
        }

        StringBuilder sorted = new StringBuilder(str);
        int j = 0;
        while(!st.isEmpty()){
            int idx = st.pop();
            char ch = list.get(j);

            sorted.setCharAt(idx, ch);
            j++;
        }

        int ans = list.size() - 1;
        for(int i = 1; i < list.size() - 1; i++){
            if(list.get(i) == list.get(0))
                ans--;
        }
        for(int i = 1; i < n; i++){
            if(sorted.charAt(i) < sorted.charAt(i - 1)){
                ans = -1;
                break;
            }
        }

        System.out.println(ans);

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            possibleToSort(n, str);
        }

        br.close();
    }
}
