package main.Java.ErChaShu;

public class LeetCode513 {
    int maxDepth = -1;
    int result = 0;
    /**
     * 找树左下角的值
     * 1.层序遍历找到最后一层的第一个值
     * 2.递归找最大深度的最左边的值
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null){
            return 0;
        }
        deal(root, 0);
        return result;
    }

    public void deal(TreeNode root, int depth){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            if (depth > maxDepth){
                maxDepth = depth;
                result = root.val;
            }
        }
        deal(root.left, depth+1);
        deal(root.right, depth+1);
    }
}
