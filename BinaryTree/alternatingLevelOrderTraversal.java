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
public class alternatingLevelOrderTraversal {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void alternatingLevelOrderTraversal(BTreeNode<Integer> root){
        Queue<BTreeNode<Integer>> pending = new LinkedList();
        pending.add(root);
        pending.add(null);
        int flag = 1;
        Stack<BTreeNode<Integer>> s = new Stack();
        while(!pending.isEmpty()){
            BTreeNode<Integer> cur = pending.poll();
            if(cur == null){
                outStream.println();
                if(pending.isEmpty()){
                    break;
                }
                if(flag == -1){
                    while(!s.isEmpty()){
                        outStream.print(s.pop().val + " ");
                    }
                    outStream.println();
                }
                flag *= -1;
                pending.add(null);
            }else{
                if(flag == 1)
                    outStream.print(cur.val + " ");
                else
                    s.push(cur);
                if(cur.left != null){
                    pending.add(cur.left);
                }
                if(cur.right != null){
                    pending.add(cur.right);
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
            alternatingLevelOrderTraversal(root);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}