
import java.util.*;
import java.io.*;

public class NumberOfIslands_2D {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static int[][] neighbour = {
        {-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}
    };
    static int[][] vis;
    public static void DFS(ArrayList<ArrayList<Integer>> ocean, int x, int y, int n, int m){
        vis[x][y] = 1;
        outStream.println(x + " " + y);
        for(int[] each : neighbour){
            int new_x = x  + each[0];
            int new_y = y + each[1];
            if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < m ){
                if(ocean.get(new_x).get(new_y) == 1 && vis[new_x][new_y] != 1){
                    DFS(ocean, new_x, new_y, n, m);
                }
            }
        }
    }
    public static Integer NumberOfIslands_2D(ArrayList<ArrayList<Integer>> ocean, int n, int m){
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ocean.get(i).get(j) == 1 && vis[i][j] != 1 ){
                    count++;
                    DFS(ocean, i, j, n, m);
                }
            }
        }
        return count;
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int n, m;
            n =sc.nextInt();
            m =sc.nextInt();
            ArrayList<ArrayList<Integer>> ocean = new ArrayList<>();
            vis = new int[n][m];
            for(int i=0;i<n;i++)
                ocean.add(new ArrayList());
            for(int i =0;i<n;i++){
                for(int j=0;j<m;j++){
                    int x = sc.nextInt();
                    ocean.get(i).add(x);
                }
            }
            outStream.println("Number of islands : " + NumberOfIslands_2D(ocean, n, m));
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}