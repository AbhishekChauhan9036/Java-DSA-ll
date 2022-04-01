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
public class postorder {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void postorder(BTreeNode<Integer> root){
        if(root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        outStream.print(root.val + " ");
    }
    public static void postorder_withoutRecursion(BTreeNode<Integer> root){
        Stack<BTreeNode<Integer>> s = new Stack();
        Stack<BTreeNode<Integer>> holdroot = new Stack();
        while(root != null){
            s.push(root);
            root = root.left;
        }
        
        while(!s.isEmpty()){
            BTreeNode<Integer> cur = s.pop();
            if(cur.right == null){
                outStream.print(cur.val +" " );
                while(!holdroot.isEmpty()){
                    BTreeNode<Integer> temp = holdroot.pop();
                    outStream.print(temp.val + " ");
                }
            }else{
                holdroot.push(cur);
                cur = cur.right;
                while(cur != null){
                    s.push(cur);
                    cur = cur.left;
                }
            }
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
            BTreeNode<Integer> root = takeInput();
            postorder_withoutRecursion(root);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}