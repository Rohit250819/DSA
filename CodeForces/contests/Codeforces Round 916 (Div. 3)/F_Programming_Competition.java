import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class F_Programming_Competition{

    private static void dfs(List<List<Integer>> tree, int[] subtree, int node){
        subtree[node]++;

        for(int v : tree.get(node)){
            dfs(tree, subtree, v);
            subtree[node] += subtree[v];
        }
    }

    private static int dfs2(List<List<Integer>> tree, int[] subtree, int node, int x){
        int ans = (x > 0) ? 1 : 0;

        if(x > 0) x--;

        int tot = 0;
        for(int v : tree.get(node))
            tot += subtree[v];

        for(int v : tree.get(node)){
            ans += dfs2(tree, subtree, v, x + tot - subtree[v]);
        }

        return ans;
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            List<List<Integer>> tree = new ArrayList<>();
            for(int i = 0; i < n; i++){
                tree.add(new ArrayList<>());
            }

            for(int i = 1; i < n; i++){
                tree.get(Integer.parseInt(input[i - 1]) - 1).add(i);
            }

            int[] subtree = new int[n];
            dfs(tree, subtree, 0);
            int ans = dfs2(tree, subtree, 0, 0);
            System.out.println(ans / 2);
        }
    }
}