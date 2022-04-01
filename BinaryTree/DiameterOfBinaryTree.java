/**
The diameter of a tree can be defined as the maximum distance between two leaf nodes.
Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.

Note for solution:
only comparing right and left height isn't enough, 
a subtree can have the two leaf nodes with max distance making it the diameter
 */

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

class ans{
    int height;
    int diameter;
    public ans(int h, int d){
        height = h;
        diameter = d;
    }
}
public class DiameterOfBinaryTree {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static ans DiameterOfBinaryTree(BTreeNode<Integer> root){
        if(root == null){
            return new ans(0, 0);
        }
        ans left = DiameterOfBinaryTree(root.left);
        ans right = DiameterOfBinaryTree(root.right);
        ans toReturn = new ans(Math.max(left.height, right.height)+1, Math.max((left.height + right.height  + 1), Math.max(left.diameter, right.diameter)));
        return toReturn;
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
            ans res = DiameterOfBinaryTree(root);
            outStream.println(res.diameter);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}