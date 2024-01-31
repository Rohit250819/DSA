import java.util.*;


//A R a B b b i t B a b y
public class B_YetnotherrokenKeoard{

    private static void helper(String str){
        int n = str.length();
        List<Integer> lastCapital = new ArrayList<>();
        List<Integer> lastSmall = new ArrayList<>();

        //using string gives TLE
        // String temp = "";
        // for(int i = 0; i < n; i++){
        //     char ch = str.charAt(i);
        //     if(ch != 'B' && ch != 'b'){
        //         temp = temp + ch;
        //         if(Character.isUpperCase(ch))
        //             lastCapital.add(temp.length() - 1);
        //         else
        //             lastSmall.add(temp.length() - 1);
        //     }else{
        //         if(ch == 'B' && !lastCapital.isEmpty()){
        //             temp = temp.substring(0, lastCapital.get(lastCapital.size() - 1)) + "*"+ ((temp.length() >= lastCapital.get(lastCapital.size() - 1) + 1) ? temp.substring(lastCapital.get(lastCapital.size() - 1) + 1, temp.length()) : "");
        //             lastCapital.remove(lastCapital.size() - 1);
        //         }else if(ch == 'b' && !lastSmall.isEmpty()){
        //             temp = temp.substring(0, lastSmall.get(lastSmall.size() - 1)) + "*"+ ((temp.length() >= lastSmall.get(lastSmall.size() - 1) + 1) ? temp.substring(lastSmall.get(lastSmall.size() - 1) + 1, temp.length()) : "");
        //             lastSmall.remove(lastSmall.size() - 1);
        //         }
        //     }
            
        // }

        // String ans = temp.replace("*", "");
        // System.out.println(ans);

    
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(ch != 'B' && ch != 'b'){
                temp = temp.append(ch);
                if(Character.isUpperCase(ch))
                    lastCapital.add(temp.length() - 1);
                else
                    lastSmall.add(temp.length() - 1);
            }else{
                if(ch == 'B' && !lastCapital.isEmpty()){
                    temp.setCharAt(lastCapital.get(lastCapital.size() - 1), '*');
                    lastCapital.remove(lastCapital.size() - 1);
                } else if(ch == 'b' && !lastSmall.isEmpty()){
                    temp.setCharAt(lastSmall.get(lastSmall.size() - 1), '*');
                    lastSmall.remove(lastSmall.size() - 1);
                }

            }
            
        }
        String ans = temp.toString().replace("*", "");
        System.out.println(ans);

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        while(testCases-- > 0){
            String str = s.next();
            helper(str);
        }

        s.close();
    }
}