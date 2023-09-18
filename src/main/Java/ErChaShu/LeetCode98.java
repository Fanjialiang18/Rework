package main.Java.ErChaShu;

public class LeetCode98 {
    TreeNode pre;
    /**
     * 验证二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        if (!isValidBST(root.left)) {
            return false;
        }
        // 中
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        // 右
        return isValidBST(root.right);
    }
}