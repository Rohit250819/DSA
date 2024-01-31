import java.util.*;

public class B_Laura_and_Operations {

    private static void Laura_and_Operations(int a, int b, int c) {
        if(c % 2 == b % 2)
            System.out.print("1 ");
        else
            System.out.print("0 ");
        
        if(a % 2 == c % 2)
            System.out.print("1 ");
        else
            System.out.print("0 ");
        
        if(a % 2 == b % 2)
            System.out.print("1 ");
        else
            System.out.print("0 ");
        
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        while (testCases-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();

            Laura_and_Operations(a, b, c);
        }
        s.close();
    }
}