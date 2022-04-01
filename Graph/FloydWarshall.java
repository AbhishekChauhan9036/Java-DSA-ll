/*
The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem.
The problem is to find shortest distances between every pair of vertices in a 
given edge weighted directed Graph.

Time-complexity : O(V^3)
Good for finding all-paths shortest path and detect negative cycles.
Recommended small graphs.

===== Detecting negative cycle =====
Run floyd-warshall and then check for negative numbers in diagonal.
Distance of any node from itself is always zero. 
This is our catch, we just have to check the nodes distance from itself and 
if it comes out to be negative, we will detect the required negative cycle.

*/



import java.util.*;
import java.io.*;

public class FloydWarshall {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static Integer[][] dist;
    static Integer[][] adjMat;
    static int n, m;
    final static Integer inf = 1000000000;
    public static void FloydWarshall(){
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++)
            {
                if(i==j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = adjMat[i][j];
            }
        }
        for(int k = 1;k<n+1;k++){ //Take every node one by one, and include it in between 2 pair of vertices

            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            n = sc.nextInt();
            m = sc.nextInt();
            dist = new Integer[n+1][n+1];
            adjMat = new Integer[n+1][n+1];
            
            for(Integer[] ar : adjMat) 
                Arrays.fill(ar,inf);

            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                adjMat[u][v] = w;
            }
            FloydWarshall();
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(dist[i][j] >= inf)
                        outStream.print("inf  ");
                    else
                        outStream.print(dist[i][j] + "  ");
                }
                outStream.println();
            }
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}