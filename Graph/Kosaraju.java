/**
https://www.geeksforgeeks.org/strongly-connected-components/
https://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/GraphAlgor/strongComponent.html

Steps : 
1) Create an empty stack ‘S’ and do DFS traversal of a graph. 
    In DFS traversal, after calling recursive DFS for adjacent vertices of a vertex, 
    push the vertex to stack.
2) Reverse directions of all edges to obtain the transpose graph.
3) One by one pop a vertex from S while S is not empty. 
    Let the popped vertex be ‘v’. Take v as source and do DFS (
 */
import java.util.*;
import java.io.*;

public class Kosaraju {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static ArrayList<ArrayList<Integer>> adjList;
    static int vis[];
    static int n, m;
    static void fillStackInOrder(Stack<Integer> stack, int cur){
        vis[cur] = 1;
        for(int nb : adjList.get(cur)){
            if(vis[nb] == -1){
                fillStackInOrder(stack, nb);
            }
        }
        stack.push(cur);
    }
    static void DFSPrint(int cur){
        vis[cur] = 1;
        outStream.print(cur + " ");
        for(int nb : adjList.get(cur)){
            if(vis[nb] == -1){
                DFSPrint(nb);
            }
        }
    }
    static void TransposeGraph(){
        ArrayList<ArrayList<Integer>> tempList;
        tempList = new ArrayList();
        for(int i=0;i<n+1;i++)
            tempList.add(new ArrayList());

        for(int i= 1;i<n+1;i++){
            ArrayList<Integer> nbList = adjList.get(i);
            for(int nb : nbList){
                tempList.get(nb).add(i);
            }
        }
        adjList = tempList;
        // for(int i= 1;i<n+1;i++){
        //     ArrayList<Integer> nbList = adjList.get(i);
        //     outStream.print(i + " ->");
        //     for(int nb : nbList){
        //         outStream.print(nb + ",");
        //     }
        //     outStream.println();
        // }
    }
    public static int Kosaraju(){
        vis = new int[n+1];
        Arrays.fill(vis, -1);
        
        Stack<Integer> stack = new Stack();

        for(int i=1;i<n+1;i++){
            if(vis[i] == -1)
                fillStackInOrder(stack, i);
        }

        TransposeGraph();
        Arrays.fill(vis, -1);
        int count = 0;
        while(!stack.isEmpty()){
            int each = stack.pop();
            if(vis[each] == -1){
                count++;
                outStream.print(count +" SCC: ");
                DFSPrint(each);
                outStream.println();
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

            for(int i=0;i<n+1;i++)
                adjList.add(new ArrayList());
            
            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                adjList.get(u).add(v);
            }
            Kosaraju();
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}