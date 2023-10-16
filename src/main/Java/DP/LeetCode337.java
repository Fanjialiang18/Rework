package main.Java.DP;

import main.Java.ErChaShu.TreeNode;

/**
 * @author clearlove3
 * @date 2023/10/16 15:48
 */
public class LeetCode337 {
    public int rob(TreeNode root) {
        // 两种情况，拿不拿该结点
        // res[0]表示拿该层节点，res[1]表示不拿该层节点
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode root){
        int[] res = new int[2];
        if(root == null){
            return res;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        // 偷该节点
        res[1] = root.val + left[0] + right[0];
        // 不偷该节点
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }
}
