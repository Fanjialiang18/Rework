package main.Java.ErChaShu;

public class LeetCode404 {
    /**
     * 左叶子之和
     * 后序遍历，根据父亲确定左孩子
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        int middle = 0;
        if (root.left !=null && root.left.left == null && root.left.right == null){
            middle = root.left.val;
        }

        return middle + left + right;
    }
}
