import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List; 
import java.util.PriorityQueue;
// import java.util.TreeSet;

public class G_Bicycles{


    static class Pair{
        int node, weight;

        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }


    private static void solve(int n, int m, List<List<Pair>> adj, int[] sFactor){
        long[][] dis = new long[n][n];
        boolean[][] vis = new boolean[n][n];

        for(int i = 0; i < n; i++)
            Arrays.fill(dis[i], Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        dis[0][0] = 0;
        pq.add(new long[]{0, 0, 0});

        while(!pq.isEmpty()){
            long[] top = pq.poll();
            int city = (int)top[1];
            int bike = (int)top[2];

            if(city == n - 1){
                System.out.println(dis[city][bike]);
                return;
            }

            if(vis[city][bike]) continue;
            vis[city][bike] = true;

            for(Pair p : adj.get(city)){
                int nbr = p.node;
                int wt = p.weight;

                int newBike = bike;
                if(sFactor[nbr] < sFactor[bike]) newBike = nbr;

                if(dis[nbr][newBike] > dis[city][bike] + wt * sFactor[bike]){
                    dis[nbr][newBike] = dis[city][bike] + wt * sFactor[bike];
                    pq.add(new long[]{dis[nbr][newBike], nbr, newBike});
                }

            }
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            String[] input1 = br.readLine().split(" ");
            int n = Integer.parseInt(input1[0]);
            int m = Integer.parseInt(input1[1]);

            List<List<Pair>> adj = new ArrayList<>();
            for(int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
                
            for(int i = 0; i < m; i++){
                String[] input2 = br.readLine().split(" ");
                int u = Integer.parseInt(input2[0]) - 1;
                int v = Integer.parseInt(input2[1]) - 1;
                int w = Integer.parseInt(input2[2]);
                adj.get(u).add(new Pair(v, w));
                adj.get(v).add(new Pair(u, w));
            }

            String[] input3 = br.readLine().split(" ");
            int[] sFactor = new int[n];
            for(int i = 0; i < n; i++)
                sFactor[i] = Integer.parseInt(input3[i]);

            solve(n, m, adj, sFactor);
        }
    }
}


