package main.Java.ErChaShu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 * @author clearlove3
 * @date 2023/9/13 17:16
 */
public class LeetCode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            int max = Integer.MIN_VALUE;
            while (length > 0){
                TreeNode cur = queue.poll();
                if(cur.val > max){
                    max = cur.val;
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                length--;
            }
            res.add(max);
        }
        return res;
    }
}
