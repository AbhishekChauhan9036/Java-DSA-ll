/**
https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/  : This is the implementation below
Solution:

The idea is to generate all even length and odd length palindromes and keep track of the longest palindrome seen so far.

To generate odd length palindrome, 
Fix a centre and expand in both directions for longer palindromes, 
i.e. fix i (index) as center and two indices as i1 = i+1 and i2 = i-1.

For generating even length palindrome ,
Take two indices i1 = i and i2 = i-1 and compare characters at i1 and i2 and 
find the maximum length till all pair of compared characters are equal and store the maximum length.
 */
import java.util.*;
import java.io.*;

public class LongestPalindromicSubstring {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public String LongestPalindromicSubstring(String s) {
        int n = s.length();
        int start = 0;
        int maxLen = 1;
        
        for(int i=1;i<n;i++){
            
            //EVEN length palindromes
            int low = i-1;
            int hi = i;
            while(low >= 0 && hi < n && s.charAt(low) == s.charAt(hi)){
                if(hi-low+1 > maxLen){
                    maxLen = hi-low+1;
                    start = low;
                }
                low--;
                hi++;
            }
            //ODD length palindromes
            low = i-1;
            hi = i+1;
             while(low >= 0 && hi < n && s.charAt(low) == s.charAt(hi)){
                 if(hi-low+1 > maxLen){
                    maxLen = hi-low+1;
                    start = low;
                }
                low--;
                hi++;
             }
        }
        return s.substring(start, start + maxLen);
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