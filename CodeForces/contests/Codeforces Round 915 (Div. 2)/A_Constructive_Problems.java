import java.io.*;


public class A_Constructive_Problems{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            System.out.println(Math.max(n, m));
        }
        br.close();
    }
}