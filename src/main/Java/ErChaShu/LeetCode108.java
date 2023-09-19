package main.Java.ErChaShu;

public class LeetCode108 {
    /**
     * 将有序数组转化为平衡二叉搜索树
     * 循环切割数组进行构建即可，从中间切割就可以保证平衡
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 左闭右开
        return buildTree(nums, 0, nums.length);
    }

    public TreeNode buildTree(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        TreeNode root = new TreeNode();
        int index = begin + (end - begin)/2;
        root.val = nums[index];
        root.left = buildTree(nums, begin, index);
        root.right = buildTree(nums, index + 1, end);
        return root;
    }
}
