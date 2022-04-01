import java.util.*;
import java.io.*;
//https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
public class oneRepeatOneMiss {
    public static int oneRepeatOneMiss(int[] nums){
        
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            File file = new File("../input.txt");
            PrintWriter outStream = new  PrintWriter("../output.txt");
            Scanner sc = new Scanner(file);

            //Write code here
            int n;
            n = sc.nextInt();
            int[] ar = new int[n];
            for(int i = 0;i<n;i++){
                ar[i] = sc.nextInt();
            }


            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}