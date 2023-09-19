package main.Java.ErChaShu;

public class LeetCode538 {
    int sum = 0;
    /**
     * BST转化为累加树
     * 求有序数组的后序和，可以从后遍历然后累加求和
     * BST反中序遍历(右中左)得到的就是升序数组的从后遍历
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
}
