package main.Java.ErChaShu;

import java.util.ArrayList;
import java.util.List;

public class LeetCode13 {
    /**
     * 二叉树的所有路径
     * 递归法，前序遍历+回溯
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<String> path = new ArrayList<>();
        findPaths(root, res, path);
        return res;
    }

    public void findPaths(TreeNode root, List<String> res, List<String> path) {
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            String resPath = String.join("->", path);
            res.add(resPath);
        }
        if (root.left != null) {
            findPaths(root.left, res, path);
            // 回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            findPaths(root.right, res, path);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
