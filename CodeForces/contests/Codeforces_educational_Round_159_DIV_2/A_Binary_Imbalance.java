import java.util.*;
public class A_Binary_Imbalance{

    private static void solve(int n, String str){
        int count_0 = 0, count_1 = 0;

        for(int i = 0; i < n; i++){
            if(str.charAt(i) == '0')
                count_0++;
            else
                count_1++;
        }

        if(count_0 > count_1){
            System.out.println("YES");
        }else{
            for(int i = 0; i < n - 1; i++){
                if(str.charAt(i) != str.charAt(i + 1)){
                    System.out.println("YES");
                    return;
                }
            }
            System.out.println("NO");
            
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        while(testCases-- > 0){
            int n = s.nextInt();
            String str = s.next();

            solve(n, str);
        }
        s.close();
    }
}