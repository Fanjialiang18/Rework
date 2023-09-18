package main.Java.ErChaShu;

import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {

    private Map<Integer, Integer> map;

    /**
     * 从前序与中序遍历序列构造二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 左闭右开
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode build(int[] preorder, int preBegin, int preEnd, int[] inorder,
                          int inBegin, int inEnd){
        if(preBegin >= preEnd || inBegin >= inEnd){
            return null;
        }
        // 确定子树根节点在中序数组中的位置
        int index = map.get(preorder[preBegin]);
        TreeNode root = new TreeNode();
        root.val = preorder[preBegin];
        // 确定左右子树节点数目，进行切割
        int lenOfLeft  = index - inBegin;
        root.left = build(preorder, preBegin + 1, preBegin + 1 +lenOfLeft,
                inorder, inBegin, index);
        root.right = build(preorder, preBegin + lenOfLeft + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
