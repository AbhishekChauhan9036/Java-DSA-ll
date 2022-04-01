/**
https://leetcode.com/problems/two-sum/
Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, 
and you may not use the same element twice.
You can return the answer in any order.
 */
import java.util.*;
import java.io.*;

public class TwoSum {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;

    //ONe pass hash table solution
    public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
    }
    //Solution when the array is already sorted
    public int[] twoSumWithSortedArray(int[] numbers, int target) {
  
        int i=0;
        int j = numbers.length-1;
        while(i<j){

            if(numbers[i] * 2 > target) {
                //Since array is sorted, if the lowest value * 2 is greater than target, 
                //any value greater than lowest added to it will also be greater than target
                 break; 
            }
               

            if(numbers[i] + numbers[j] == target){
                return new int[]{i+1, j+1};
            }else if(numbers[i] + numbers[j] > target){
                j--;
            }else{
                i++;
            }
        }
        return null;
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
            int target = sc.nextInt();
            int[] ans = twoSum(ar, target);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}