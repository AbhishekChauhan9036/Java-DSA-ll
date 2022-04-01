/*
What is Dijkstra’s algorithm?

Dijkstra algorithm is a greedy algorithm.
It finds a shortest-path tree for a weighted undirected graph.
This means it finds the shortest paths between nodes in a graph, which may represent, for example, 
road networks For a given source node in the graph, the algorithm finds the shortest path between the source node and every other node.
This algorithm also used for finding the shortest paths from a single node to a single destination node by stopping the 
algorithm once the sh

Time Complexity of the implementation is ----- O(V^2) -----.
If the input graph is represented using adjacency list, 
it can be reduced to ---  O(E log V) ---- with the help of binary heap.

Dijkstra’s algorithm is very similar to Prim’s algorithm.
In Prim’s algorithm, we create minimum spanning tree (MST) and 
in the Dijkstra algorithm,we create a shortest-path tree (SPT) from the given source.

This code is for undirected graph, same dijkstra function can be used for directed graphs also.
https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
https://algorithms.tutorialhorizon.com/dijkstra-algorithm-implementation-treeset-and-pair-class/
https://www.sanfoundry.com/java-program-implement-dijkstras-algorithm-using-set/
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
        if(this.x - p.x == 0)
            return this.y - p.y;
        return this.x - p.x;
    }
}
public class Djikshtra {
    static PrintWriter outStream;
    public static Integer[] Multi_Djikshtra(ArrayList<ArrayList<Pair>> adjList, int[] src){

        Integer[] dist = new Integer[adjList.size() + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Integer[] inSPT = new Integer[adjList.size() + 1];
        Arrays.fill(inSPT, -1);
        
        TreeSet<Pair> myset = new TreeSet(); //The myset is to store the sorted set of (node and distance from src) in ascending order. 
        for(int i : src){ //for each source set dist as 0 and push in the set
            myset.add(new Pair(0, i));
            dist[i] = 0;
        }
        while(!myset.isEmpty()){
            Pair p = myset.pollFirst();

            int d = p.x;
            int curnode = p.y;
            if(inSPT[curnode] == -1){
                inSPT[curnode] = 1;
                for(Pair each : adjList.get(curnode)){
                    if(inSPT[each.x] == -1){
                        if(dist[curnode] +  each.y  < dist[each.x]){
                        myset.remove(new Pair(dist[each.x], each.x));
                        dist[each.x] = dist[curnode] +  each.y;
                        myset.add(new Pair(dist[each.x], each.x));
                    }
                    }
                }
            }
        }
        return dist;
    }
    public static Integer[] Djikshtra(ArrayList<ArrayList<Pair>> adjList, int src){
        Integer[] dist = new Integer[adjList.size() + 1];
        Integer[] inSPT = new Integer[adjList.size() + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(inSPT, -1);

        TreeSet<Pair> myset = new TreeSet(); //The myset is to store the sorted set of (node and distance from src) in ascending order. 
        myset.add(new Pair(0, src)); //pushing the distance and src
        dist[src] = 0;  
        while(!myset.isEmpty()){
            Pair p = myset.pollFirst();

            int d = p.x;
            int curnode = p.y;
            if(inSPT[curnode] == -1){
                inSPT[curnode] = 1;
                for(Pair each : adjList.get(curnode)){
                        if(inSPT[each.x] == -1){
                            if(dist[curnode] +  each.y  < dist[each.x]){
                            //myset.remove(new Pair(dist[each.x], each.x));
                            dist[each.x] = dist[curnode] +  each.y;
                            //outStream.println("--" + each.x + " " + dist[each.x]);
                            myset.add(new Pair(dist[each.x], each.x));
                        }
                    }
                }
            }
            
            // outStream.println("After " + curnode + " myset includes: ");
            // Iterator<Pair> it = myset.iterator();
            // while(it.hasNext()){
            //     Pair pa= it.next();
            //     outStream.print("["+pa.x + "," + pa.y + "]");
            // }
            // outStream.println();
        }
        return dist;
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            File file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            Scanner sc = new Scanner(file);

            //Write code here
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Pair>> adjList = new ArrayList();
            for(int i=0;i<n+1;i++){
                adjList.add(new ArrayList());
            }

            for(int i=0;i<m;i++){
                int s, d, w;
                s = sc.nextInt();
                d = sc.nextInt();
                w = sc.nextInt();
                adjList.get(s).add(new Pair(d, w)); //pushing the other (node,weight)  s----w----d
                adjList.get(d).add(new Pair(s, w)); // d -----w------ s
            }
            Integer[] dist = Djikshtra(adjList, 0);
            // Integer[] dist = Multi_Djikshtra(adjList, new int[]{1,4});
            for(int i=0;i<n+1;i++){
                outStream.println(i +" : " + dist[i]);
            }
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
/*
Example Input
7 9
1 2 5
1 7 2
2 3 4
7 3 3
2 5 6
7 6 4
5 6 3
5 4 1
6 4 7
*/