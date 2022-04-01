/**
Basic : 
To find gcd of 2 numbers
Time Complexity: O(Log min(a, b))  


Extended Euclidean Algorithm: 

Extended Euclidean algorithm also finds integer coefficients x and y such that: 
ax + by = gcd(a, b)

Now,
Let us put b = prime, we get
  ax + prime * y = gcd(a, prime)

We know gcd(a, prime) = 1 because
one of the numbers is prime. So we
know
  ax + prime * y = 1

Since prime * y is a multiple of prime,
x is modular multiplicative inverse of a.

ax  ≡ 1 (mod prime) 

Since x is modular multiplicative inverse of a.
We can use extended euclid to find the modular multiplicative inverse of a.

The extended Euclidean algorithm updates results of gcd(a, b) using the results calculated by
recursive call gcd(b%a, a). Let values of x and y calculated by the recursive call be
xprev and yprev. x and y are updated using below expressions.

x = yprev - ⌊prime/a⌋ * xprev
y = xprev

We use above relation to compute inverse using previously computed values.

inverse(a) = (inverse(prime % a) * (prime - prime/a)) % prime

https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/
 */

import java.util.*;
import java.io.*;

public class EuclidAlgorithm {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public EuclidAlgorithm(){

    }
    //Basic Euclid 
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;         
        return gcd(b%a, a);
    }

    // extended Euclidean Algorithm
    public static int gcdExtended(int a, int b, int x[])
    {
        // Base Case
		if (a == 0)
		{
			x[0] = 0;
			x[1] = 1;
			return b;
		}

		int[] t = {1,1}; // To store results of recursive call
		int gcd = gcdExtended(b%a, a,t);

		// Update t using results of recursive
		// call
		
		x[0] = t[1] - (b/a) * t[0];
		x[1] = t[0];
		
		

		return gcd;
    }
    // extended Euclidean Algorithm DP
    // Function to calculate modular 
    // inverse from 1 to n w.r.t a big prime number using D.P 
    static void modularInverse(int n, int prime) 
    { 
        int dp[]=new int[n + 1]; 
        dp[0] = dp[1] = 1; 
        for (int i = 2; i <= n; i++)  
            dp[i] = dp[prime % i] *  
                (prime - prime / i) % prime;  
      
        for (int i = 1; i <= n; i++)  
            System.out.print(dp[i] + " ");  
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int ar[] = new int[2];
            int a = 35, b = 15;
            int g = gcdExtended(a, b, ar);
            System.out.println("gcd(" + a +  " , " + b+ ") = " + g);
            System.out.println(ar[0] +" "+ ar[1]);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}