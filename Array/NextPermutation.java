/**

Given an array perm[] of size N denoting a number.
Find its next permutation. ie- rearrange the digits into the lexicographically next greater permutation.
If such arrangement is not possible, it must be rearranged as the lowest possible order ie,
sorted in an ascending order.

Input:
N = 6
perm[] = {1, 2, 3, 6, 5, 4}
Output: 1 2 4 3 5 6
Explanation: 124356 > 123654 and is the 
lexicographically next permutation.

Step 1: Find the largest index k, such that perm[k]<perm[k+1]

Step 2: Find the largest index l, such that perm[l]>perm[k].

Step 3: Swap perm[k] and perm[l].

Step 4: Reverse from perm[k+1] to the end.
 */

import java.util.*;
import java.io.*;

public class NextPermutation {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public void nextPermutation(int perm[], int N)
	{    
	    int i = N - 2;
        //find the first dip in value from right to left(this is K)
        while (i >= 0 && perm[i + 1] <= perm[i]) {
            i--;
        }
        if (i >= 0) {
            //If dip is present find the value just greater than K in the right part of array(this is L)
            int j = N - 1;
            while (j >= 0 && perm[j] <= perm[i]) {
                j--;
            }
            //Swap perm[k] and perm[l]
            int temp = perm[i];
            perm[i]=perm[j];
            perm[j]=temp;
        }
        i++;
        int end = N-1;
        //Reverse from perm[k+1] to the end.
        while(i<end)
        {  
            int temp = perm[i];
            perm[i]=perm[end];
            perm[end]=temp;
            i++;end--;
            
        }
        
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