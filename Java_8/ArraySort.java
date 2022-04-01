import java.util.*;
import java.io.*;
import java.util.stream.*; 
class myCompInteger implements Comparator<Integer>{
    public int compare(Integer a , Integer b){
        return a.compareTo(b);
    }
}
public class ArraySort {
    public ArraySort(){

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            File file = new File("../input.txt");
            PrintWriter outStream = new  PrintWriter("../output.txt");
            Scanner sc = new Scanner(file);

            //Write code here
            int n = sc.nextInt();
            int ar[] = new int[n];
            ArrayList<Integer> arList = new ArrayList();
            for(int i=0;i<n;i++){
                ar[i] = sc.nextInt();
                arList.add(ar[i]);
            }

            int[] data = {2,1,3,4,5,6,7,8,10,9};

            /***** Primitive arrays --> Non-primitive arrays/ArrayLists ( i.e. String, Integer, Float, Double etc..) *****/ 
            //https://stackoverflow.com/questions/880581/how-to-convert-int-to-integer-in-java
            // To boxed array
            Integer[] boxedAr1 = Arrays.stream( data ).boxed().toArray( Integer[]::new );
            Integer[] boxedAr2 = IntStream.of( data ).boxed().toArray( Integer[]::new );

            /***** Primitive arrays --> Non-primitive list *****/
            // To boxed list
            List<Integer> boxedList1  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
            List<Integer> boxedList2 = IntStream.of( data ).boxed().collect( Collectors.toList() );

            /***** Non-primitive Arrays/ArrayLists to primitve arrays *****/
            //Boxed array(Integer[]) --> unboxed array(int[]) //https://stackoverflow.com/questions/31394715/how-to-convert-integer-to-int-array-in-java
            int[] intArray1 = Arrays.stream(boxedAr1).mapToInt(Integer::intValue).toArray();
            //Boxed list --> unboxed array(int[]) //https://www.techiedelight.com/convert-list-integer-array-int/
            int[] intArray2 = boxedList1.stream().mapToInt(Integer::intValue).toArray();

            
            /***** print boxed array and boxed list of int[] data *****/
            outStream.println("Integer Arrays : " + Arrays.toString(boxedAr1));
            outStream.println("Integer List : " + boxedList1.toString());

            /***** print unboxed arrays *****/
            outStream.println("int[] array : " + Arrays.toString(intArray1));
            outStream.println("int[] array : " + Arrays.toString(intArray2));
            

            /***** Convert ArrayList<Integer> --> Integer[] Array(Non primitive type arrays i.e. String, Integer, etc..) *****/
            // Integer[] arr = arList.toArray(new Integer[0]);  
            Integer[] arr = arList.toArray(Integer[]::new); //both ways are possible

            /***** Convert Boxed Array(Not primitive type arrays i.e. String, Integer, etc..) --> ArrayList/List *****/
            List<Integer> list = Arrays.asList(arr); //Arrays.asList returns a fixed or unmodifiable list
            //list.add(10); //gives java.lang.UnsupportedOperationException
            list = new ArrayList<Integer>(Arrays.asList(arr));// modifiable list
            list.add(10); //No error
            arList = new ArrayList<Integer>(Arrays.asList(arr));

            /***** Using Integer[] values as int *****/
            int x = arr[0].intValue();    //This is called unboxing

            /***** Sorting Integer[] in increasing(normal) order using comparator *****/
            // Arrays.sort(ar, new myCompInteger());

            /***** Sorting Integer[] decreasing(reverse) order using comparator *****/
            // Arrays.sort(ar, Collections.reverseOrder(new myCompInteger()));
            
            
            /***** Sorting ArrayList in increasing(normal) order(use of comparator is necessary) *****/
            // arList.sort(new myCompInteger());
            //as use of comparator is necessary, Java 8 has Comparator.naturalOrder() which you can use as default comparator.
            // arList.sort(Comparator.naturalOrder()); 

            /***** Sorting ArrayList in decreasing(reverse) order(use of comparator is necessary) *****/
            // arList.sort(Collections.reverseOrder(new myCompInteger()));


            /***** Print array *****/
            for(int i=0;i<n;i++){
                outStream.print(arr[i] + " ");
            }
            outStream.println();

            /***** Print arrayList *****/
            outStream.println(arList.toString());

            /***** Print list *****/
            outStream.println(list.toString());
            
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}