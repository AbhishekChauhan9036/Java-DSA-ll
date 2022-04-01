import java.util.*;
import java.io.*;
class BTreeNode<T> {
    T val;
    BTreeNode<T> left;
    BTreeNode<T> right;
    //Horizontal Distance
    int hd;
    BTreeNode(T val){
        this.val = val;
    }
}
public class bottomview {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void bottomview(BTreeNode<Integer> root){
        TreeMap<Integer, BTreeNode<Integer>> tmap = new TreeMap();
        Queue<BTreeNode<Integer>> q = new LinkedList();

        root.hd = 0;
        q.add(root);

        while(!q.isEmpty()){
            BTreeNode<Integer> cur = q.poll();
            tmap.put(cur.hd, cur);
            if(cur.left != null){
                cur.left.hd = cur.hd - 1;
                 q.add(cur.left);
            }
            if(cur.right != null){
                cur.right.hd = cur.hd + 1;
                q.add(cur.right);
            }
        }

        for(Map.Entry<Integer, BTreeNode<Integer>> each : tmap.entrySet()){
            outStream.print(each.getValue().val + " ");
        }
        return;
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
            bottomview(root);
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}