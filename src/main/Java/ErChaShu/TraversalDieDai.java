package main.Java.ErChaShu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树迭代遍历
 *
 * @author clearlove3
 * @date 2023/9/13 13:50
 */
public class TraversalDieDai {

    /**
     * 前序迭代遍历
     */
    public List<Integer> preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * 二叉树中序迭代遍历
     */
    public List<Integer> inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 先左到叶子节点
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; //左
            } else {
                cur = stack.pop();
                res.add(cur.val); //中
                cur = cur.right; //右
            }
        }
        return res;
    }

    /**
     * 二叉树后序迭代遍历1：根据前序遍历修改得出
     * 前序为中左右，修改为中右左，反转一下就成了左右中
     */
    public List<Integer> postorder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val); //中
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        // 反转
        Collections.reverse(res);
        return res;
    }

    /**
     * 二叉树后序迭代遍历2：传统方法
     * 借用pre指针确定是从左孩子返回的根还是右孩子返回的根
     * 左孩子返回的话继续遍历右孩子，否则可以访问根的值
     */
    public List<Integer> postorder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 遍历左子树
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            // 如果右孩子为空或者右孩子已经遍历过直接访问
            if (cur.right == null || pre == cur.right) {
                res.add(cur.val);
                stack.pop();
                pre = cur;
                cur = null; //后序遍历访问根时说明该子树已经遍历完毕，直接置为null即可
            } else {
                cur = cur.right;
            }
        }
        return res;
    }

    /**
     * 层序遍历:迭代法(BFS)
     * 借助队列，FIFO，符合层序遍历的顺序
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
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
            res.add(itemList);
        }
        return res;
    }
    public List<List<Integer>> resultList = new ArrayList<>();

    /**
     * 层序遍历:递归法(DFS)
     */
    public List<List<Integer>> levelOrder2(TreeNode root){
        level(root, 0);
        return resultList;
    }

    public void level(TreeNode root, int deep){
        if (root == null){
            return;
        }
        deep++;
        if (resultList.size() < deep){
            // 层级增加时，结果集增加一个list，利用list的索引值来判断层级
            List<Integer> items = new ArrayList<>();
            resultList.add(items);
        }
        resultList.get(deep - 1).add(root.val);

        level(root.left, deep);
        level(root.right, deep);
    }
}
