package main.Java.ErChaShu;

public class LeetCode654 {
    /**
     * 最大二叉树
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    public TreeNode build(int[] nums, int begin, int end){
        if(begin >= end){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxOfIndex = -1;
        for (int i = begin; i < end; i++) {
            if(nums[i] > max){
                max = nums[i];
                maxOfIndex = i;
            }
        }
        TreeNode root = new TreeNode();
        root.val = max;
        root.left = build(nums, begin, maxOfIndex);
        root.right = build(nums, maxOfIndex + 1, end);
        return root;
    }
}
