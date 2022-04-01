/**
https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
import java.util.*;
import java.io.*;

public class searchInSorted_Rotated {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public int searchInSorted_Rotated(int[] nums, int target) {
        int l= nums.length;
        int lo = 0;
        int hi = l-2;
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] > nums[mid+1]){
                ans = mid;
                break;
            }else if(nums[mid] > nums[l-1]){
                lo =mid+1;
            }else{
                hi = mid-1;
            }
        }
        if(ans == -1){
            lo = 0;
            hi = l-1;
        }else{
            if(nums[0] <= target){
                lo = 0;
                hi = ans;
            }else{
                lo = ans+1;
                hi = l-1;
            }
        }
        ans = -1;
        System.out.println(lo +" " + hi);
         while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }else if(nums[mid] > target){
                hi =mid-1;
            }else{
                lo = mid+1;
            }
        }
        return ans;    
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}


//IMPROVED SOLUTION
/**
class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
    public int search(int[] arr, int low, int high, int num) {
        if(high<low)
            return -1;
        int mid = (low+high)/2;
        if(arr[mid] == num)
            return mid;
        if(arr[low]<= arr[mid]){// Left side is sorted
            if(num>=arr[low] && num<=arr[mid]){
                return search(arr, low, mid-1, num);
            }else{
                return search(arr, mid+1, high, num);
            }
        }else{ //Right side is sorted
            if(num>=arr[mid] && num<= arr[high]){
                return search(arr, mid+1, high, num);
            }else{
                return search(arr, low, mid-1, num);
            }
        }
    }
}
 */
