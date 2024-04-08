import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B_Progressive_Square{

  private static void solve(int n, int c, int d, List<Integer> list){
    Collections.sort(list);
    List<Integer> temp = new ArrayList<>();
    int a = list.get(0);
    temp.add(a);
    for(int j = 0; j < n; j++){
    for(int i = 0; i < n - 1; i++){
      temp.add(a + d);
      a = temp.get(n * j + i + 1);
    }
    
    a = list.get(0) + (j + 1) * c;
    temp.add(a);
  }

  temp.remove(temp.size() - 1);

    // for(int num : temp)
    //   System.out.print(num + " ");
    // System.out.println();
    Collections.sort(temp);
    if(temp.equals(list)) System.out.println("YES");
    else System.out.println("NO");
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      String[] input1 = br.readLine().split(" ");
      String[] input2 = br.readLine().split(" ");

      int n = Integer.parseInt(input1[0]);
      int c = Integer.parseInt(input1[1]);
      int d = Integer.parseInt(input1[2]);

      List<Integer> list = new ArrayList<>();
      for(int i = 0; i < n * n; i++){
        list.add(Integer.parseInt(input2[i]));
      }

      solve(n, c, d, list);
    }

    br.close();
  }
}