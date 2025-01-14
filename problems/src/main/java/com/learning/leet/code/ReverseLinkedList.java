package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode next, prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return head;
        ListNode current = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = current;
            current = newNode;
            head = head.next;
        }
        return current;
    }
}
