package main.Java.ErChaShu;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode111 {
    /**
     * 二叉树的最小深度
     * 层序遍历，但是当孩子都为null的时候直接返回即可
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            depth++;
            while (length > 0){
                TreeNode cur = queue.poll();
                if(cur.left== null && cur.right == null){
                    return depth;
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                length--;
            }
        }
        return depth;
    }

    /**
     * 递归法
     * 与查最大的不同的是，需要进行判断，因为最大值递归总会走到最后
     * 但是最小值递归如果直接使用一个`Math.min(getMinDepth(root.left), getMinDepth(root.right))+1`语句
     * 会导致走到一个孩子节点为空就会结束，此时还没到叶子结点
     */
    public int getMinDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        if(root.left != null && root.right ==null){
            return 1+getMinDepth(root.left);
        }else if(root.right != null && root.left == null){
            return 1+getMinDepth(root.right);
        }else {
            return Math.min(getMinDepth(root.left), getMinDepth(root.right))+1;
        }
    }
}
