package org.example.linkedList;

/**
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 * 实现 MyLinkedList 类：
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 */
public class MyLinkedList {
    int size;

    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public MyLinkedList(int size, ListNode head) {
        this.size = size;
        this.head = head;
    }

    //获取链表中下标为 index 的节点的值。index从0开始，如果下标无效，则返回 -1 。
    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        } else {
            ListNode cur = head;//cur是目前的虚拟头节点
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }
    }

    //void addAtHead(int val)
    // 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    //void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
    // 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
    void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    //void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
    void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
            ListNode cur = head.next;
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
        }

    public static void main(String[] args) {
/*        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList.toString());
        myLinkedList.addAtTail(3);
        System.out.println(myLinkedList.toString());
        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList.toString());// 链表变为 1->2->3
        System.out.println(myLinkedList.get(1) );            // 返回 2
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.toString());// 现在，链表变为 1->3
        System.out.println(myLinkedList.get(1));              // 返回 3*/
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 10);
        System.out.println(myLinkedList.get(0));
        myLinkedList.addAtIndex(0, 20);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtIndex(1, 30);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1)); // 返回 2
    }
}
