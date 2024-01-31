import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Odd_One_Out{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            if(a == b){
                System.out.println(c);
            }else if(a == c){
                System.out.println(b);
            }else{
                System.out.println(a);
            }

        }
    }
}