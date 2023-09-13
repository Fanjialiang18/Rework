package main.Java.ErChaShu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 *
 * @author clearlove3
 * @date 2023/9/13 16:52
 */
public class LeetCode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            double average = 0;
            int count = queue.size();
            int length = queue.size();
            while (length > 0){
                TreeNode cur = queue.poll();
                average += cur.val;
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                length --;
            }
            res.add(average/count);
        }
        return res;
    }
}
