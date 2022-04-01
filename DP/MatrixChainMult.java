/**
https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
40 20 10 30 10
0  1  2  3  4
The above array means 0,1 is one matrix, then 1,2 another and so on.
MatrixChainMult(int i, int j) means 
it gives the matrix multiplication from i-1 to j of the above array.
so, for eg. MatrixChainMult(1, 3) means its the multiplication of:
40x20 * 20x10 * 10x30 

Method 1 : Recursion and memoization :
place parenthesis at different places between first and last matrix, recursively calculate 
count of multiplications for each parenthesis placement and return the minimum count .
The loop k selects from where the paranthesis start which means:
if k = 2:
40 20 (10 30 10)
0  1  2  3  4
int count = MatrixChainMult(i , k)     -----> calculates the first part( 1, 2)i.e  40x20 * 20x10 
            + MatrixChainMult(k+1 , j) -----> calculates the second part( 3, 4)i.e  10x30 * 30x10 
            + ar[i-1] * ar[k] * ar[j]; -----> calculates the multiplication of matrix resulting from 
                                                both these parts.( 40x10 * 10x10)

Method 2: DP tabulation
40 20 10 30 10
0  1  2  3  4
Similar to method 1 dp[i][j] means:
it gives the matrix multiplication from i-1 to j of the above array.
so, for eg. dp[1][3] means its the multiplication of:
40x20 * 20x10 * 10x30 

 */
import java.util.*;
import java.io.*;
class Pair{
    int x;int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class MatrixChainMult {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static int n;
    static Integer[] ar;
    static ArrayList<Pair> dimensions;
    static ArrayList<Pair> dimensionsDP;
    static Integer[][] mem;
    //Method 1 : Recursion and memoization
    public static int MatrixChainMult(int i, int j){ //

        if(i == j)
            return 0;
        if(mem[i][j] != 0)
            return mem[i][j];
        int min_ans = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int count = MatrixChainMult(i , k)
                    + MatrixChainMult(k+1 , j)
                    + ar[i-1] * ar[k] * ar[j];
            
            min_ans = Math.min(min_ans, count);

        }
        //memoization
        mem[i][j] = min_ans;
        return min_ans;
    }  
    //Method 2: DP tabulation
    public static int MatrixChainMultDP(){
        int dp[][] = new int[n][n];

        // cost is zero when multiplying one matrix. 
        for(int i=0;i<n;i++)
            dp[i][i] = 0;

        for(int L = 2;L < n;L++){
            for(int i=1;i<n;i++){
                int j = i + L - 1;
                if(j >= n)
                    continue;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j] ,  dp[i][k] + dp[k+1][j] + (ar[i-1] * ar[k] * ar[j]));
                }
            }
        }
        return dp[1][n-1];

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            n = sc.nextInt();
            ar = new Integer[n];
            mem = new Integer[n][n];
            dimensions = new ArrayList<Pair>();
            dimensionsDP = new ArrayList<Pair>();
            for(Integer[] each : mem)
                Arrays.fill(each, 0);
            for(int i=0;i<n;i++){
                ar[i] = sc.nextInt();
                if(i!=0){
                    dimensions.add(new Pair(ar[i-1], ar[i]));
                }
            }
            outStream.println(MatrixChainMult(1, n-1));
            outStream.println(MatrixChainMultDP());
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}