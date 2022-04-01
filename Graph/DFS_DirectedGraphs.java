import java.util.*;
import java.io.*;

public class DFS_DirectedGraphs {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList();
    static ArrayList<Integer> vis = new ArrayList();
    static int[] vis_time;
    static int tim = 0;
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;

    public static void DFS_DirectedGraphs(int cur){
        vis.set(cur, 1);
        tim++;
        vis_time[cur] = tim;
        // outStream.println("Current : " + cur);
        for(int nb : adjList.get(cur)){
            if(vis.get(nb) == 0 ){ 
                // The node is not visited at all
                outStream.println("Tree Edge : " + cur + "--->" + nb);
                DFS_DirectedGraphs(nb);
            }
            else if(vis.get(nb) == 1){
                //The node is still in recursion/path stack 
                outStream.println("Back Edge : " + cur + "--->" + nb);
            }
            else if(vis_time[nb] > vis_time[cur]){
                //Cur node is already visited before nb node but not in recursion  which means it's a forward edge
                outStream.println("Forward Edge : " + cur + "--->" + nb);
            }
            else{
                //Cur node is not visited before nb and not in recursion stack also
                outStream.println("Cross Edge : " + cur + "--->" + nb);
            }
        }
        vis.set(cur, 2);
        // vis[]

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
                vis.add(0);
            }
            vis_time = new int[n+1];

            
            
            for(int i=1;i<n+1;i++){
                if(vis.get(i)== 0)
                    DFS_DirectedGraphs(i);
            }
            
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

/**
class Solution {
    HashMap<String, Integer> hmap;
    public int helper(int a, int b, int c){
        if(a ==0 && b == 0 && c== 0)
           return 0;
        if( a <0 || b<0 || c <0)
            return -1;
        String key = a + "-" + b + "-" + c;
        if(hmap.containsKey(key))
            return hmap.get(key);
        
        int ar[] = new int[3];
        ar[0] = helper(a-1, b-1, c);
        ar[1] = helper(a-1, b , c-1);
        ar[2] = helper(a, b-1, c-1);
        
        int max = -1;
        for(int i=0;i<3;i++){
            max = Math.max(max, ar[i]);
        }
        if(max == -1){
            hmap.put(key, max);
            return max;
        }
        hmap.put(key, max+1);
        return max+1;
    }
    public int maximumScore(int a, int b, int c) {
       hmap = new HashMap();
        return helper(a, b, c);
        
    }
}


class Solution {
    
    public int maximumScore(int a, int b, int c) {
        int ar[] = new int[3];
        ar[0] = a;
        ar[1] = b;
        ar[2] = c;
        Arrays.sort(ar);
        int cnt  = Math.min(ar[1], ar[2]);
        ar[1] = ar[1]- cnt + 1;
        ar[2] = ar[2] - cnt + 1;
        int points = cnt -1;
        Arrays.sort(ar);
        if(ar[1] == ar[2])
            points += ar[1];
        else {
            points += ar[0] + ar[1];
        }
        return points;
    }
}



import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {

    	//Write code here
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);
        System.out.println(t);
        for(int i=2;i*i <1001;i++){
            if(isPrime[i]){
                for(int j = i*i; j<= 1001;j+=i){
                    isPrime[j] = false;
                } 
            }
        } 
        System.out.println(t);
        while(t-->0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int min = 2000000;
            int max = -1;
            for(int i=l;i<=r;i++){
                if(isPrime[i]){
                    min = Math.min(min, i);
                    max = Math.max(max, i);
                }
            }
            if(max == -1)
                System.out.println(-1);
            else
                System.out.println(max - min);
        }
   }
}
 */