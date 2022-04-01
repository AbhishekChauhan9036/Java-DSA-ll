/**
Given a string s, find the length of the longest substring without repeating characters. 

 */
import java.util.*;
import java.io.*;

public class LongestSubstringWithoutRepeating {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public int LongestSubstringWithoutRepeating(String str){

        int n = str.length();
        int res = 0;

        int lastIndex[] = new int[256];
        Arrays.fill(lastIndex, -1);

        // Initialize start of current window
        int i=0;

        for(int j=0;j<n;j++){

            // Find the last index of s[j] 
            // Update i (starting index of current window) 
            // as maximum of current value of i and last 
            // index plus 1 
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);

            // Update result if we get a larger window 
            res = Math.max(res, j-i+1);

            // Update last index of j. 
            lastIndex[str.charAt[j]] = j;
        }

        return res;
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