package main.ds.linkedlists;

import java.util.Scanner;
import java.util.Stack;

import main.Util;
import main.Util.*;

public class ReverseList {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        ListNode head = Util.buildLinkedList(sc);
        head = reverseList(head);
        Util.printLinkedList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        Stack<ListNode> s = new Stack<>();
        while (temp.next != null) {
            s.push(temp);
            temp = temp.next;
        }
        head = temp;
        while(!s.isEmpty()) {
            temp.next = s.pop();
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
}
