package com.dsa.linkedlist;

public class LinkedListUtil {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public static ListNode getLinkedList(){
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(3);

        return head;
     }

     public static void printLinkedList(ListNode node){
        if (node==null){
            System.out.println("Empty linked list");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("head");
        while(node!=null){
            sb.append("->");
            sb.append(node.val);
            node=node.next;
        }
         System.out.println(sb);
     }
}
