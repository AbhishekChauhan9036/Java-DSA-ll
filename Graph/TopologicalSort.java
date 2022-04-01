/*
Topological sort of Unweighted Directed acyclic graph.
Topological sort does not exist if a backedge(cycle) is present.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices 
such that for every directed edge u v, vertex u comes before v in the ordering. 

Topological Sorting for a graph is not possible if the graph is not a DAG.

Intuition:
Do normal DFS and push a node into the (topological sorted) stack only after it's recursion calls are over.
And if we before recursion we find any child is already visited that means it's a back-edge
and we need to return false(meaning topo sort is not possible).

Finally to print topological sorting fetch nodes from stack.
(or take a arrayList to store and during printing reverse arrlist then print).
*/
import java.util.*;
import java.io.*;

public class TopologicalSort {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static ArrayList<ArrayList<Integer>> adjList;
    static ArrayList<Integer> vis;
    static ArrayList<Integer> topo_list; 
    static int n, m;
    public static boolean DFS_Topo(int cur){
        vis.set(cur, 1);

         for(int nb : adjList.get(cur)){
            if(vis.get(nb) == -1){
                boolean possible = DFS_Topo(nb);
                if(!possible)
                    return false;
            }
            else if(vis.get(nb) == 1)
                return false;
        }
        vis.set(cur, 2); //important step to find backedge
        outStream.println("cur being added : " + cur);
        topo_list.add(cur);
        return true;
    }
    public static boolean TopologicalSort(){
        boolean possible = true;
        for(int i=1;i<n+1;i++){
            if(vis.get(i) == -1){
                possible &= DFS_Topo(i);
            }
            
        }
        return possible;

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here

            n = sc.nextInt();
            m = sc.nextInt();
            adjList = new ArrayList();
            vis = new ArrayList();
            topo_list = new ArrayList();
            //Set up
            for(int i=0;i<n+1;i++){
                adjList.add(new ArrayList());
                vis.add(-1);
            }

            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                // int w = sc.nextInt();
                adjList.get(u).add(v);
            }
            if(TopologicalSort()){
                Collections.reverse(topo_list);
                for(int node : topo_list)
                    outStream.println(node);
            }
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}