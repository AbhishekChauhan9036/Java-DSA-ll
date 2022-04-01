/*
Check whether a undirected unweighted graph is bipartite or not.
All acyclic graphs are bipartite. 
A cyclic graph is bipartite iff all its cycles are of even length.
 */
 import java.util.*;
 import java.io.*;
 
 public class Bipartite {
     static File file ;
     static PrintWriter outStream ;
     static Scanner sc;
     static int n, m;
     static ArrayList<ArrayList<Integer>> adjList;
     static int color[];
     public static boolean Bipartite(){
        Queue<Integer> q = new LinkedList();
        q.add(1);
        color[1] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int nb : adjList.get(cur)){
                if(color[nb] == -1){
                    q.add(nb);
                    if(color[cur] == 1)
                        color[nb] = 2;
                    else
                        color[nb] = 1;
                }
                else{
                    if(color[nb] == color[cur])
                        return false;
                }
            }
        }
        return true;
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
            
             color = new int[n+1];
             Arrays.fill(color, -1);
             for(int i=0;i<n+1;i++)
                adjList.add(new ArrayList());
            
            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
            
            if(Bipartite())
                outStream.println("Graph is bipartite!");
            else
                outStream.println("Graph is not bipartite!");

             outStream.close(); //Data finally gets pushed to the text file.
         }catch(FileNotFoundException e){
             e.printStackTrace();
         }
     }
 }