package org.example.Tree;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode rightFlag = null;
        TreeNode leftFlag = null;
        if (root == null) return null;
        //充分利用二叉搜索树的特点，减少的节点数，如果节点的值比俩都大，则直接搜索该节点的左子节点
        if (root.val > p.val || root.val > q.val) {
            leftFlag = lowestCommonAncestor(root.left, p, q);
        }
        //如果节点的值比俩都小，则直接搜索该节点的右子节点
        if (root.val < p.val || root.val < q.val) {
            rightFlag = lowestCommonAncestor(root.right, p, q);
        }
        if (root == p || root == q) {
            return root;
        }
        if (leftFlag != null && rightFlag != null) return root;
        if (rightFlag != null) return rightFlag;
        return leftFlag;
    }
}
