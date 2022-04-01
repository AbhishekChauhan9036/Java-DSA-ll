import java.util.*;
import java.io.*;

public class practise {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public practise(){

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            String s = new String("Durga");
            String t = s;
            s = s.concat("software");
            StringBuilder sb = new StringBuilder("Durga");
            StringBuilder tb = sb;
            sb.append("software");
            outStream.println(tb);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}