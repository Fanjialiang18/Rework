package main.Java.TanXin;

import main.Java.ErChaShu.TreeNode;


public class LeetCode968 {
    int ans = 0;
    public int minCameraCover(TreeNode root) {
        if (traversal(root) == 0) {
            // root 无覆盖
            ans++;
        }
        return ans;
    }

    private int traversal(TreeNode root){
        /*
         * 0：该节点无覆盖
         * 1：本节点有摄像头
         * 2：本节点有覆盖
         */
        if(root == null){
            return 2;
        }
        int left  = traversal(root.left);
        int right  = traversal(root.right);
        // 孩子都有覆盖则父节点无覆盖
        if (left == 2 && right == 2){
            return 0;
        } else if (left == 0 || right == 0) {
            // 孩子至少有一个无覆盖，父节点需要放摄像头
            ans++;
            return 1;
        } else {
            // 孩子有摄像头，该节点有覆盖
            return 2;
        }
    }
}
