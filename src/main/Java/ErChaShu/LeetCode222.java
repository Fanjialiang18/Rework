package main.Java.ErChaShu;

public class LeetCode222 {
    /**
     * 完全二叉树的节点个数
     * 方法1：遍历
     * 方法2：针对性质
     */
    public int countNodes(TreeNode root) {
        // 方法1：遍历
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 利用完全二叉树的性质
     * 若左右子树深度相同说明是满二叉树，直接计算节点
     * 否则单独计算
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        } else {
            return countNodes2(root.left) + countNodes2(root.right) + 1;
        }
    }
}
