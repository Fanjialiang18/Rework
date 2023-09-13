package main.Java.ErChaShu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * 层序遍历，然后只保存最后一个节点即可
 *
 * @author clearlove3
 * @date 2023/9/13 16:41
 */
public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            while (length > 0 ){
                TreeNode cur = queue.poll();
                // 遍历到最后一个就加入
                if(length == 1){
                    res.add(cur.val);
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
                length --;
            }
        }
        return res;
    }
}
