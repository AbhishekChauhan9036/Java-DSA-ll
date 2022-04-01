/**
Given an array having both positive and negative integers. 
The task is to compute the length of the largest subarray with sum 0.

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.

Move along the input array from starting to the end

For every index update the value of sum = sum + array[i]

Check for every index, if the current sum is present in the hash map or not

If present update the value of max_len to maximum of difference of two indices 
(current index and index in the hash-map) and max_len

Else Put the value (sum) in the hash map, with the index as a key-value pair.
 */
import java.util.*;
import java.io.*;

public class LargestSubarrayWithSumZero {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int curSum = 0;
        int maxL = 0;
        for(int i=0;i<n;i++){
            curSum += arr[i];
            
            if(curSum == 0)
                maxL = Math.max(maxL, i+1);
            if(hm.containsKey(curSum)){
                // System.out.println(i + " " + hm.get(curSum) + " "  + curSum);
                maxL = Math.max(maxL, i-hm.get(curSum));
            }else{
                hm.put(curSum, i);
            }
        }
        
        return maxL;
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int n;
            n = sc.nextInt();
            int[] ar = new int[n];
            for(int i= 0 ;i<n;i++){
                ar[i] = sc.nextInt();
            }
            
            int maxL = maxLen(ar, n);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}