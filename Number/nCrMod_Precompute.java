/*
A efficient approach will be to reduce the better approach to an efficient one by precomputing the inverse of factorials. 
Precompute inverse of factorial in O(n) time and then quereies can be answered in O(1) time.
Inverse of 1 to N natural number can be computed in O(n) time using Modular multiplicative inverse.
Using recursive definition of factorial, the following can be written:

n! = n * (n-1) !
taking inverse on both side 
inverse( n! ) = inverse( n ) * inverse( (n-1)! )

Since N’s maximum value is 10^6, precomputing values till 10^6 will do.

https://www.geeksforgeeks.org/modular-multiplicative-inverse-1-n/
 */

 import java.util.*;
 import java.io.*;
 
 public class nCrMod_Precompute {
     static File file ;
     static PrintWriter outStream ;
     static Scanner sc;

     static int N = 1000001;  
 
    // Array to precompute inverse of 1! to N! 
    static long[] factorialNumInverse = new long[N + 1]; 
    
    // Array to store inverse of 1 to N 
    static long[] naturalNumInverse = new long[N + 1];
    
    // Array to store factorial of first N numbers 
    static long[] fact = new long[N + 1]; 

    //here prime is mod = 10^9 + 7
    public static void InverseofNumber(int prime){
        naturalNumInverse[0] = naturalNumInverse[1] = 1;

        for(int i=2;i<=N;i++){
            naturalNumInverse[i] = (naturalNumInverse[prime%i] * 
                                    (long)(prime - prime/i) % prime);
        }
    }

    public static void InverseofFactorial(int mod){
        factorialNumInverse[0] = factorialNumInverse[1] = 1;
        for(int i=2;i<=N;i++){
            factorialNumInverse[i] = (factorialNumInverse[i - 1] * naturalNumInverse[i]) % mod;
        }
    }

    public static void factorial(int mod){
        fact[0] = 1;
        
        for(int i=1;i<=N;i++){
            fact[i] = fact[i-1] * (long)i % mod;
        }

    }

    // Function to return nCr % mod in O(1) time 
    public static long Binomial(int N, int R, int mod) 
    { 
        
        // n C r = n!*inverse(r!)*inverse((n-r)!) 
        long ans = ((fact[N] * factorialNumInverse[R]) % 
                        p * factorialNumInverse[N - R]) % mod; 
        
        return ans; 
    }

     public nCrMod_Precompute(){
     }
     public static void main (String[] args) throws FileNotFoundException {
         try{
             file = new File("../input.txt");
             outStream = new  PrintWriter("../output.txt");
             sc = new Scanner(file);
 
             //Write code here

            //  outStream.println(x + " " + y);
 
             outStream.close(); //Data finally gets pushed to the text file.
         }catch(FileNotFoundException e){
             e.printStackTrace();
         }
     }
 }