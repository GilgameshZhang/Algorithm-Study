package org.example.Tree;

/**
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，
 * 将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，
 * 新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。
 * 你可以返回 任意有效的结果 。
 */
public class InsertIntoBST {
    /**
     * 只需要在叶子节点插入节点就好，不需要重新调整二叉树
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        trasvel(root, val);
        return root;
    }
    public void trasvel(TreeNode root, int val) {
        if (root.val < val && root.right == null) {
            TreeNode newNode = new TreeNode(val);
            root.right = newNode;
            return;
        }
        if (root.val > val && root.left == null) {
            TreeNode newNode = new TreeNode(val);
            root.left = newNode;
            return;
        }
        if (root.val < val) trasvel(root.right, val);
        if (root.val > val) trasvel(root.left, val);
    }
}
