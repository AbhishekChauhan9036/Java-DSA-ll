import java.util.*;
import java.io.*;

public class shares_reduce_double {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static int dp[] = new int[100000];
    public static int helper(int current, int wanted, int day){
        if(day > 50)
            return 0;
        if(dp[current] > 0)
            return dp[current];
        outStream.println(current + " ");
        if(current == 1)
            dp[current] = day;
        else if(current == wanted)
            dp[current] = day;
        else if(current > wanted)
            dp[current] = current - wanted + day;
        else{
            int ans2 = helper(current*2, wanted, day+1);
            int ans1 = helper(current-1, wanted, day+1);
            
            dp[current] = Math.min(ans1, ans2);
        }
        return dp[current];
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            outStream.println(helper(16, 24, 0));
            
            
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}