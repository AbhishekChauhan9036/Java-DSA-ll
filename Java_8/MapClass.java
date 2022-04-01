import java.util.*;
import java.io.*;

public class MapClass {
    public MapClass(){

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            File file = new File("../input.txt");
            PrintWriter outStream = new  PrintWriter("../output.txt");
            Scanner sc = new Scanner(file);

            //Write code here
            final Map<String, Integer> mp = new HashMap<>();
            mp.put("Akash", 1);
            mp.put("Sam", 2);
            mp.put("Sidd", 3);
            mp.put("Brishti", 4);
            mp.put("Akash", 0);//Allowed (Because final marks the reference, not the object.)

            Set<Map.Entry<String, Integer>> s = mp.entrySet();
            Set<String> sKey = mp.keySet();
            Collection<Integer> cValue = mp.values();

            // mp = new HashMap<>(); Not allowed as it's final.

            outStream.println(s.toString());
            outStream.println(sKey.toString());
            outStream.println(cValue.toString());

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}