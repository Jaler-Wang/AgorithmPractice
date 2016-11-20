package structs.tree;

import org.junit.Test;

/**
 * Created by U0148394 on 11/19/2016.
 */
public class BinaryTree {
    public static void inorderTreeWalk(Element root) {
        if (root != null) {
            inorderTreeWalk(root.left);
            System.out.print(root.key + " ");
            inorderTreeWalk(root.right);
        }
    }

    public static Element treeSearch(Element root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return treeSearch(root.left, key);
        } else {
            return treeSearch(root.right, key);
        }
    }

    public static Element min(Element root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Element max(Element root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static Element successor(Element root, int key) {
        Element element = treeSearch(root, key);
        if (element == null) return null;
        if (element.right != null) {
            return min(element.right);
        }
        Element parent = element.parent;
        while (parent != null && element == parent.right) {
            element = parent;
            parent = parent.parent;
        }
        return parent;

    }

    public static Element predecessor(Element root, int key) {
        Element element = treeSearch(root, key);
        if (element == null) return null;
        if (element.left != null) {
            return max(element.left);
        }
        Element parent = element.parent;
        while (parent != null && parent.left == element) {
            element = parent;
            parent = parent.parent;
        }
        return parent;
    }

    /*
    * find the postion current that the new data should be inserted into, then set the data's root to this postion's parent
    * */
    public static void insert(Element root, Element data) {
        Element current = root;
        Element parent = null;
        while (current != null) {
            parent = current;
            if (current.key >= data.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        data.parent = parent;
        if (parent == null) {
            root = data;
        }
        if (data.key > parent.key) {
            parent.right = data;
        } else {
            parent.left = data;
        }
    }

    public static void delete(Element root, int data) {
        Element element = treeSearch(root, data);
        if (element == null) {
            return;
        }
        if (element.left == null) {
            transplant(root, element, element.right);
        } else if (element.right == null) {
            transplant(root, element, element.left);
        } else {
            Element newOne = min(element.right);
            if(newOne.parent != element){
                transplant(root, newOne, newOne.right);
            }
            newOne.right = element.right;
            newOne.right.parent = newOne;
            transplant(root, element, newOne);
            newOne.left = element.left;
            newOne.left.parent = newOne;
        }
    }

    public static void transplant(Element root, Element oldChild, Element newChild) {
        if (oldChild.parent == null) {
            root = newChild;
        }
        if (oldChild.parent.left == oldChild) {
            oldChild.parent.left = newChild;
        } else {
            oldChild.parent.right = newChild;
        }
        if (newChild != null) {
            newChild.parent = oldChild.parent;
        }
    }

    public static void main(String[] args) {
        Element tree = getATree();
        inorderTreeWalk(tree);
        System.out.println();
        Element element = treeSearch(tree, 5);
        if (element != null) {
            System.out.println("find element " + element.key);
        }

        Element min = min(tree);
        System.out.println("min Value is " + min.key);

        Element max = max(tree);
        System.out.println("max Value is " + max.key);

        Element succesor = successor(tree, 6);
        System.out.println("successor element is " + succesor.key);

        Element predecessor = predecessor(tree, 6);
        System.out.println("predecessor element is " + predecessor.key);

        insert(tree, new Element(10));
        inorderTreeWalk(tree);
        System.out.println();

        delete(tree, 7);
        inorderTreeWalk(tree);
        System.out.println();
    }

    public static Element getATree() {
        int[] data = new int[]{6, 5, 7, 2, 5, -1, 8};
        Element root = new Element(data[0]);
        setChildren(data, 0, root);
        return root;
    }

    private static void setChildren(int[] data, int index, Element parent) {
        int leftIndex = index * 2 + 1;
        int rightIndex = leftIndex + 1;
        if (leftIndex < data.length && data[leftIndex] > 0) {
            parent.left = new Element(data[leftIndex]);
            parent.left.parent = parent;
            setChildren(data, leftIndex, parent.left);
        }
        if (rightIndex < data.length && data[rightIndex] > 0) {
            parent.right = new Element(data[rightIndex]);
            parent.right.parent = parent;
            setChildren(data, rightIndex, parent.right);
        }
    }
}
