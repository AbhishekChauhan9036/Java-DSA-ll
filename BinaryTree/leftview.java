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
public class leftview {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    static int max_h = -1;
    public static void leftview(BTreeNode<Integer> root, int h){
        if(root == null)
            return;
        if(h > max_h){
            outStream.println(root.val);
            max_h = h;
        }
        leftview(root.left, h+1);
        leftview(root.right, h+1);
            
    }

    public static void leftview_withoutRecursion(BTreeNode<Integer> root){
        //The idea is to do level order traversal of the Tree using a queue and print the first node at each level.
        Queue<BTreeNode<Integer>> pending =new LinkedList();
        pending.add(root);
        pending.add(null);
        BTreeNode<Integer> prev = null;
        while(!pending.isEmpty()){
            BTreeNode<Integer> cur= pending.poll();
            if(cur == null){
                if(!pending.isEmpty())
                    pending.add(null);

            }else{
                if(prev == null){
                outStream.println(cur.val + " ");
                }
                if(cur.left != null)
                    pending.add(cur.left);
                if(cur.right != null)
                    pending.add(cur.right);
            }
            prev = cur;
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
            leftview_withoutRecursion(root);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}