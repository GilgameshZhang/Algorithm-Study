package org.example.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public static void traversal(TreeNode cur, List<Integer> res){
        if (cur == null) return;
        traversal(cur.left, res);
        res.add(cur.val);
        traversal(cur.right, res);

    }

    public static List<Integer> inorderTraversalByStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur == null) {
                stack.pop();
                if (stack.isEmpty())continue;
                TreeNode t = stack.pop();
                res.add(t.val);
                stack.push(t.right);
            } else {
                stack.push(cur.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode c = new TreeNode(3);
        TreeNode b = new TreeNode(2,  c, null);
        TreeNode a = new TreeNode(1,null, b);
        inorderTraversalByStack(a);
    }
}
