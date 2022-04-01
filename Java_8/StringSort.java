import java.util.*;
import java.io.*;

public class StringSort {
    public StringSort(){

    }
    //Function to sort String
    public static String sort(String str){
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    //Main function to test
    public static void main (String[] args) throws FileNotFoundException {
        try{
            File file = new File("../input.txt");
            PrintWriter outStream = new  PrintWriter("../output.txt");
            Scanner sc = new Scanner(file);

            //Write code here
            String str = sc.next();
            str = sort(str);
            outStream.println(str);
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}