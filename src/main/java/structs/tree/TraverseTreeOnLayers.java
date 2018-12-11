package structs.tree;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node leftNode;
    Node rightNode;
    public Node(int value){
        this.value = value;
    }
}
public class TraverseTreeOnLayers {
    public void traverse(Node root){
        if (root == null) return;
        Queue queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size() != 0){
            Node ele = (Node)queue.poll();
            System.out.print(ele.value + " ");
            if(ele.leftNode != null){
                queue.offer(ele.leftNode);
            }
            if(ele.rightNode != null){
                queue.offer(ele.rightNode);
            }
        }
        System.out.println();
    }

    @Test
    public void test(){
        Node root = new Node(1);
        root.leftNode = new Node(2);
        root.rightNode = new Node(3);
        root.rightNode.leftNode = new Node(4);
        root.rightNode.rightNode = new Node(5);
        traverse(root);
    }

}
