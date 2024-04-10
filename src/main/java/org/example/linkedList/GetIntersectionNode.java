package org.example.linkedList;
//给你两个单链表的头节点 headA 和 headB ，
// 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
public class GetIntersectionNode {
    //由于相交节点后部一定一样，所以其肯定在较短的列表率先遍历到，
    //所以让两个列表右端对其，长的列表指针运动到短的列表头平齐的位置开始，然后两个同时遍历找到相同的元素
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        int sizeA = 0;
        ListNode B = headB;
        int sizeB = 0;
        int sizeSub = 0;
        //计算A,B的长度
        while (A != null) {
            sizeA++;
            A = A.next;
        }
        while (B != null) {
            sizeB++;
            B = B.next;
        }
        //如果A比B短，则交换A和B，始终保证A指向的是长度长的指针
        if (sizeA < sizeB) {
            A = headB;
            B = headA;
            sizeSub = sizeB - sizeA;
        } else {
            A = headA;
            B = headB;
            sizeSub = sizeA - sizeB;
        }
        //让两个列表右端对其，长的列表从短的一样长的地方开始遍历
        for (int i = 0; i < sizeSub; i++) {
            A = A.next;
        }
        //如果A和B相同，则输出，如果不同则继续遍历
        while (A != null) {
            if (A == B) {
                break;
            } else {
                A = A.next;
                B = B.next;
            }
        }
        return A;
    }
}
