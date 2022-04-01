import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    Integer x;
    Integer y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Pair p){
        if(this.x - p.x == 0)
            return this.y - p.y;
        return this.x - p.x;
    }
}
class myCompare implements Comparator<Pair>{
    @Override
    public int compare(Pair a , Pair b){
        if(a.x - b.x == 0)
            return b.y - a.y;
        return b.x - a.x;
    }
}
public class SetClass {
    public SetClass(){

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            File file = new File("../input.txt");
            PrintWriter outStream = new  PrintWriter("../output.txt");
            Scanner sc = new Scanner(file);

            //Write code here
            TreeSet<Pair> myset = new TreeSet();
            myset.add(new Pair(2, 5));
            myset.add(new Pair(3, 4));
            myset.add(new Pair(1, 6));
            myset.add(new Pair(1, 9));
            myset.add(new Pair(6, 6));
            myset.add(new Pair(5, 6));

            // myset.pollFirst();
            // myset.pollLast();
            // myset.remove(new Pair(4, 6));
    
            for(Pair p : myset){
                outStream.println(p.x + " " + p.y);
            } 

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}