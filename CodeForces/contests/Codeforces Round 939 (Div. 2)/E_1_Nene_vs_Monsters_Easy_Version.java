import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E_1_Nene_vs_Monsters_Easy_Version{

  static class Pair{
    int first, second;

    Pair(int first, int second){
      this.first = first;
      this.second = second;
    }
  }
  
  private static void solve(int n, int[] energyLevels){
    List<Pair> list = new ArrayList<>();


    for(int i = 0; i < n; i++){
      energyLevels[(i + 1) % n] = Math.max(0, energyLevels[(i + 1) % n] - energyLevels[i]);
      if(energyLevels[(i + 1) % n] != 0 && energyLevels[(i) % n] != 0){
        Pair p = new Pair(i , (i + 1) % n);
        list.add(p);
      }
    }

    for(Pair p : list){
      int first = p.first;
      int second = p.second;

      while(energyLevels[second % n] != 0 && energyLevels[first] != 0)
        energyLevels[second % n] = Math.max(0, energyLevels[second % n] - energyLevels[first]);
    }

    int ans = 0;
    List<Integer> temp = new ArrayList<>();
    for(int i = 0; i < n; i++){
      if(energyLevels[i] != 0){
        ans++;
        temp.add(i + 1);
      }
    
    }

    System.out.println(ans);
    for(int t : temp)
      System.out.print(t + " ");

    System.out.println();
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String[] input = br.readLine().split(" ");

      int[] energyLevels = new int[n];
      for(int i = 0; i < n; i++){
        energyLevels[i] = Integer.parseInt(input[i]);
      }

      solve(n, energyLevels);
    }

    br.close();
  }
}