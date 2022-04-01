import java.util.*;
import java.io.*;

public class CleanUp{
    public static void main (String[] args){
        File folder = new File("/Users/mac/Documents/Web-development/java_competitive/");
        File fList[] = folder.listFiles();
        Arrays.stream(fList).forEach( f -> {
            if(f.isDirectory() == true){
                    // System.out.println(f.listFiles());
                    Arrays.stream(f.listFiles()).forEach ( f_n -> {
                        if(f_n.getName().endsWith(".class")) f_n.delete();
                    });

            }else{
                if(f.getName().endsWith(".class")) f.delete();
            }
        });
    }
}