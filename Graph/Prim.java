/**
https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/
The time complexity for the matrix representation is O(V^2).
In this post, O(ELogV) algorithm for adjacency list representation is discussed.
If we take a closer look,
 we can observe that the statements in inner loop are executed O(V+E) times (similar to BFS). 
 The inner loop has decreaseKey() operation which takes O(LogV) time. 
 So overall time complexity is O(E+V)*O(LogV) which is 
 O((E+V)*LogV) = O(ELogV) (For a connected graph, V = O(E))

 //
 MST vs SPT
 https://cs.stackexchange.com/questions/18797/minimum-spanning-tree-vs-shortest-path/18802#:~:text=In%20MST%2C%20requirement%20is%20to,possible%20cost%20(shortest%20weight).
 
 important Question:
 https://leetcode.com/problems/min-cost-to-connect-all-points/
 */

import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    Integer x;
    Integer y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Pair p){
        if(this.y - p.y == 0)
            return this.x - p.x;
        return this.y - p.y;
    }
}
public class Prim {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static ArrayList<ArrayList<Pair>> adjList;
    static int mstSet[];
    static int parent[];
    static int n,m;
    static int inf = 100000000;
    public static void Prim(){
        TreeSet<Pair> myset = new TreeSet();
        ArrayList<Pair> plist = new ArrayList();
        for(int i=0;i<n+1;i++){
            plist.add(new Pair(i, inf)); //node, dist
        }

        for(int i=0;i<n+1;i++){
            myset.add(plist.get(i));
        }

        parent[0] = -1;
        
        while(!myset.isEmpty()){
            Pair cur = myset.pollFirst();
            int node = cur.x;
            // int dist = cur.y;
            mstSet[node] = 1;
            for(Pair nb : adjList.get(node)){
                int v = nb.x;
                int w = nb.y;
                    if(mstSet[v] == -1)
                    {
                        if(plist.get(v).y > w){
                        myset.remove(plist.get(v));
                        plist.set(v, new Pair(v, w));
                        myset.add(plist.get(v));
                        parent[v] = node;
                    }
                    
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
            adjList = new ArrayList();

            n = sc.nextInt();
            m = sc.nextInt();

            mstSet = new int[n+1];
            parent = new int[n+1];

            for(int i=0;i<n+1;i++){
                adjList.add(new ArrayList());
                mstSet[i] = -1;
            }
            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                adjList.get(u).add(new Pair(v, w));
                adjList.get(v).add(new Pair(u, w));
            }
            Prim();

            for(int i=0;i<n+1;i++){
                outStream.print(parent[i] + " ");
            }


            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}