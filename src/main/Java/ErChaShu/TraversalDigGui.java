package main.Java.ErChaShu;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的递归遍历，令人感叹
 *
 * @author clearlove3
 * @date 2023/9/12 17:45
 */
public class TraversalDigGui {

    /**
     * 二叉树的遍历
     */
    public List<Integer> traversals(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        inorder(root, res);
        postorder(root, res);
        return res;
    }

    /**
     * 前序遍历：递归法
     */
    public void preorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
    /**
     * 中序遍历：递归法
     */
    public void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    /**
     * 后序遍历：递归法
     */
    public void postorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
