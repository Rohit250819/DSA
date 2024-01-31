import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class minimumCostToConvertString{

    static class Pair{
        long dis;
        int node;
        
        Pair(long dis, int node){
            this.dis = dis;
            this.node = node;
        }
    }

    private static long[] solve(int a, List<List<Pair>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>((d, e) -> {
            if(d.dis != e.dis)
                return (int)(d.dis - e.dis);
            return d.node - e.node;
        });

        pq.offer(new Pair(0L, a));
        long[] dist = new long[26];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[a] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(Pair temp : adj.get(p.node)){
                if(dist[temp.node] > p.dis + temp.dis){
                    dist[temp.node] = p.dis + temp.dis;
                    pq.offer(new Pair(dist[temp.node], temp.node));
                }
            }
        }

        return dist;
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int n2 = original.length;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++)
            adj.add(new ArrayList<>());

        for(int i = 0; i < n2; i++){
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int d = cost[i];

            adj.get(u).add(new Pair(d, v));
        }

        

        Map<Integer, long[]> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            long[] k = solve(i, adj); 
            map.put(i, k);
        }

        long ans = 0;

        for(int i = 0; i < n; i++){
            if(source.charAt(i) != target.charAt(i)){
                long k = map.get(source.charAt(i) - 'a')[target.charAt(i) - 'a'];
                if(k == (Long.MAX_VALUE))
                    return -1;

                ans += k;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String source = "abcd";
        String target = "acbe";
        char[] original = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = {2, 5, 5, 1, 2, 20};

        System.out.println(minimumCost(source, target, original, changed, cost));
    }

}