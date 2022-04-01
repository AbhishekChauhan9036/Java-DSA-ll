import java.util.*;
import java.io.*;

public class MergeSort {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void MergeSort(int[] arr, int start, int end){

        // if (end - start == 1 && arr[end] < arr[start]) {

        //     int temp = arr [end];
        //     arr[end] = arr[start];
        //     arr[start] = temp;
        //     return;
        // }

        outStream.println( start + " "+ end);
        if (start >= end)
            return;

        int mid = (start + end) / 2;

        MergeSort(arr, start, mid);
        MergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {

        int i = start, j = mid + 1, k = 0;
        int[] temp = new int[end - start + 1];

        while (i < mid + 1 && j < end + 1) {
            if (arr[i] > arr[j]) {
                temp[k] = arr[j];
                k++;
                j++;
            } else if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            }
        }
        while (j < end + 1) {
            temp[k] = arr[j];
            k++;
            j++; 
        }

        while (i < mid + 1) {
            temp[k] = arr[i];
            k++;
            i++; 
        }

        k = 0;
        while (k < temp.length) {
            arr[start] = temp[k];
            start++;
            k++;
        }
        
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here

            int n;
            n = sc.nextInt();
            int[] ar = new int[n];
            for(int i= 0 ;i<n;i++){
                ar[i] = sc.nextInt();
            }

            MergeSort(ar, 0, ar.length - 1);

            for(int i= 0 ;i<n;i++){
                outStream.print(ar[i]+" ");
            }

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}