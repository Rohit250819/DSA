import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_Rudolf_and_the_Ugly_String{

  private static void solve(int n, String str){
    int ans = 0, i = 0;

    while(i < n - 2){
      if(str.substring(i, i + 3).equals("map") || str.substring(i, i + 3).equals("pie")){
        ans++;
        i += 3;
        continue;
      }else if(i + 5 < n && str.substring(i, i + 5).equals("mapie")){
        ans++;
        i += 5;
        continue;
      }
      i++;
    }

    System.out.println(ans);
  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());

    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String str = br.readLine();
      
      solve(n, str);

    }
    br.close();
}
}