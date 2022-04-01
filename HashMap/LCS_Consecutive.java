/**
https://leetcode.com/problems/longest-consecutive-sequence/solution/

input : {100, 2, 1, 200, 4, 3}
output: 4
explanation : longest consecutive sequence is 1, 2, 3, 4.

//HashSet and intelligence sequence building
This optimized algorithm contains only two changes from the brute force approach:
the numbers are stored in a HashSet (or Set, in Python) to allow O(1)O(1) lookups, 
and we only attempt to build sequences from numbers that are not already part of a longer sequence.
This is accomplished by first ensuring that the number that would immediately precede the current 
number in a sequence is not present, as that number would necessarily be part of a longer sequence.


 */
import java.util.*;
import java.io.*;

public class LCS_Consecutive {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    //Sorting Method
    public int longestConsecutive_sorting(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int count =1;
        int maxCount = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] == nums[i])
                continue;
            if(nums[i] - nums[i-1] == 1){
                count++;
            }else{
                maxCount = Math.max(maxCount, count);
                count= 1;
            }
        }
        return Math.max(maxCount, count);
        
    }
    //Hashset and Intelligent Sequence building
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for(int each : nums){
            s.add(each);
        }
        Iterator<Integer> i = s.iterator();
        int count= 0;
        int maxCount = 0;
        while(i.hasNext()){
            int item = i.next();
            if(!s.contains(item-1)){
                while(s.contains(item)){
                    item++;
                    count++;
                }
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return maxCount;     
    }

    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            for(int i= 0 ;i<n;i++){
                nums[i] = sc.nextInt();
            }

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}