package org.example.Tree;

import java.util.ArrayList;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数
 * （即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 */
public class FindMode {
    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;
    ArrayList<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        trasvel(root);
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public void trasvel (TreeNode root) {
        if (root.left != null) trasvel(root.left);
        if (pre == null || pre.val != root.val) {
            count = 1;
        } else {
            count++;
        }
        if (count == maxCount) {
            res.add(root.val);
        } else if (count > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = count;
        }
        pre = root;
        if (root.right != null) trasvel(root.right);
    }
}
