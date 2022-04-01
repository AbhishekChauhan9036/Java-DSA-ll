import java.util.*;
import java.io.*;

public class EditDistance {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void EditDistance(){

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            String str1 = sc.next();
            String str2 = sc.next();
            
            int l1 = str1.length();
            int l2 = str2.length();

            int dp[][] = new int[l1+1][l2+1];

            for(int i=0;i<l1+1;i++)
                dp[i][0] = i;
            for(int i=0;i<l2+1;i++)
                dp[0][i] = i;
            
            for(int i=1;i<l1+1;i++){
                for(int j=1;j<l2+1;j++){
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    }
                }
            }
            outStream.println("Minimum edit distance : " + dp[l1][l2]);
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}