package org.example.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历
 */
public class PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Traversal(root, res);
        return res;
    }

    public static void Traversal(TreeNode cur, List<Integer> res){
        if (cur == null) return;
        Traversal(cur.left, res);
        Traversal(cur.right, res);
        res.add(cur.val);
    }

    public static List<Integer> postoderByStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = new TreeNode();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null && pre != cur) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if (cur.right == null && pre != stack.peek().right) {
                    stack.pop();
                    res.add(cur.val);
                    pre = cur;
                    if (stack.isEmpty()){
                        break;
                    }
                    cur = stack.peek().right;
                } else if (cur.right != null && pre == cur.right) {
                    pre = stack.pop();
                    res.add(pre.val);
                    if (stack.isEmpty()){
                        break;
                    }
                    cur = stack.peek().right;
                } else {
                    cur = cur.right;
                }
                }
            }
        return res;
    }

    public static void main(String[] args) {
        TreeNode c = new TreeNode(3);
        TreeNode b = new TreeNode(2,  c, null);
        TreeNode a = new TreeNode(1,null, b);
        postoderByStack(a);
    }
}
