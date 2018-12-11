package structs.tree;

public class BinaryTree {
    private Element tree;
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
    public  void insert(Element data) {
        if(tree == null){
            tree = data;
        }
        Element current = tree;
        while(current != null){
            if(current.key > data.key){
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

    public void delete(int data) {
        Element node = tree;
        while(node != null){
            if(node.key == data){
                break;
            }
            if(node.key < data){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
        if(node == null) return;

        if(node.left != null && node.right != null){
            Element next = node.right;
            while(next.left != null){
                next = next.left;
            }
            node.key = next.key;
            node.color = next.color;
            node = next;
        }

        Element child = null;
        if(node.left != null){
            child = node.left;
        }
        else{
            child = node.right;
        }

        if(node.parent == null){
            tree = child;
        }
        if(node.parent.left == node){
            node.parent.left = child;
        }
        else{
            node.parent.right = child;
        }

    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.tree = getATree();
        Element tree = binaryTree.tree;
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

        binaryTree.insert(new Element(10));
        inorderTreeWalk(tree);
        System.out.println();

        binaryTree.delete(7);
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
