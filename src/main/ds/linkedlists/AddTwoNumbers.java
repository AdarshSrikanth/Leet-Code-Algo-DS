package main.ds.linkedlists;

import java.util.Scanner;

import main.Util;
import main.Util.ListNode;

public class AddTwoNumbers {
    public static void main (String[] args) {
        Scanner sc = Util.getScanner();
        int[] arr1 = Util.get_input_array(sc);
        int[] arr2 = Util.get_input_array(sc);
        ListNode result = addTwoNumbers(Util.buildListNode(arr1), Util.buildListNode(arr2));
        Util.printLinkedList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        ListNode curNode = null;
        ListNode prevNode = null;
        ListNode head = null;
        while (l1 != null && l2 != null) {
            curNode = new ListNode();
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            curNode.val = val % 10;
            l1 = l1.next;
            l2 = l2.next;
            if (prevNode != null) {
                prevNode.next = curNode;
            } else {
                head = curNode;
            }
            prevNode = curNode;
        }
        while (l1!=null) {
            curNode = new ListNode();
            int val = l1.val + carry;
            carry = val / 10;
            curNode.val = val % 10;
            prevNode.next = curNode;
            prevNode = curNode;
            l1 = l1.next;
        }
        while (l2!=null) {
            curNode = new ListNode();
            int val = l2.val + carry;
            carry = val / 10;
            curNode.val = val % 10;
            prevNode.next = curNode;
            prevNode = curNode;
            l2 = l2.next;
        }
        if (carry != 0) {
            prevNode.next = new ListNode(carry, null);
        }
        return head;
    }
}
