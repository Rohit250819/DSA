import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A_Make_it_White{
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String s = br.readLine();
      List<Integer> idx = new ArrayList<>();
      for(int i = 0; i < n; i++){
        char ch = s.charAt(i);
        if(ch == 'B'){
          idx.add(i);
        }
      }

      if(idx.size() <= 1) System.out.println(idx.size());
      else System.out.println(idx.get(idx.size() - 1) - idx.get(0) + 1);
    }

    br.close();
  }
}