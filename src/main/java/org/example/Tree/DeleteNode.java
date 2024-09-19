package org.example.Tree;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 1.首先找到需要删除的节点
 * 2.如果找到了，删除它。
 */
public class DeleteNode {
    /**
     * 有以下五种情况：
     *
     * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
     * 找到删除的节点
     * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
     * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
     * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
     * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，
     * 返回删除节点右孩子为新的根节点。
     */
    TreeNode pre;
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            //删除操作
            return delete(root);
        }
        pre = root;
        if (root.val > key) {
            root.left =  deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode delete(TreeNode root) {
        if (pre != null && pre.val > root.val) {
            if (root.right != null) {
                pre.left = root.right;
            } else {
                pre.left = root.left;
                return root.left;
            }
        } else if (pre != null && pre.val < root.val) {
            if (root.right != null) {
                pre.right = root.right;
            } else {
                pre.right = root.left;
                return root.left;
            }
        }  else if (pre == null) {
            if (root.right == null) {
                return root.left;
            }
        }
        return findLevesNode(root.right, root.left);
    }

    /**
     * 可以用while循环来做，不必单独放出来
     * @param root
     * @param addNode
     * @return
     */
    public TreeNode findLevesNode(TreeNode root, TreeNode addNode) {
        if (root == null) return null;
        if(root.left == null) {
            root.left = addNode;
            return root;
        }
        root.left = findLevesNode(root.left, addNode);
        return root;
    }
}
