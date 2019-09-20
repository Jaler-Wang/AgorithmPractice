package leetcode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        int currentSum = root.val;
        if(root.left == null && root.right == null && currentSum == sum) return true;
        if(hasPathSum(root.left, sum - currentSum)) return true;
        if(hasPathSum(root.right, sum-currentSum)) return true;
        return false;
    }
}
