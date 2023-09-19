package main.Java.ErChaShu;

public class LeetCode235 {
    /**
     * 二叉搜索树的最近公共祖先
     * pq的公共祖先的值一定在pq之间
     * 递归查找即可，迭代也行
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if (root.val > p.val && root.val >q.val){
            return lowestCommonAncestor(root.left, p ,q);
        }else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p ,q);
        }else {
            return root;
        }
    }
}
