package main.Java.ErChaShu;

public class LeetCode226 {
    /**
     * 翻转二叉树
     * 递归，任何一种遍历方式都行，翻转孩子节点即可
     * 层序遍历也可以
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
