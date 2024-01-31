import java.util.*;
import java.io.*;
public class A_Easy_As_ABC{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] grid = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                grid[i][j] = (char)br.read();
            }
            br.readLine();
        }
        br.close();
    }
}