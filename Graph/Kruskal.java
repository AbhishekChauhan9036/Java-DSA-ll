/*
 =========== Kruskal’s Minimum Spanning Tree Algorithm ================
Given a connected and undirected (weighted/unweighted) graph,
a spanning tree of that graph is a subgraph that is a tree and connects all the vertices together.
A single graph can have many different spanning trees.

How many edges does a minimum spanning tree has? 
A minimum spanning tree has (V – 1) edges where V is the number of vertices in the given graph. 

Time Complexity: ----   O(ElogE) or O(ElogV) ----. 

Sorting of edges takes O(ELogE) time. 
After sorting, we iterate through all edges and apply find-union algorithm. 
The find and union operations can take atmost O(LogV) time. 
So overall complexity is O(ELogE + ELogV) time. 
The value of E can be atmost O(V^2), so O(LogV) and O(LogE) same.
 Therefore, overall time complexity is O(ElogE) or O(ElogV)

 https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
 https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/?ref=lbp
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
public class Kruskal {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static ArrayList<Edge> edgeList;
    static ArrayList<Edge> mstEdgeList;
    static Integer[] parent;
    static Integer[] rank;
    static int n,m;
    public static Integer find(int node){
        int original_node = node;
        while(parent[node] != -1){
            node = parent[node];
        }
        //This where path compression takes place.
        parent[original_node] = node;
        return node;
    }
    public static void union(int u, int v){
        //This is union by rank.
        if(rank[u]<rank[v]){
            parent[u] = v;
            // rank[v]++;
        }else if(rank[u]>rank[v]){
            parent[v] = u;
            // rank[u]++;
        }else{
            parent[v] = u;
            rank[u]++;
        }
    }
    public static void Kruskal(){
        
        parent = new Integer[n+1];
        Arrays.fill(parent, -1);

        rank = new Integer[n+1];
        Arrays.fill(rank, 0);

        mstEdgeList = new ArrayList();

        Collections.sort(edgeList);


        //Instead of checking for all edge we can stop when size of mstEdgeList becomes (n-1) i.e. vertices - 1.
        for(Edge each : edgeList){
            int uroot = find(each.u);
            int vroot = find(each.v);
            if(uroot != vroot){
                union(uroot, vroot);
                mstEdgeList.add(each);
            }
        }


    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);
            
            //Write code here
            edgeList = new ArrayList();
            n = sc.nextInt();
            m = sc.nextInt();

            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                edgeList.add(new Edge(u, v, w));
            }
            // Collections.sort(edgeList);
            // for(Edge each : edgeList){
            //     outStream.println(each.u + " " + each.v + " "+each.w);
            // }
            Kruskal();
            outStream.println("Included Edges :");
            for(Edge each : mstEdgeList){
                outStream.println(each.u + " " + each.v + " "+each.w);
            }
            outStream.println("Parent array : ");
            for(Integer i : parent){
                outStream.print(i +" ");
            }
            outStream.println();
            outStream.println("Rank array :");
            for(Integer i : rank){
                outStream.print(i +" ");
            }
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}