package main.Java.ErChaShu;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 * @author clearlove3
 * @date 2023/9/13 17:02
 */
public class LeetCode429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            List<Integer> items = new ArrayList<>();
            while (length > 0){
                Node cur = queue.poll();
                items.add(cur.val);
                for (Node child : cur.children) {
                    if(child != null){
                        queue.add(child);
                    }
                }
                length --;
            }
            res.add(items);
        }
        return res;
    }
}
