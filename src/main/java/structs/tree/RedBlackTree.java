package structs.tree;

/**
 * Created by U0148394 on 11/19/2016.
 */
public class RedBlackTree {
    public void leftRotate(Tree tree, Element node) {
        Element newNode = node.right;
        node.right = newNode.left;
        if (newNode.left != null) {
            newNode.parent = node;
        }
        newNode.parent = node.parent;

        if (node.parent == null) {
            tree.root = newNode;
        } else if (node == node.parent.left) {
            node.parent.left = newNode;
        } else {
            node.parent.right = newNode;
        }

        newNode.left = node;
        node.parent = newNode;
    }

    public void rightRotate(Tree tree, Element node) {
        Element newNode = node.left;

        node.left = newNode.right;
        if (newNode.right != null) {
            newNode.parent = node;
        }

        newNode.parent = node.parent;

        if (node.parent == null) {
            tree.root = newNode;
        } else if (node == node.parent.left) {
            node.parent.left = newNode;
        } else {
            node.parent.right = newNode;
        }

        newNode.right = node;
        node.parent = newNode;
    }

    public void rbInsert(Tree tree, Element data) {
        Element parent = null;
        Element location = tree.root;
        while (location != null) {
            parent = location;
            if (location.key >= data.key) {
                location = location.left;
            } else {
                location = location.right;
            }
        }
        data.parent = parent;
        if (parent == null) {
            tree.root = data;
        } else {
            if (parent.key >= data.key) {
                parent.left = data;
            } else {
                parent.right = data;
            }
        }
        data.color = "red";
        rbInsertFixUp(tree, data);
    }

    private void rbInsertFixUp(Tree tree, Element data) {
        while (data.parent.color.equalsIgnoreCase("red")) {
            if (data.parent == data.parent.parent.left) {
                Element uncle = data.parent.parent.right;
                if (uncle.color.equalsIgnoreCase("red")) {
                    data.parent.color = "black";
                    uncle.color = "black";
                    data.parent.parent.color = "red";
                    data = data.parent.parent;
                } else {
                    if (data == data.parent.right) {
                        data = data.parent;
                        leftRotate(tree, data);
                    }
                    data.parent.color = "black";
                    data.parent.parent.color = "red";
                    rightRotate(tree, data.parent.parent);
                }
            }
            else{
                Element uncle = data.parent.parent.left;
                if(uncle.color.equalsIgnoreCase("red")){
                    data.parent.color = "black";
                    data.parent.parent.color = "red";
                    uncle.color = "black";
                } else{
                    if(data == data.parent.left){
                        data = data.parent;
                        rightRotate(tree, data);
                    }
                    data.parent.color = "black";
                    data.parent.parent.color = "red";
                    leftRotate(tree, data.parent.parent);
                }
            }
        }
    }
}
