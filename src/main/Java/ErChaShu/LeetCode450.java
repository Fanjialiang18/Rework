package main.Java.ErChaShu;

public class LeetCode450 {
    /**
     * 删除二叉搜索树的节点
     * 先搜索到该节点，然后删除，根据该节点的孩子情况有不同的处理
     * 1.没孩子，直接删除，返回null即可
     * 2.左右有一个孩子是null，那么返回不是null的孩子
     * 3.左右孩子都不为null，把root的left放到root的右孩子的最左孩子的left，返回right
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) {
                root = root.left;
            } else if(root.left == null){
                root = root.right;
            }else {
                TreeNode cur = root.right;
                while (cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
