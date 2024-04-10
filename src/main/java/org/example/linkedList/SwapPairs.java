package org.example.linkedList;
//相邻两个节点两两交换
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0,head);
        ListNode cur = dummyHead;//设置虚拟头节点
        ListNode temp = null;//设置临时中间变量
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next;//临时中间变量为cur.next.next，即转换的后节点
            cur.next.next=temp.next;//先将前节点的next设置为后节点的next
            temp.next = cur.next;//将后节点的next设置为前节点、
            cur.next = temp;//将前节点的链接改为后节点
            cur = cur.next.next;//cur节点向后移动两位
        }
        return dummyHead.next;
    }
}
