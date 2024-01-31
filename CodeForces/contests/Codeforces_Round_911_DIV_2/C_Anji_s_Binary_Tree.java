import java.util.*;

public class C_Anji_s_Binary_Tree {
    static int[] dp;

    private static int minOperations(int[][] binaryTree, String str, int curr) {
        if (binaryTree[curr][0] == 0 && binaryTree[curr][1] == 0)
            return 0;

        if (dp[curr] != -1)
            return dp[curr];
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (binaryTree[curr][0] != 0)
            left = (str.charAt(curr - 1) != 'L' ? 1 : 0) + minOperations(binaryTree, str, binaryTree[curr][0]);

        if (binaryTree[curr][1] != 0)
            right = (str.charAt(curr - 1) != 'R' ? 1 : 0) + minOperations(binaryTree, str, binaryTree[curr][1]);

        return dp[curr] = Math.min(left, right);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        while (testCases-- > 0) {
            int n = s.nextInt();
            String str = s.next();
            int[][] binaryTree = new int[n + 1][2];

            for (int i = 1; i <= n; i++) {
                binaryTree[i][0] = s.nextInt();
                binaryTree[i][1] = s.nextInt();
            }
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            System.out.println(minOperations(binaryTree, str, 1));
        }

        s.close();
    }
}