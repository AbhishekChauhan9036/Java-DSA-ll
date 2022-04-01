/*
Bellman–Ford Algorithm 
https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/

Given a graph and a source vertex src in graph,find shortest paths from src to all vertices in the given graph.
The graph may contain negative weight edges, but it can't have 'negative cycle'.
It works on weighted directed and undirected graphs

//IMPORTANT//
Time complexity of Bellman-Ford is O(VE)
-- for v-1 times iterate through each edge and perform relaxation operation 
--relaxation operation : dist.set(edge.dest, Math.min(dist.get(edge.dest) , edge.weight + dist.get(edge.src) )) [ dist -> array of distance for each node]

We have discussed Dijkstra’s algorithm for this problem.
Dijkstra’s algorithm is a Greedy algorithm and time complexity is  --- O(VLogV) ---. 
Dijkstra doesn’t work for Graphs with negative weight edges, 
Bellman-Ford works for such graphs. 
Bellman-Ford is also simpler than Dijkstra and suites well for distributed systems. 
But time complexity of Bellman-Ford is O(VE), which is more than Dijkstra.
*/

import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge>{
    int u;
    int v; 
    int w;
    public Edge(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }
    public int compareTo(Edge other){
        return this.w - other.w;
    }
}
public class BellmanFord {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static ArrayList<Edge> edgeList;
    static ArrayList<Integer> dist;
    static int n, m;
    static final int inf = 10000000;

    //function returns false if negative cycle is present else returns true 
    //and the dist arraylist stores the shortest path distance of nodes from src
    public static boolean BellmanFord(int src){
        for(int i=0;i<n+1;i++){
            dist.add(inf);
        }
        dist.set(src, 0);
        //iterate for v-1 times
        for(int i=1;i<n;i++){
            //iterate through each edge
            edgeList.forEach(edge -> {
                dist.set(edge.v, Math.min(dist.get(edge.v) , edge.w + dist.get(edge.u) )); //perform relaxation
            });
        }
        ArrayList<Integer> temp  = new ArrayList(dist);
        //TODO Check if relaxation is possible one more time(nth time) to know if there is a negative cycle edge present or fucking not.
        edgeList.forEach(edge -> {
                dist.set(edge.v, Math.min(dist.get(edge.v) , edge.w + dist.get(edge.u) ));
            });
        
        if(dist.equals(temp)){
            return true;
        }else{
            dist = temp;
            return false;
        }

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            edgeList = new ArrayList();
            dist = new ArrayList();
            //Write code here
            n = sc.nextInt();
            m = sc.nextInt();
            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                edgeList.add(new Edge(u, v, w));
            }
            if(!BellmanFord(1)){
                outStream.println("Negative cycle present!");
            }else{
                for(int i=1;i<n+1;i++){
                    outStream.println(i + " : " + dist.get(i));
                }
            }
            
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}