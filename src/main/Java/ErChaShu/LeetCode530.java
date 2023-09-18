package main.Java.ErChaShu;

public class LeetCode530 {
    TreeNode pre;
    int min = Integer.MAX_VALUE;
    /**
     * 二叉搜索树的最小绝对值之差
     * 只需要比较根节点和左右孩子节点即可，跨层的绝对值差会更大(错误思路
     * 中序递归得到的是有序数组，那么只要相邻比较即可
     */
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        findMinDif(root);
        return min;
    }

    public void findMinDif(TreeNode root){
        if(root == null){
            return;
        }
        findMinDif(root.left);
        if (pre != null){
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        findMinDif(root.right);
    }
}
