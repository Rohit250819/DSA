import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class C_Rudolf_and_the_Ugly_String{
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String str = br.readLine();
      int ans = 0;
      Set<Integer> set = new HashSet<>();
      for(int i = 0; i <= n - 3; i++){
        if(str.substring(i, i + 3).equals("map") || str.substring(i, i + 3).equals("pie")){
          set.add(i);
          set.add(i + 2);
        }
          
      }

      System.out.println(set.size()/2);

    }
    br.close();
}
}