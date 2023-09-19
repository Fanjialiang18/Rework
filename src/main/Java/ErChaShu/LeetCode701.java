package main.Java.ErChaShu;

public class LeetCode701 {
    /**
     * 二叉搜索树插入节点
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode();
            root.val = val;
            return root;
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
