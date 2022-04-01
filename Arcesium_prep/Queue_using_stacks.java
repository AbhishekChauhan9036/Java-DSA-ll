/**
https://www.geeksforgeeks.org/queue-using-stacks/
There is another way to do this using one stack and system recursion stack.
Read that in the given link.
 */

import java.util.*;
import java.io.*;

public class Queue_using_stacks {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static Stack<Integer>stack1;
    static Stack<Integer> stack2;
    public static void enQueue(int item){
        stack1.push(item);
    }
    public static Integer deQueue(){

        /* If both stacks are empty then error */
        if(stack1.isEmpty() && stack2.isEmpty()){
            outStream.println("Queue Empty!");
            return -1;
        }
        /* Move elements from stack1 to stack 2 only if 
        stack2 is empty */
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            stack1 = new Stack();
            stack2 = new Stack();

            enQueue(1);
            enQueue(2);
            enQueue(3);
            outStream.println(deQueue());
            enQueue(5);
            enQueue(6);
            outStream.println(deQueue());
            outStream.println(deQueue());
            outStream.println(deQueue());
            outStream.println(deQueue());
            outStream.println(deQueue());

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}