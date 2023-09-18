package main.Java.ErChaShu;

import java.util.HashMap;
import java.util.Map;

public class LeetCode106 {
    private Map<Integer, Integer> map;

    /**
     * 根据前序序列和后续序列来构造树
     * 后续序列的最后一个元素是子树的根，根据他切割前序数组，再根据前序数组的数目切割后续数组，递归执行即可
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 左闭右开
        return buildNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }
        // 以后序遍历最后一个节点来切割
        int index = map.get(postorder[postEnd - 1]);
        TreeNode node = new TreeNode();
        node.val = postorder[postEnd -1];
        int lenOfLeft = index - inBegin;
        node.left = buildNode(inorder, inBegin, index, postorder, postBegin,
                postBegin + lenOfLeft);
        node.right = buildNode(inorder, index + 1, inEnd, postorder,
                postBegin+lenOfLeft, postEnd - 1);
        return node;
    }
}
