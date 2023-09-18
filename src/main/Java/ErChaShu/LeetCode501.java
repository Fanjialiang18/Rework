package main.Java.ErChaShu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode501 {
    int count = 1;
    int maxCount = 0;
    TreeNode pre;
    List<Integer> res;

    /**
     * 寻找二叉搜索树的众数
     * 中序遍历
     */
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        res = new ArrayList<>();
        deal(root);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public void deal(TreeNode root) {
        if (root == null) {
            return;
        }
        deal(root.left);
        if(pre == null || root.val != pre.val){
            count = 1;
        }else {
            count++;
        }
        if (count == maxCount) {
            // 数目相等时直接加入列表中
            res.add(root.val);
        } else if (count > maxCount) {
            // 注意如果数目超过最大的，那么要清空列表
            res.clear();
            res.add(root.val);
            maxCount = count;
        }
        pre = root;
        deal(root.right);
    }
}

