//unable to solve
//always getting NO as an output 

import java.util.*;

public class D_Robot_Queries{

    static Map<Pair, List<Long>> time;
    static Map<Pair, List<Long>> rTime ;
    static Pair[] pts;
    static Pair[] pts2;
    static class Pair{
        long first, second;

        Pair(long first, long second){
            this.first = first;
            this.second = second;
        }
    }

    private static long upper_bound(List<Long> temp2, long num){
        int l = 0, r = temp2.size() - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (temp2.get(mid) > num)
                r = mid;
            else if (temp2.get(mid) < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // return -1;
        return (l < temp2.size()) ? temp2.get(l) : -1;
    }

    private static void makeMaps(String str, int n){
        time = new HashMap<>();
        rTime = new HashMap<>();
        long a = 0, b = 0;

        pts = new Pair[n + 1];
        pts[0] = new Pair(0, 0);
        time.put(pts[0], new ArrayList<>());
        time.get(pts[0]).add(0L);

        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(ch == 'L')
                a--;
            else if(ch == 'R')
                a++;
            else if(ch == 'U')
                b++;
            else
                b--;
            
            pts[i + 1] = new Pair(a, b);
            time.getOrDefault(pts[i + 1], new ArrayList<>()).add((long)(i + 1));
        }

        a = 0;
        b = 0;

        pts2 = new Pair[n + 2];
        pts2[n + 1] = new Pair(0, 0);
        rTime.put(pts2[n + 1], new ArrayList<>());
        rTime.get(pts2[n + 1]).add(0L);

        for(int i = n - 1; i >= 0; i--){
            char ch = str.charAt(i);
            if(ch == 'L')
                a--;
            else if(ch == 'R')
                a++;
            else if(ch == 'U')
                b++;
            else
                b--;

            pts2[i + 1] = new Pair(a, b);
            rTime.getOrDefault(pts2[i + 1], new ArrayList<>()).add((long)(i + 1));
        }

        for(Pair p : rTime.keySet()){
            Collections.sort(rTime.get(p));
        }

    }

    public static void isVisited(long x, long y, long l, long r, String str, int n){
        int f = 0;
        List<Long> temp = time.getOrDefault(new Pair(x, y), new ArrayList<>());
        if(!temp.isEmpty() && temp.get(0) < l){
            f = 1;
        }

        if(!temp.isEmpty() && temp.get(temp.size() - 1) > r){
            f = 1;
        }

        x -= pts[(int)(l - 1)].first;
        y -= pts[(int)(l - 1)].second;

        x += pts2[(int)(r + 1)].first;
        x += pts2[(int)(r + 1)].second;

        List<Long> temp2 = rTime.getOrDefault(new Pair(x, y), new ArrayList<>());

        long it  = upper_bound(temp2, l - 1);
        if(it != -1 && it <= r)
            f = 1;

        if(f == 1)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long q = s.nextLong();
        String str = s.next();
        
        makeMaps(str, n);
        while(q-- > 0){
            long x = s.nextLong();
            long y = s.nextLong();
            long l = s.nextLong();
            long r = s.nextLong();
            isVisited(x, y, l, r, str, n);

        }

        s.close();
    }
}