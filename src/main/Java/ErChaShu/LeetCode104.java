package main.Java.ErChaShu;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode104 {
    /**
     * 二叉树的最大深度
     * 层序遍历即可
     * 递归或者迭代
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 0;
        while (!queue.isEmpty()){
            deep++;
            int length = queue.size();
            while (length > 0){
                TreeNode cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                length--;
            }
        }
        return deep;
    }

    public int getDepth(TreeNode root, int depth){
        if (root == null){
            return depth;
        }
        int left = getDepth(root.left, depth + 1);
        int right = getDepth(root.right, depth + 1);
        return Math.max(left, right);
    }
}
