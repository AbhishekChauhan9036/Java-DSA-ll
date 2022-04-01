/**
https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
RECURSION SOLUTION:
Complexity Analysis: 
The above solution may try all subsets of given set in worst case. 
Therefore time complexity of the above solution is exponential. 
The problem is in-fact NP-Complete (There is no known polynomial time solution for this problem).

DYNAMIC PROGRAMMING:
Does it in Pseudo-polynomial time.
boolean dp
 */

import java.util.*;
import java.io.*;

public class subset_sum {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static boolean subset_sum(ArrayList<Integer> ar, Integer start, Integer n, Integer sum){
        if(sum < 0)
            return false;
        if(start == n && sum == 0)
            return true;
        if(start == n)
            return false;
        int val = ar.get(start);
        return subset_sum(ar, start+1, n, sum-val) || subset_sum(ar, start+1, n, sum);
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int n, sum;
            n = sc.nextInt();
            sum = sc.nextInt();

            ArrayList<Integer> ar = new ArrayList();

            for(int i=0;i<n;i++){
                int temp = sc.nextInt();
                ar.add(temp);
            }
            outStream.println(subset_sum(ar, 0, n, sum));
            

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}