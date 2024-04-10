package org.example.linkedList;
//反转链表
public class ReverseList {
    /**
     * 双指针法（三指针）
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while(cur != null) {
            temp = cur.next;//临时指针保存cur.next
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        return reverse(null, head);

    }

    /**
     * 递归写法
     * @param pre
     * @param cur
     * @return
     */
    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
        return reverse(pre,cur);
    }


}
