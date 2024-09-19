package org.example.Tree;

import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class isValidBST {
    public boolean isValidBST1(TreeNode root) {
        long A = Long.MIN_VALUE;
        long B = Long.MAX_VALUE;
        long[] bound = {A, B};
        return calBst(root, bound);
    }

    /**
     * 每个节点都有其对应的上下界，对于该节点的左子树更新上界，对该节点的右子树更新下界（分支定界法）
     * @param root
     * @param bound
     * @return
     */
    public boolean calBst(TreeNode root, long[] bound) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        boolean leftFlag = true;
        boolean rightFlag = true;
        //更新左子树边界的最大值
        if (root.left != null) {
            long[] newLeftBound = new long[2];
            newLeftBound[0] = bound[0];
            newLeftBound[1] = root.val;
            if (newLeftBound[0] < root.left.val && newLeftBound[1] > root.left.val) {
                leftFlag = calBst(root.left, newLeftBound);
            } else {
                return false;
            }
        }
        if (root.right != null) {
            long[] newRightBound = new long[2];
            newRightBound[0] = root.val;
            newRightBound[1] = bound[1];
            if (newRightBound[0] < root.right.val && root.right.val < newRightBound[1]) {
                rightFlag = calBst(root.right, newRightBound);
            } else {
                return false;
            }
        }
        return leftFlag && rightFlag;

    }

    TreeNode max;
    /**
     * 搜索树的中序遍历是递增的序列
     */
    public boolean isValidBST(TreeNode root) {
        //递归
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left) return false;
        //max记录了root的左子树的最大值
        if (max != null && max.val >= root.val) {
            return false;
        }
        max = root;
        return isValidBST(root.right);
    }

    public boolean isValidBst2(TreeNode root) {
        //迭代
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                //右节点不为空进栈
                if (temp.right != null) stack.push(temp.right);
                //中节点再次进栈
                stack.push(temp);
                stack.push(null);
                //右节点不为空进栈
                if (temp.left != null) stack.push(temp.left);
            } else {
                //对中节点进行操作
                stack.pop();
                TreeNode pop = stack.pop();
                if (max != null && max.val >= pop.val) {
                    return false;
                } else {
                    max = pop;
                }
            }
        }
        return true;
    }

}
