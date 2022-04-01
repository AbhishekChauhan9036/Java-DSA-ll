/***** 
Maximum Subarray with both negative and positive values - Kadane's Algorithm
https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
Kadane's algorithm:
1.Keep a running sum
2.If sum <= 0, make sum = 0,
3. if sum is greater than max so far, update max.

The idea is to think that if a subarray sums up to something lesser than zero 
till the current pos it is not going to add any value to the coming subarray.
This it's better to not take the elements uptill now in the subarray sum calculation.

Dynamic programming:
Can be solved using dynamic programming also, but almost similar concept.
Here at every current pos we take the max of (sum_so_far + curr) or (curr) as current sum.
(So if sum_so_far goes below negative we leave that part of array)
 *****/

import java.util.*;
import java.io.*;

public class LargestSumSubarray {
    //Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }
    //Dynamic programming
    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum = Math.max(nums[i], sum+nums[i]);
            max = Math.max(max, sum);    
        
        return max;
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            File file = new File("../input.txt");
            PrintWriter outStream = new  PrintWriter("../output.txt");
            Scanner sc = new Scanner(file);

            //Write code here

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}