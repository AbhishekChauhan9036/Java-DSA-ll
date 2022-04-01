/*
Concepts:
Graphs : http://homepages.math.uic.edu/~leon/cs-mcs401-s08/handouts/graphs-intro.pdf
Find largest path of a Directed Acyclic graph(DAG).
The largest path can start from any source.
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
public class GetLargestPath_DAGs {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static ArrayList<ArrayList<Pair>> adjList = new ArrayList();
    static ArrayList<Integer> dp = new ArrayList();
    public static int GetLargestPath_DAGs(int cur){
        if(dp.get(cur) != -1){
            return dp.get(cur);
        }

        dp.set(cur, 0);
        for(Pair p : adjList.get(cur)){
            int nb = p.x;
            int w = p.y;
            dp.set(cur,Math.max(dp.get(cur), GetLargestPath_DAGs(nb) + w));
        }
        return dp.get(cur);
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here

            int n = sc.nextInt();
            int m = sc.nextInt();

            //Set up
            for(int i=0;i<n+1;i++){
                adjList.add(new ArrayList());
                dp.add(-1);
            }

            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                adjList.get(u).add(new Pair(v, w));
            }
            int ans = Integer.MIN_VALUE;

            for(int i=1;i<n+1;i++)
                ans = Math.max(ans, GetLargestPath_DAGs(i));
            outStream.println("Largest Path : " + ans);


            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}