package org.example.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 */
public class MergeTrees {
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        //当两个节点其中一个为空时，直接把另一个节点对应的子树变成新的子树
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        //均不为空时，进行逻辑处理
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees1(t1.left, t2.left);
        t1.right = mergeTrees1(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTree2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(t1);
        que.offer(t2);
        while (!que.isEmpty()) {
            TreeNode temp1 = que.poll();
            TreeNode temp2 = que.poll();
            temp1.val = temp1.val + temp2.val;
            if (temp1.left != null && temp2.left != null) {
                que.offer(temp1.left);
                que.offer(temp2.left);
            } else if (temp2.left != null) {
                temp1.left = temp2.left;
            }
            if (temp1.right != null && temp2.right != null) {
                que.offer(temp1.right);
                que.offer(temp2.right);
            } else if (temp2.right != null) {
                temp1.right = temp2.right;
            }
        }
        return t1;
    }
}
