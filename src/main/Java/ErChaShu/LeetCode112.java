package main.Java.ErChaShu;

public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return deal(root, targetSum);
    }

    public boolean deal(TreeNode root, int target) {
        if (root.left == null && root.right == null) {
            return 0 == target - root.val;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = deal(root.left, target - root.val);
        }
        if (root.right != null) {
            right = deal(root.right, target - root.val);
        }
        return left || right;
    }
}
