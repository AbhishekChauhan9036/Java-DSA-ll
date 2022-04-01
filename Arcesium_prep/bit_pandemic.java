/**
An infinite array of 0s and 1s is given where every element is representing the city.
A city marked with 1 is infected.

The city at index 0 is always infected. 
A city with index i has value on a given day equal 
to the xor of the values for cities with index i-1 and i for the previous day.

Initially, on day 1 only city with index 0 is infected. 
Given the nth day, the task is to find the value of the 
generated binary number mod 1000000007 assuming that the 
initial city infected is the least significant bit.

Sample Input:
6
Sample Output:
51
Explanation:
100000 
110000 
101000
111100
100010
110011
Constraints:
1<=n<=1000000
 */

import java.util.*;
import java.io.*;

public class bit_pandemic {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public bit_pandemic(){

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int n = sc.nextInt();
            int a = 1;
            int mod =  (int)1e9 + 7;

            while(n --> 1){
                int b = a << 1;
                a = a ^ b;
                a = (a + mod)% mod;
                outStream.println(a);
            }

            outStream.println(a);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}