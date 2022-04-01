/*
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

 */
import java.util.*;
import java.io.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
    static File file ;
    static PrintWriter outStream ;
    static Scanner sc;
    public static Node CloneGraph(Node node){
        HashMap <Node, Node> hmap = new HashMap();
        Node clonedNode = new Node(node.val);
        hmap.put(node, clonedNode);

        Queue<Node> queue = new LinkedList();
        queue.add(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            Node curClone = hmap.get(cur);
            for(Node nb : cur.neighbors){
                
                Node nbClone = hmap.get(nb);
                if(nbClone == null){
                    nbClone = new Node(nb.val);
                    hmap.put(nb, nbClone);
                    queue.add(nb);
                }
                curClone.neighbors.add(nbClone);
            }
        
        }
        return clonedNode;
    }   
    public static void printGraph(Node node){
        HashMap <Node, Integer> hmap = new HashMap();
        hmap.put(node, 1);

        Queue<Node> queue = new LinkedList();
        queue.add(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            outStream.print("[" + cur.val + " " + cur + "] ");
            for(Node nb : cur.neighbors){
                if(hmap.get(nb) == null){
                    queue.add(nb);
                    hmap.put(nb, 1);
                }
            }
        
        }
        outStream.println();

    }
    public static Node buildExampleGraph(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.neighbors.add(two);
        one.neighbors.add(four);

        two.neighbors.add(one);
        two.neighbors.add(three);
        two.neighbors.add(five);

        three.neighbors.add(two);
        three.neighbors.add(four);

        four.neighbors.add(five);
        four.neighbors.add(one);
        four.neighbors.add(three);

        five.neighbors.add(two);
        five.neighbors.add(four);

        return one;

    }
    public static void main (String[] args) throws FileNotFoundException {
        try{
            file = new File("../input.txt");
            outStream = new  PrintWriter("../output.txt");
            sc = new Scanner(file);

            //Write code here
            Node  node  = buildExampleGraph();
            Node clonedNode = CloneGraph(node);

            // outStream.println(node.neighbors.toString());
            // outStream.println(clonedNode.neighbors.toString());

            printGraph(node);
            printGraph(clonedNode);

            outStream.close(); //Data finally gets pushed to the text file.
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}