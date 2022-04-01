import java.util.*;
import java.io.*;
//Sort an array of 0’s 1’s 2’s without using extra space or sorting algo
//https://leetcode.com/problems/sort-colors/

public class sort012 {
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static sort012(int nums[]){
        int one = 0; //end point for 1's or current pointer
        int zero = 0; //end point for 0's plus 1
        int two = nums.length-1; //end point for 2's minus 1
        while(one <= two){
            if(nums[one] == 0){
                swap(nums, one, zero);
                one++;
                zero++;
            }
            else if(nums[one] == 1)
                one++;
            else{
                swap(nums, one, two);
                two--;
                //increase only two, as one is treated as current pointer 
                //don't increase it as the value at cur pos after swap can be 0 or 1
                //if 0 it needs to be swapped which will happen in the next iteration if
                //current pointer doesnt move
                
            }
        }
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
