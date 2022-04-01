/**
Two nodes of a Binary Search Tree (BST) are swapped. Fix the BST by swapping them back without changing the structure of the tree.
Note: It is guaranteed than the given input will form a BST, except for 2 nodes that will be wrong.
https://practice.geeksforgeeks.org/contest-problem/103d7cc4d92c230eea4cfec8ae69d8aec6322800/1/
Input:
       10
     /    \
    5      8
   / \
  2   20

8 and 20 are swapped

Answer:
We can solve this in O(n) time and with a single traversal of the given BST. 
Since inorder traversal of BST is always a sorted array, 
the problem can be reduced to a problem where two elements of a sorted array are swapped.

see the bst as a sorted list after inorder traversal :  2 5 20 10 8
                                                            f  m  l

 */


import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}
public class correctBST {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;


    static Node first, last, middle, prev;
    public void correctBSTUtil(Node root){
        if(root == null)
            return;
        //Travel left
        correctBSTUtil(root.left);
        
        //Process Root
         // If this node is smaller than
        // the previous node, it's 
        // violating the BST rule.
        if(prev != null && root.data < prev.data){
            
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        
        //Travel right
        correctBSTUtil(root.right);
    }
    public Node correctBST(Node root)
    {
        first = last = middle = prev = null;
        correctBSTUtil(root);
          // Fix (or correct) the tree for not adjacent swaps
        if(first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data =temp;
        }
        // Adjacent nodes swapped
        else if(first != null && middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data =temp;
        }
        return root;
    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}