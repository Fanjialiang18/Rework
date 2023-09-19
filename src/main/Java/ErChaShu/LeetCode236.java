package main.Java.ErChaShu;

public class LeetCode236 {
    /**
     * 二叉树最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        // 左右找pq
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        // 后序遍历，就是自底向上
        if (left != null && right != null){
            // 如果左右都找到了，说明该节点就是祖先
            return root;
        }else if (left == null && right == null){
            return null;
        }else if (left != null){
            // 说明是从左边找到的，返回左边
            return left;
        }else {
            // 同理
            return right;
        }
    }
}
