package main.Java.ErChaShu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * @author clearlove3
 * @date 2023/9/13 17:31
 */
public class LeetCode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node pre = null;
            int length = queue.size();
            Node cur;
            for (int i = 0; i < length; i++) {
                // 这一层的第一个节点
                if (i ==0){
                    pre = queue.poll();
                    cur = pre;
                }else {
                    cur = queue.poll();
                    pre.next = cur;
                    pre = cur;
                }
                if (cur.left !=null){
                    queue.add(cur.left);
                }
                if (cur.right !=null){
                    queue.add(cur.right);
                }
            }
            // 最后节点的next是null
            pre.next = null;
        }
        return root;
    }
}
