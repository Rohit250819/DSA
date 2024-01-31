import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_Mathematical_Problem{

    private static void solve(int n){
        if(n == 1){ 
            System.out.println(1);
            return;
        }
        
        System.out.print("196");
        for(int i = 3; i < n; i++){
            System.out.print("0");
        }

        System.out.println();

        //169
        for(int i = 0; i < n/2; i++){
            System.out.print("1");
            for(int j = 0; j < i; j++) System.out.print("0");
            System.out.print("6");
            for(int j = 0; j < i; j++) System.out.print("0");
            System.out.print("9");
            for(int j = 3 + 2*i; j < n; j++) System.out.print("0");
            System.out.println();
        }

        //196
        for(int i = 0; i < n/2; i++){
            System.out.print("9");
            for(int j = 0; j < i; j++) System.out.print("0");
            System.out.print("6"); 
            for(int j = 0; j < i; j++) System.out.print("0");
            System.out.print("1");
            for(int j = 3 + 2*i; j < n; j++) System.out.print("0");
            System.out.println();
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int n = Integer.parseInt(br.readLine());
            solve(n);
        }
        br.close();
    }
}