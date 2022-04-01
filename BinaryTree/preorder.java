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
public class preorder {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void preorder(BTreeNode<Integer> root){
        if(root == null)
            return;
        outStream.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void preorder_withoutRecursion(BTreeNode<Integer> root){
        
        Stack<BTreeNode<Integer>> s = new Stack();
        s.push(root);
        while(!s.isEmpty()){
            BTreeNode<Integer> cur = s.pop();
            outStream.print(cur.val + " ");
            if(cur.right != null)
                s.push(cur.right);
            if(cur.left != null)
                s.push(cur.left);
            
        }
    }

    public static BTreeNode<Integer> takeInput(){
        BTreeNode<Integer> head;
        int rootData = sc.nextInt();
        head = new BTreeNode<Integer>(rootData);
        Queue<BTreeNode<Integer>> pending = new LinkedList();
        pending.add(head);
        while(!pending.isEmpty()){
            BTreeNode<Integer> current = pending.poll();
            int data = sc.nextInt();
            if(data != -1){
                BTreeNode<Integer> leftChild = new BTreeNode<Integer>(data);
                current.left = leftChild;
                pending.add(leftChild);
            }
            data = sc.nextInt();
            if(data != -1){
                BTreeNode<Integer> rightChild = new BTreeNode<Integer>(data);
                current.right = rightChild;
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
            preorder_withoutRecursion(head);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}