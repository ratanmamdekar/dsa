package com.dsa.linkedlist;

import static com.dsa.linkedlist.LinkedListUtil.*;

public class DeleteANodeExceptLast {
    public static void main(String[] args) {
        ListNode head = getLinkedList();
        printLinkedList(head);

        deleteNode(head.next.next);
        printLinkedList(head);
    }

    static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
