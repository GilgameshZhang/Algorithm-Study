package org.example.Tree;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public static List<Integer> preorderByStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> nodeQueue = new Stack<>();
        nodeQueue.push(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.pop();
            if (curNode == null) {
                continue;
            } else {
                res.add(curNode.val);
            }
            nodeQueue.push(curNode.right);
            nodeQueue.push(curNode.left);
        }
        return res;
    }

    public static void traversal(TreeNode cur, List<Integer> res) {
        if (cur == null) return;
        res.add(cur.val);
        traversal(cur.left,res);
        traversal(cur.right,res);
    }

    public static void main(String[] args) {
        TreeNode c = new TreeNode(3);
        TreeNode b = new TreeNode(2,  c, null);
        TreeNode a = new TreeNode(1,null, b);
        preorderTraversal(a);
    }
}
