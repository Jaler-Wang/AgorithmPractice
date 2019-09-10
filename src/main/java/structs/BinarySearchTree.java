package structs;

import link.Data;
import structs.tree.Element;

public class BinarySearchTree {
    private Element tree;

    public BinarySearchTree() {
    }

    public void insert(int value) {
        Element data = new Element(value);
        if(tree == null) {
            tree = data;
            return;
        }

        Element current = tree;
        while (current != null) {
            if(current.key >= value){
                if(current.left == null){
                    current.left = data;
                }
                else{
                    current = current.left;
                }
            }
            else{
                if(current.right == null){
                    current.right = data;
                }
                else{
                    current = current.right;
                }
            }
        }
    }
}
