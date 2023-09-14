package main.Java.ErChaShu;

import java.util.List;

public class LeetCode559 {
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

    /**
     * N叉树的最大深度
     */
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        if(root.children != null){
            for (Node child : root.children){
                depth = Math.max(depth, maxDepth(child));
            }
        }
        return 1+depth;
    }
}
