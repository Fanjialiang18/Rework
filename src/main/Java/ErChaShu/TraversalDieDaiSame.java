package main.Java.ErChaShu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 二叉树迭代的统一风格写法
 * 采用`标记法`，要访问的和要处理的节点都放在栈里
 * 不过要处理的节点放入栈之后，紧接着放入一个空指针作为标记
 *
 * @author clearlove3
 * @date 2023/9/13 14:44
 */
public class TraversalDieDaiSame {

    /**
     * 前序遍历:中左右，入栈则右左中
     */
    public List<Integer> preorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur != null){
                // 前序遍历时入栈需要是右左
                if(cur.right != null){
                    stack.push(cur.right);
                }
                if(cur.left != null){
                    stack.push(cur.left);
                }
                // 访问过中节点，但是还没处理，增加一个空节点作为标记
                stack.push(cur);
                stack.push(null);
            }else {
                // 处理该节点
                cur = stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }

    /**
     * 中序遍历:左中右，入栈则右中左
     */
    public List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            // 入栈顺序右左中
            if (cur != null){
                if (cur.right != null){
                    stack.push(cur.right);
                }
                stack.push(cur);
                stack.push(null);
                if (cur.left != null){
                    stack.push(cur.left);
                }
            }else {
                // 处理该节点
                cur = stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }

    /**
     * 后序遍历:左右中，入栈则中右左
     */
    public List<Integer> postorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur != null){
                stack.push(cur);
                stack.push(null);
                if(cur.right != null){
                    stack.push(cur.right);
                }
                if(cur.left != null){
                    stack.push(cur.left);
                }
            }else {
                cur = stack.pop();
                res.add(cur.val);
            }
        }
        return res;
    }
}
