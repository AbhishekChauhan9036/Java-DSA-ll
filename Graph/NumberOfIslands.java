/**
Number of islands in grid format:
https://www.geeksforgeeks.org/find-number-of-islands/

Number of islands in graph format:
Code is below, it's a simple component counting code implemented using DFS( BFS can also be used).
 */
import java.util.*;
import java.io.*;

public class NumberOfIslands {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static ArrayList<ArrayList<Integer>> adjList;
    static int vis[];
    static int n, m;
    static void DFSinGraph(int cur){
        vis[cur] = 1;
        for(int nb : adjList.get(cur)){
            if(vis[nb] == -1){
                DFSinGraph(nb);
            }
        }
    }
    public static int NumberOfIslandsInGrid(){
        return 0;
    }
    public static int NumberOfIslandsInGraph(){
        int count = 0;
        for(int i=1;i<n+1;i++){
            if(vis[i] ==  -1){
                count++;
                DFSinGraph(i);
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
            adjList = new ArrayList();
            n = sc.nextInt();
            m = sc.nextInt();

            vis = new int[n+1];
            Arrays.fill(vis, -1);

            for(int i=0;i<n+1;i++)
                adjList.add(new ArrayList());
            
            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            outStream.println("Number of islands : " +  NumberOfIslandsInGraph());

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}