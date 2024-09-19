package org.example.Tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */

public class SortedArrayToBST {
    public TreeNode sortenArrayToBST(int[] nums) {
        return travelsal(nums, 0, nums.length);

    }
    //左开右闭
    public TreeNode travelsal(int[] sum, int left, int right) {
        if (left >= right) return null;
        if (left == right - 1) {
            return new TreeNode(sum[left]);
        } else {
            int mid = left + ((right - left) / 2);
            TreeNode treeNode = new TreeNode(sum[mid]);
            treeNode.left = travelsal(sum, left, mid);
            treeNode.right = travelsal(sum, mid + 1, right);
            return treeNode;
        }
    }
}
