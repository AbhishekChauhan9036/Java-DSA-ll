import java.util.*;
import java.io.*;
//https://leetcode.com/problems/find-the-duplicate-number/
/*****
Find the duplicate in an array of N+1 integers.(only one duplicate is present prooved by pigeonhole principle)
Concept:
Ex : 4 3 1 2 5 2 
First of all, where does the cycle come from? 
Let's use the function f(x) = nums[x] ...
to construct the sequence: x, nums[x], nums[nums[x]], nums[nums[nums[x]]], ....

Each new element in the sequence is an element in nums at the
index of the previous element.

Then we can use linked list cycle detection fast pointer , slow pointer concept,
Known as FLoyd's algorithm:
To compute the intersection point, 
let's note that the hare has traversed twice as many nodes as the tortoise,
i.e.2d(slow)=d(fast).
1.run fast(2 steps) and slow(1 step) and let them meet.
2.reset slow at start, leave fast at the position where both met.
3.move both slow and fast one step at a time(same speed this time) till they meet again.
4.This point is the intersection point.

Extra read:
Brent's cycle detection algorithm
https://www.geeksforgeeks.org/brents-cycle-detection-algorithm/
 *****/
public class LinkedListCycle {
    public int LinkedListCycle(int [] nums){
        int fast = nums[0];
        int slow = nums[0];
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(fast != slow);
        System.out.println(fast);
        slow = nums[0];
        while(fast!=slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
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