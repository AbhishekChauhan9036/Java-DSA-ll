/***** Efficiently merging two sorted arrays with O(1) extra space *****/
/*
Concept 1 : https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/
1.Take gaps of g = n/2..then g = g/2 ..then g = g/2...
2.Compare and swap elements with gap considering two arrays as one
Time-complexity : O((n+m)*log(n+m)) 
 */
/***** Code 1 *****/
import java.util.*;
import java.io.*;

public class MergeSortInPlace {
    private static int nextGap(int gap)
    {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }
    public static void swap(int[] data){
        int temp = data[0];
        data[0] = data[1];
        data[1] = temp;
    }
    
    public static void MergeSortInPlace(int[] ar, int [] br){
        int a = ar.length;
        int b = br.length;
        int n= a + b;
        int temp;
        for(int i=nextGap(n);i>0;i = nextGap(i)){
            for(int j=0;j<n - i;j++){
                int x = j;
                int y = j+i;
                if( x < a && y < a){
                    if(ar[x] > ar[y]) {
                        temp = ar[x];
                        ar[x] = ar[y];
                        ar[y] = temp;
                    }
                }else if(x < a){
                    y -= a;
                    if(ar[x] > br[y]) {
                        temp = ar[x];
                        ar[x] = br[y];
                        br[y] = temp;
                    }
                }else{
                    x -= a;
                    y -= a;
                    if(br[x] > br[y]){
                        temp = br[x];
                        br[x] = br[y];
                        br[y] = temp;
                    }
                }
               
            }
        }
        return;
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            File file = new File("../input.txt");
            PrintWriter outStream = new  PrintWriter("../output.txt");
            Scanner sc = new Scanner(file);

            //Write code here
            int n;
            n = sc.nextInt();
            int[] ar = new int[n];
            for(int i= 0 ;i<n;i++){
                ar[i] = sc.nextInt();
            }
            int m;
            m = sc.nextInt();
            int[] br = new int[m];
            for(int i= 0 ;i<m;i++){
                br[i] = sc.nextInt();
            }
            MergeSortInPlace(ar, br);
            for(int i=0;i<n;i++)
                outStream.print(ar[i] + " ");
            outStream.println();
            for(int i = 0;i<m;i++)
                outStream.print(br[i] + " ");
            outStream.println();
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
/*
Concept 2: https://www.techiedelight.com/inplace-merge-two-sorted-arrays/

The idea is very simple. We consider each element of array  X[] 
and ignore the element if it is already in correct order 
(i.e. the element smallest among all remaining elements) else 
we swap it with smallest element which happens to be 
first element of Y[] . After swapping, we move the element (now present at Y[0])
 to its correct position in Y[0] to maintain the sorted order. 
 The merge process is almost similar to merge routine of mergeSort algorithm.

*/
/***** Code 2 *****/
class Merge
{
	// in-place merge two sorted arrays X[] and Y[]
	// invariant: X[] and Y[] are sorted at any point
	public static void merge(int[] X, int[] Y)
	{
		int m = X.length;
		int n = Y.length;

		// consider each element X[i] of array X and ignore the element
		// if it is already in correct order else swap it with next smaller
		// element which happens to be first element of Y
		for (int i = 0; i < m; i++)
		{
			// compare current element of X[] with first element of Y[]
			if (X[i] > Y[0])
			{
				// swap (X[i], Y[0])
				int temp = X[i];
				X[i] = Y[0];
				Y[0] = temp;

				int first = Y[0];

				// move Y[0] to its correct position to maintain sorted
				// order of Y[]. Note: Y[1..n-1] is already sorted
				int k;
				for (k = 1; k < n && Y[k] < first; k++) {
					Y[k - 1] = Y[k];
				}

				Y[k - 1] = first;
			}
		}
	}

		public static void main (String[] args)
	{
		int[] X = { 1, 4, 7, 8, 10 };
		int[] Y = { 2, 3, 9 };

		merge(X, Y);

		System.out.println("X: " + Arrays.toString(X));
		System.out.println("Y: " + Arrays.toString(Y));
	}
}