import java.util.*;
import java.io.*;

public class BinarySearch {
    public BinarySearch(){

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            File file = new File("../input.txt");
            PrintWriter outStream = new  PrintWriter("../output.txt");
            Scanner sc = new Scanner(file);

            //Write code here
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            while(n-- > 0){
                list.add(sc.nextInt());
            }
            Collections.sort(list);
            int found = Collections.binarySearch(list, 15, Comparator.naturalOrder());
            outStream.println("Found at : " + found);
            Collections.sort(list);
            outStream.println("Sorted array : " + list.toString());

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}