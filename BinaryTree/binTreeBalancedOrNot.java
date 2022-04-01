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
public class binTreeBalancedOrNot {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static boolean isbalanced = true;
    public static Integer binTreeBalancedOrNot(BTreeNode<Integer> root){
        if(root == null)
            return 0;
        int l = binTreeBalancedOrNot(root.left);
        int r = binTreeBalancedOrNot(root.right);
        if(Math.abs(l-r) > 1){
            isbalanced = false;
        }
        return Math.max(l , r) + 1;
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
            BTreeNode<Integer> root = takeInput();
            binTreeBalancedOrNot(root);
            outStream.println(isbalanced);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}