/**
https://www.geeksforgeeks.org/median-of-stream-of-running-integers-using-stl/
 */
import java.util.*;
import java.io.*;
class MedianFinder {
    
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;
    double med;
     /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
        big = new PriorityQueue<>(); 
        med = 0.0;
    }
    
    public void addNum(int num) {
        if(small.isEmpty()){
            med = (double)num;
            small.add(num);
        }else{
            if(small.size() > big.size()){
                if(num < small.peek()){
                    big.add(small.poll());
                    small.add(num);
                }else{
                    big.add(num);
                }
                med = ((double)small.peek() + (double)big.peek())/2;
            }else if (small.size() <= big.size()){
                if(num > big.peek()){
                    small.add(big.poll());
                    big.add(num);
                }else{
                    small.add(num);
                }
                if(small.size() == big.size())
                    med = ((double)small.peek() + (double)big.peek())/2;
                else
                    med = small.peek();
            }
        }
    }
    
    public double findMedian() {
        return med;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
public class MedianOfStream {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            MedianFinder obj = new MedianFinder();
            obj.addNum(num);
            double param_2 = obj.findMedian();

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

/**
Improved SOlution
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> a-b);
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        
        return maxHeap.peek();
    }
}
 */