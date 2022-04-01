import java.util.*;
import java.io.*;

public class subarray_sum_div_by_K {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public subarray_sum_div_by_K(){

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            int n;
            n = sc.nextInt();
            int k;
            k = sc.nextInt();
            ArrayList<Integer> ar = new ArrayList();

            for(int i=0;i<n;i++){
                int temp = sc.nextInt();
                ar.add(temp);
            }
            HashMap<Integer, Integer> count = new HashMap<>();
            int curSum = 0;
             for(int each:ar){
                 curSum += each;
                 curSum %= k;
                 curSum =  (curSum + k ) %k; // As the sum can be negative
                 count.putIfAbsent(curSum, 0);
                 count.put(curSum, count.get(curSum) + 1);
             }
            int subCount = 0;
             for (Map.Entry<Integer, Integer> each : count.entrySet()){
                 int num  = each.getValue();
                 subCount += (num * (num-1))/2;
             }
             subCount += count.get(0);

             outStream.println("Count of sub arrays is " +  subCount);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}