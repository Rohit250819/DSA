// import java.util.*;
import java.io.*;
public class B_Begginer_s_Zelda{
    public static void main(String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0){
            //Approach 1
            // int vertices = Integer.parseInt(br.readLine());
            // List<List<Integer>> adj = new ArrayList<>();
            // for(int i = 0; i <= vertices; i++)
            //     adj.add(new ArrayList<>());

            // for(int i = 1; i < vertices; i++){
            //     String str[] = br.readLine().split(" ");
            //     int u = Integer.parseInt(str[0]);
            //     int v = Integer.parseInt(str[1]);

            //     adj.get(u).add(v);
            //     adj.get(v).add(u);
            // }

            // int ans = 0;
            // for(int i = 1; i <= vertices; i++){
            //     if(adj.get(i).size() == 1)
            //         ans++;
            // }

            // ans = (ans + 1) >> 1;
            // System.out.println(ans);


            //Approach 2
            int vertices = Integer.parseInt(br.readLine());
            int[] freq = new int[vertices + 1];
            for(int i = 1; i < vertices; i++){
                String str[] = br.readLine().split(" ");
                int u = Integer.parseInt(str[0]);
                int v = Integer.parseInt(str[1]);
                freq[u]++;
                freq[v]++;
            }

            int ans = 0;
            for(int i = 1; i <= vertices; i++){
                if(freq[i] == 1)
                    ans++;
            }

            ans = (ans + 1) >> 1;
            System.out.println(ans);
        }
        br.close();
}
}