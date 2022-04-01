import java.util.*;
import java.io.*;

public class Knapsack {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int n = sc.nextInt();
            int value[] = new int[n];
            int weight[] = new int[n];
            int max_wt ;

            for(int i=0;i<n;i++)
                value[i] = sc.nextInt();
            for(int i=0;i<n;i++){
                weight[i] = sc.nextInt();
                // max_wt = Math.max(weight[i], max_wt);
            }
            max_wt = sc.nextInt();

            int dp[][] = new int[n+1][max_wt+1];

            for(int i=0;i<n+1;i++)
                dp[i][0] = 0;
            for(int i=0;i<max_wt+1;i++)
                dp[0][i] = 0;

            for(int i=1;i<n+1;i++){
                for(int j=1;j<max_wt+1;j++){
                    if(j >= weight[i-1]){
                        dp[i][j] = Math.max(dp[i-1][j], value[i-1] + dp[i-1][j- weight[i-1]]);
                    }
                }
            }                
            outStream.println("Maximum value : " + dp[n][max_wt]);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}