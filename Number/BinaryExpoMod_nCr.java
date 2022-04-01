/**
We know the formula for  nCr 
nCr = fact(n) / (fact(r) x fact(n-r)) 
Here fact() means factorial.

 nCr % mod = (fac[n]* modIverse(fac[r]) % mod * modIverse(fac[n-r]) % mod) % mod;
Here modIverse() means modular inverse under
modulo p.
According to this nCr can also be written as (n!/(r!*(n-r)!) ) % mod
which is equivalent to (n!*inverse(r!)*inverse((n-r)!) ) % mod.

So, precomputing factorial of numbers from 1 to n will allow queries
to be answered in O(log n). The only calculation that needs to be done is calculating
inverse of r! and (n-r)!. Hence overall complexity will be q*( log(n)) .



More efficient approach:
https://www.geeksforgeeks.org/queries-of-ncrp-in-o1-time-complexity/
 */
import java.util.*;
import java.io.*;

public class BinaryExpoMod {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public BinaryExpoMod(){

    }
    //Binary power function
    long power(long x, long y, long mod)  
    {  
        //Initial result and mod x
        long res = 1l;     
        x = x % mod;   

        //base case
        if (x == 0) return 0; 
        

        while (y > 0)  
        {  
            // If y is odd, multiply res
            // with x
            if (y %2 == 1)  
                res = (res*x) % mod;  
            
            //now treating y as even
            //divide by 2
            y = y>>1; 

            //square x
            x = (x*x) % mod;  
        }  
        return res;  
    }  
    //Find Mod Inverse (1/n) % mod
    public long modInverse(long n)
    {
        long mod = 1000000007;
        return powM(n, mod - 2);
    }

    public int nCrMod(int n, int r)
    {
 
        if (n<r) 
          return 0;
        
      // Base case
        if (r == 0 || n==r)
            return 1;
 
        // Fill factorial array so that we
        // can find all factorial of r, n
        // and n-r
        //This part should go in global section
        int[] fac = new int[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % mod;


        return (fac[n] * modInverse(fac[r])
                % mod * modInverse(fac[n - r])
                % mod) % mod;
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