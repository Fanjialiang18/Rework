package main.Java.ErChaShu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树自底向上的遍历
 * 思路有两种:
 * 1.自顶向下，然后翻转
 * 2.使用LinkedList，每次插入答案时候往头插
 *
 * @author clearlove3
 * @date 2023/9/13 16:38
 */
public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            // 把这层的都遍历
            int length = queue.size();
            while (length > 0){
                TreeNode cur = queue.poll();
                itemList.add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                length --;
            }
            res.addFirst(itemList);
        }
        return res;
    }
}
