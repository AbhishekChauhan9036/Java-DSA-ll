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

public class Diamete_BTree {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static int Diamete_BTree(BTreeNode<Integer> head){
        if(head == null)
            return 0; 
        return 1 + Math.max(Diamete_BTree(head.left), Diamete_BTree(head.right));

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
            BTreeNode<Integer> head = takeInput();
            outStream.println(1 + Diamete_BTree(head.left) + Diamete_BTree(head.right));
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}