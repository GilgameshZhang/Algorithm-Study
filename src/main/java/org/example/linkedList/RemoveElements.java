package org.example.linkedList;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //头结点的删除只需要将头节点移到下一位即可，不需要进行指针的修改和删除
        // 为了让头结点的删除也遵循规律，加入一个虚拟头节点。
        ListNode newHead = new ListNode(-1, head);
        ListNode cur = head;
        ListNode pre = newHead;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
              pre = cur;
            }
            cur = cur.next;
        }
        //返回头节点的next
        return newHead.next;
    }
}


