/**
Sort according to start time.
 */

import java.util.*;
import java.io.*;

public class merge_overlap_interval {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public merge_overlap_interval(){

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