package org.example.Tree;

import java.util.Stack;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class GetMinimumDifference {

    TreeNode max;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    public void traversal(TreeNode root) {
        if(root.left != null) traversal(root.left);
        if (max != null && root.val - max.val < min) {
            min = root.val - max.val;
        }
        max = root;
        if(root.right != null) traversal(root.right);
    }

    /**
     * 统一迭代法
     * @param root
     * @return
     */
    public int getMinDifference(TreeNode root) {
        int minimun = Integer.MAX_VALUE;
        TreeNode pre = null;
        if (root == null) return 0;
        Stack<TreeNode> que = new Stack<>();
        que.push(root);
        while(!que.isEmpty()) {
            TreeNode temp = que.pop();
            if (temp != null) {
                if (temp.right != null) que.push(temp.right);
                que.push(temp);
                que.push(null);
                if (temp.left != null) que.push(temp.left);
            } else {
                temp = que.pop();
                if (pre != null && temp.val - pre.val < minimun) {
                    minimun = temp.val - pre.val;
                }
                pre = root;
            }
        }
        return minimun;
    }
}
