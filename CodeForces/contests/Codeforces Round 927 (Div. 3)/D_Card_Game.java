import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class D_Card_Game{

  private static void solve(int n, char trump, String[] cards){
    HashMap<Character, List<Integer>> map = new HashMap<>();
    for(String str : cards){
      char suit = str.charAt(1);
      int rank = str.charAt(0);

      if(map.containsKey(suit)){
        map.get(suit).add(rank);
      }else{
        map.put(suit, new ArrayList<>());
        map.get(suit).add(rank);
      }
    }

    for(Character key : map.keySet()){
      Collections.sort(map.get(key));
    }

    
    List<String> trumpList = new ArrayList<>();
    List<String> C = new ArrayList<>();
    List<String> D = new ArrayList<>();
    List<String> H = new ArrayList<>();
    List<String> S = new ArrayList<>();
    if(map.get(trump)!= null){
    for(int e : map.get(trump)){
      trumpList.add(Integer.toString(e) + trump);
    }
  }
    for(Character key : map.keySet()){
      if(!key.equals(trump)){
        if(key == 'C'){
          for(int e : map.get(key)){
            C.add(Integer.toString(e) + 'C');
          }
        }
        if(key == 'D'){
          for(int e : map.get(key)){
            D.add(Integer.toString(e) + 'D');
          }
        }
        if(key == 'H'){
          for(int e : map.get(key)){
            H.add(Integer.toString(e) + 'H');
          }
        }
        if(key == 'S'){
          for(int e : map.get(key)){
            S.add(Integer.toString(e) + 'S');
          }
        }
      }
    }

    for(String s : C)
      System.out.print(s + " ");
    System.out.println();
    for(String s : D)
      System.out.print(s + " ");
    System.out.println();
    for(String s : H)
      System.out.print(s + " ");
    System.out.println();
    for(String s : S)
      System.out.print(s + " ");
    System.out.println();

    List<String> list = new ArrayList<>();
    while(!C.isEmpty()){
      if(C.size() == 1){
        list.add(C.remove(0));
        if(!trumpList.isEmpty()){
          list.add(trumpList.remove(0));
        }
      }else{
        list.add(C.remove(0));
        list.add(C.remove(0));
      }
    }
    while(!D.isEmpty()){
      if(D.size() == 1){
        list.add(D.remove(0));
        if(!trumpList.isEmpty()){
          list.add(trumpList.remove(0));
        }
      }else{
        list.add(D.remove(0));
        list.add(D.remove(0));
      }
    }
    while(!H.isEmpty()){
      if(H.size() == 1){
        list.add(H.remove(0));
        if(!trumpList.isEmpty()){
          list.add(trumpList.remove(0));
        }
      }else{
        list.add(H.remove(0));
        list.add(H.remove(0));
      }
    }
    while(!S.isEmpty()){
      if(S.size() == 1){
        list.add(S.remove(0));
        if(!trumpList.isEmpty()){
          list.add(trumpList.remove(0));
        }
      }else{
        list.add(S.remove(0));
        list.add(S.remove(0));
      }
    }

    if(list.size() != n){
      System.out.println("IMPOSSIBLE");
      return;
    }

    for(int i = 0; i < list.size() - 1; i+=2){
      System.out.println(list.get(i) + " " + list.get(i + 1));
    }

  }

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());
    while(testCases-- > 0){
      int n = Integer.parseInt(br.readLine());
      String trump = br.readLine();
      String[] cards = br.readLine().split(" ");

      solve( n, trump.charAt(0), cards);

    }

    br.close();
  }
}