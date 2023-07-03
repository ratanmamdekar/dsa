package com.dsa.linkedlist;

import static com.dsa.linkedlist.LinkedListUtil.*;

public class DeleteTheMiddleNodeLinkedList {
    public static void main(String[] args) {
       ListNode head = getLinkedList();
       printLinkedList(head);

       ListNode listNode = deleteMiddleRight(head);
       printLinkedList(listNode);

        head = getLinkedList();
        listNode = deleteMiddleLeft(head);
        printLinkedList(listNode);
    }

    public static ListNode deleteMiddleRight(ListNode head) {
        if(head.next==null)
            return null;

        ListNode slow = new ListNode(-1,head);
        ListNode fast = new ListNode(-1,head);

        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        slow.next= slow.next.next;

        return head;
    }

    public static ListNode deleteMiddleLeft(ListNode head) {
        if(head.next==null)
            return null;

        ListNode slow = new ListNode(-1,head);
        ListNode fast = new ListNode(-1,head);

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next= slow.next.next;

        return head;
    }
}
