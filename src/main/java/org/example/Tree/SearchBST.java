package org.example.Tree;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。
 * 如果节点不存在，则返回 null 。
 */
public class SearchBST {
    /**
     * 二叉搜索树的特点，左<中<右
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.val < val) {
            return searchBST1(root.right, val);
        } else {
            return searchBST1(root.left, val);
        }
    }
}
