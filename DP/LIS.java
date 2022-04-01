/**
LIS_normal : https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
Time complexity : O(N^2)

LIS_advanced : https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/?ref=rp
https://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
Time complexity : O(NLogN)
 */
import java.util.*;
import java.io.*;

public class LIS {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static int n;
    static int[] ar;
    static int[] count;
    static int[] parent;
    static LinkedList<Integer> list;


    //Time complexity : O(N^2)
    public static void LIS_Normal(){
        parent[0] = 0;
        for(int i=1;i<n;i++){
            int cur = ar[i];
            parent[i] = i;
            for(int j=0;j<i;j++){
                if(ar[j] < cur){
                    if(count[j] + 1 >  count[i]){
                        parent[i] = j;
                        count[i] = count[j] +1;
                    }
                }
                
            }
        }
        int max_count = 1;
        int max_pos = 0;
        for(int i = 0;i<n;i++){
            if(max_count < count[i]){
                max_pos = i;
                max_count = count[i];
            }
        }
        outStream.println("Lis count : " + max_count);
        // do{
        //     outStream.print(ar[max_pos] + " ");
        //     max_pos = parent[max_pos];
        // }while(max_pos != parent[max_pos]);
        // outStream.print(ar[max_pos]);   
    }
    //Time complexity : O(NLog(N))
    public static int binSearch(int cur_val){
        int l = 0, h = list.size() -1;
        int pos = -1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(list.get(mid) < cur_val){
                pos = mid;
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return pos;
    } 
    public static void LIS_Advanced(){
        list = new LinkedList();
        list.add(ar[0]);
        int len = 1;
        for(int i=1;i<n;i++){
            int cur = ar[i];
            if(cur > list.peekLast()){
                list.add(cur);
                len++;
            }else if(cur < list.peekFirst()){
                list.set(0, cur);
            }else{
                int pos = binSearch(cur);
                // outStream.println("current : " + cur + " pos : " + pos);
                list.set(pos+1, cur);
            }   
        }
        // for(int i=0;i<list.size();i++){
        //     outStream.print(list.get(i) + " ");
        // }
        outStream.println();
        outStream.println("Lis count for advanced : " + len);
    }

    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            n = sc.nextInt();
            ar = new int[n+1];
            for(int i=0;i<n;i++){
                ar[i] = sc.nextInt();
            }
            
            count = new int[n];
            Arrays.fill(count, 1);
            
            parent = new int[n];
            Arrays.fill(parent, -1);
            
            LIS_Normal();
            LIS_Advanced();
            
            outStream.println();
            // outStream.println("Length of LIS : " + count[n-1]);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}