/*
https://www.geeksforgeeks.org/make-array-elements-equal-minimum-cost/
Classic Example of ternary search where we are trying to find the maximum or minimum of an
unimodal function( U -shaped function).
A ternary search determines either that the minimum or maximum cannot be in the 
first third of the domain or that it cannot be in the last third of the domain, 
then repeats on the remaining two thirds.


PROBLEM:
Given an array which contains integer values, 
we need to make all values of this array equal to some integer value 
with minimum cost where the cost of changing an array value x to y is abs(x-y). 

SOLUTION:
This problem can be solved by observing the cost while changing the target equal value,
i.e. we will see the change in cost when target equal value is changed.It can be observed that,
as we increase the target equal value the total cost decreases up to a limit and then starts increasing 
i.e. the cost graph with respect to target equal value is of U-shape and 
as cost graph is in U-shape, the ternary search can be applied to this search space and 
our goal is to get that bottom most point of the curve which will represent the smallest cost. 
We will make smallest and largest value of the array as the limit of our search space and
then we will keep skipping 1/3 part of the search space until we reach to the bottom most point of our U-curve. 
 */

import java.util.*;
import java.io.*;

public class Make_array_elements_equal {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static Integer countMinCost(ArrayList<Integer> ar,Integer n, Integer val){

        Integer cost = 0;
        for(int i=0;i<n;i++){
            cost += Math.abs(ar.get(i) - val);
        }
        return cost;

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int n;
            n = sc.nextInt();

            ArrayList<Integer> ar = new ArrayList();
            Integer minV = Integer.MAX_VALUE;
            Integer maxV = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                int temp = sc.nextInt();
                ar.add(temp);
                minV = Math.min(minV, temp);
                maxV = Math.max(maxV, temp);
            }
            Integer low = minV;
            Integer high = maxV;
            Integer ans;

            while((high - low) > 2){
                int mid1 = low + (high-low)/3; //To find first mid
                int mid2 = high - (high-low)/3; //To find second mid when search space is divided in 3 parts.

                int cost1 = countMinCost(ar, n, mid1);
                int cost2 = countMinCost(ar, n, mid2);

                if(cost1 < cost2)
                    high = mid2;
                else{
                    low = mid1;
                }
            }

            ans = countMinCost(ar, n, (low + high)/2);
            outStream.println("Min Cost is " + ans);


            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}