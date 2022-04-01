/**
https://www.geeksforgeeks.org/word-ladder-set-2-bi-directional-bfs/
 */

import java.util.*;
import java.io.*;

public class Bidirectional_BFS {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static int n, m;
    static ArrayList<ArrayList<Integer>> adjList;

    public static int Bidirectional_BFS(int src, int target){

        int dist_src[] = new int[n+1];
        int dist_target[] = new int[n+1];
        Arrays.fill(dist_src, -1);
        Arrays.fill(dist_target, -1);
        dist_src[src] = 0;
        dist_target[target] = 0;
        
        Queue<Integer> src_queue = new LinkedList();
        Queue<Integer> target_queue = new LinkedList();

        src_queue.add(src);
        target_queue.add(target);

        int len = -1;

        while(!src_queue.isEmpty() && !target_queue.isEmpty()){
            int src_cur = src_queue.poll();
            int target_cur = target_queue.poll();

            for(Integer child : adjList.get(src_cur)){
                if(dist_src[child] == -1){
                    dist_src[child] = dist_src[src_cur] + 1;
                    src_queue.add(child);
                }
                if(dist_target[child] != -1){
                    outStream.println("Meeting in the middle : " + src_cur + " " + child);
                    len = dist_src[src_cur] + dist_target[child] + 1;
                    break;
                }
                if(child == target){
                    len = dist_src[src_cur] + 1;
                    break;
                }
            }
            if(len != -1) break;

            for(Integer child : adjList.get(target_cur)){
                if(dist_target[child] == -1){
                    dist_target[child] = dist_target[target_cur] + 1;
                    target_queue.add(child);
                }
                if(dist_src[child] != -1){
                    outStream.println("Meeting in the middle : " + child + " " + target_cur);
                    len = dist_src[child] + dist_target[target_cur] + 1;
                    break;
                }
                if(child == src){
                    len = dist_target[target_cur] + 1;
                    break;
                }
            }

            if(len != -1) break;

        }
        return len == -1 ? dist_src[target] : len;
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
            for(int i=0;i<n+1;i++){
                adjList.add(new ArrayList());
            }

            for(int i=0;i<m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            outStream.println("Length : " + Bidirectional_BFS(1, 10));

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}