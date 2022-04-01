/**
Maximum Sum Increasing Subsequence
 */
import java.util.*;
import java.io.*;

public class MaxSumIncSeq {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static int[] ar;
    static int n;
    static int sum[];
    static int parent[];
    public static int MaxSumIncSeq(){
        for(int i=0;i<n;i++){
            int cur = ar[i];
            for(int j=0;j<i;j++){
                if(ar[j] < cur){
                    if(sum[j] + cur > sum[i]){
                        sum[i] = sum[j] + cur;
                        parent[i] = j;
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        int max_pos = -1;
        for(int i=0;i<n;i++){
            if(sum[i] > ans){
                ans = sum[i];
                max_pos = i;
            }
            // ans = Math.max(sum[i], ans);
            // outStream.print(sum[i] + " ");
        }
        while(parent[max_pos] != max_pos){
            outStream.print(ar[max_pos] + " ");
            max_pos = parent[max_pos];
        }
        outStream.print(ar[max_pos]);
        outStream.println();
            
        return ans;
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            n = sc.nextInt();
            ar = new int[n+1];
            sum = new int[n];
            parent = new int[n];
            
            for(int i=0;i<n;i++){
                ar[i] = sc.nextInt();
                sum[i] = ar[i];
                parent[i] = i;
            }
            
            int sum = MaxSumIncSeq();
            outStream.println("Maximum Increasing sub sequence : " + sum);
            
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}