package main.Java.ErChaShu;

public class LeetCode110 {
    /**
     * 判定是否是平衡二叉树
     * 用-1表示该树不是平衡二叉树
     * 如果该树是平衡二叉树，则返回树的高度
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1){
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) <= 1 ? 1 + Math.max(leftHeight, rightHeight) : -1;
    }
}
