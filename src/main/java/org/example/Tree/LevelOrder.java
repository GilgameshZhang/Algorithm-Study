package org.example.Tree;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> tempQueue = new LinkedList<>();
        List<List<Integer>> solution = new ArrayList<>();
        tempQueue.offer(root);
        while (!tempQueue.isEmpty()) {
            int size = tempQueue.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = tempQueue.poll();
                    res.add(poll.val);
                    if (poll.left != null) {
                        tempQueue.offer(poll.left);
                    }
                    if (poll.right != null) {
                    tempQueue.offer(poll.right);
                }
            }
            solution.add(res);
        }
        return solution;
    }
}
