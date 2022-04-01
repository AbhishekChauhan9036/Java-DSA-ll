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
public class inorder {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void inorder_WithoutRecursion(BTreeNode<Integer> head){
        Stack<BTreeNode<Integer>> s = new Stack();

        while(head != null){
            s.push(head);
            head = head.left;
        }
        while(!s.isEmpty()){
           BTreeNode<Integer> node = s.pop();
           outStream.println(node.val + " ");
           if(node.right != null){
               node = node.right;
               while(node != null){
                   s.push(node);
                   node = node.left;
               }
           }    
        }
    }
    public static void inorder(BTreeNode<Integer> head){
        if(head == null)
            return;
        inorder(head.left);
        outStream.print(head.val + " ");
        inorder(head.right);
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
            inorder_WithoutRecursion(head);


            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}