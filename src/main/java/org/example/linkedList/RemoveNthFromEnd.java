package org.example.linkedList;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0,head);//定义虚拟头节点
        ListNode fast = dummyHead;//快指针指向虚拟头节点
        ListNode slow = dummyHead;//慢指针指向虚拟头节点
        //快指针先走n+1步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //当快指针指向null时，此时慢指针指向应该删除的元素的上一个节点
        //对其进行操作
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        //返回的是虚拟节点的下一个，而不是原来的头节点，因为有可能被删除的是头节点
        // 而头节点的next并没有改动，还是存在的，可能会报错
        return dummyHead.next;
    }
}
