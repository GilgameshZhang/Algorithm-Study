package org.example.Tree;

/**
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树不应该改变保留在树中的元素的相对结构 (即如果没有被移除，原有的父代子代关系都应当保留)。
 * 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。
 * 注意，根节点可能会根据给定的边界发生改变。
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        //当root<low root的左子树不要，用符合条件的右子树代替root
        if (root.val < low) {
            root = trimBST(root.right, low, high);
        //当root>high root的右子树不要，用符合条件的左子树代替Root
        } else if (root.val > high) {
            root = trimBST(root.left, low, high);
        }
        if(root != null) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
}
