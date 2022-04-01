import java.util.*;
import java.io.*;
class BTreeNode<T> {
    T val;
    BTreeNode<T> left;
    BTreeNode<T> right;
    int hd;
    BTreeNode(T val){
        this.val = val;
    }
}
public class topview {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static void topview(BTreeNode<Integer> root){
        // TreeMap<Integer, BTreeNode<Integer>> tmap = new TreeMap(
        //     new Comparator<Map.Entry<Integer, BTreeNode<Integer>>>(){
        //         public int compare(Map.Entry<Integer, BTreeNode<Integer>> a, Map.Entry<Integer, BTreeNode<Integer>> b){
        //             return a.getKey() -b.getKey();
        //         }
        //     }
        // );
        TreeMap<Integer, BTreeNode<Integer>> tmap = new TreeMap(
            new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                    return b -a;
                }
            }
        );
        Queue<BTreeNode<Integer>> pending = new LinkedList();
        root.hd = 0;
        pending.add(root);
        while(!pending.isEmpty()){
            BTreeNode<Integer> cur = pending.poll();
            tmap.putIfAbsent(cur.hd, cur);

            if(cur.left != null){
                cur.left.hd = cur.hd - 1;
                pending.add(cur.left);
            }
            if(cur.right != null){
                cur.right.hd = cur.hd +1;
                pending.add(cur.right);
            }
        }

        for(Map.Entry<Integer, BTreeNode<Integer>> each : tmap.entrySet()){
            outStream.print(each.getValue().val + " ");
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
            topview(root);
            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}