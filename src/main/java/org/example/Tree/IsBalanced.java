package org.example.Tree;

/**
 * 给定一个二叉树，判断它是否是
 * 平衡二叉树
 *
 */
public class IsBalanced {
    private boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag = true;
        countLevel(root);
        return flag;
    }

    public int countLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        if(Math.abs(leftLevel - rightLevel) > 1) {
            flag = false;
        }
        return Math.max(leftLevel, rightLevel) + 1;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(15);
        TreeNode c = new TreeNode(20, b,a);
        TreeNode d = new TreeNode(9);
        TreeNode root = new TreeNode(3, d, c);
        IsBalanced isBalanced = new IsBalanced();
        isBalanced.isBalanced(root);
        String res;
    }

}
