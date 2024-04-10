package org.example.linkedList;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {//注意判断条件，一定要fast和fast.next不为null，不然当传入空链表时会产生空指针异常
            //快指针一次走两步，慢指针一次走一步
            fast = fast.next.next;
            slow = slow.next;
            //当两个指针相遇时，则说明有环
            if (fast == slow) {
                //假设无环的距离为x，从入口走到相交处y，相交处到入口为z
                //则slow走过x+y
                //而fast走过x+y+n(y+z)
                //而fast速度时slow的两倍，所以fast走过2*(x+y),也就是2*(x+y)=x+y+n*(y+z)
                //x=(n-1)*(y+z)+z，当n=1时
                //也就是x=z，所以当相遇的时候再用两个指针同时从head和相交的地方出发，会和即可找到入口。
                //当n>1时，此时从相交的地方的指针会在环内转n-1次后与来自head的指针相遇，还是能找到入口
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
