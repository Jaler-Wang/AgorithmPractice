package useful.leetcode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * Solution:
 * it should be the longest in the left subtree or the right subtree
 * or leftLength + rigthLength + 1
 */
public class DiameterOfBT {
    private int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        treeLength(root);
        return Math.max(0, longest - 1);
    }

    private int treeLength(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLength = treeLength(root.left);
        int rightLength = treeLength(root.right);
        longest = Math.max(leftLength + rightLength + 1, longest);
        return Math.max(leftLength, rightLength) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
