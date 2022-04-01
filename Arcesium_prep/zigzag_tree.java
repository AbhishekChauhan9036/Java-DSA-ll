
import java.util.*;
import java.io.*;

class BTreeNode<T> {
    T val;
    BTreeNode<T> left;
    BTreeNode<T> right;
    BTreeNode(T val){
        this.val = val;
    }
}

public class zigzag_tree {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void print_zigzag_tree(BTreeNode<Integer> head){

        Queue<BTreeNode<Integer>> pending = new LinkedList();
        pending.add(head);
        pending.add(null);
        boolean goleft = false;
        Stack<Integer> s = new Stack();
        while(!pending.isEmpty()){
            BTreeNode<Integer> par = pending.poll();
            if(par != null){
                if(goleft)
                outStream.print(par.val + " ");
                else
                    s.push(par.val);

                if(par.left != null)
                    pending.add(par.left);
                if(par.right != null)
                    pending.add(par.right);
            }else{
                if(!pending.isEmpty())
                    pending.add(null);
                if(!goleft){
                    goleft = true;
                    while(!s.isEmpty())
                        outStream.print(s.pop() + " ");
                }else{
                    goleft = false;
                }
            }
        }
    }
    public static BTreeNode<Integer> takeInput(){
        int data = sc.nextInt();
        BTreeNode<Integer> head = new BTreeNode(data);
        Queue<BTreeNode<Integer>> pending = new LinkedList();
        pending.add(head);
        while(!pending.isEmpty()){
            BTreeNode<Integer> parent  = pending.poll();
            data = sc.nextInt();
            if(data != -1){
                BTreeNode<Integer> leftChild = new BTreeNode(data);
                parent.left = leftChild;
                pending.add(leftChild);
            }
            data = sc.nextInt();
            if(data != -1){
                BTreeNode<Integer> rightChild = new BTreeNode(data);
                parent.right = rightChild;
                pending.add(rightChild);
            }
        }
        return head;
    }

    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
             BTreeNode<Integer> head= takeInput();
             print_zigzag_tree(head);
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}