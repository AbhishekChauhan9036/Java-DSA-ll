import java.util.*;
import java.io.*;

public class Max_Product_Subarray {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void Max_Product_Subarray(){

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int n = sc.nextInt();
            int[] ar = new int[n+1];
            for(int i=0;i<n;i++){
                ar[i] = sc.nextInt();
            }
            int max_ending = 1;
            int min_ending = 1;
            int max_ans = 0;
            int flag = 0;
            for(int i=0;i<n;i++){
                int cur = ar[i];
                if(cur > 0) {
                    max_ending = max_ending * cur;
                    min_ending = Math.min(min_ending , min_ending * cur);
                    flag = 1;
                }else if(cur < 0){
                    int temp = max_ending;
                    max_ending = Math.max(min_ending * cur, max_ending);
                    min_ending = temp * cur;
                }else{
                    max_ending = 1;
                    min_ending = 1;
                }
                max_ans  = Math.max(max_ans, max_ending);
            }
            if(flag == 0){
                outStream.println(0);
            }else
                outStream.println(max_ans);
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}