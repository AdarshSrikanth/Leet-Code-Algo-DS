package main.ds.linkedlists;

import java.util.Scanner;

import main.Util;
import main.Util.ListNode;

public class DeleteNthElement {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        ListNode list = Util.buildLinkedList(sc);
        System.out.println("Enter the position of the node from the tail to be deleted:");
        int del = Integer.parseInt(sc.next());
        Util.printLinkedList(removeNthFromEnd(list, del));
    }

    /*
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list
     * 
     * Use two pointers to find the node previous to the node to be deleted. 
     * Make the prev node's next point to the deletion node's next
     * 
     * Time: O(n)
     * Space: O(1)
     * 
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = null, ptr2 = null;
        ptr1 = head;
        int del_pos = n;
        int count = 1;
        while (ptr1.next != null) {
            ptr1 = ptr1.next;
            count++;
            if (n-- == 1) {
                ptr2 = head;
                continue;
            }
            if (ptr2 != null) {
                ptr2 = ptr2.next;
            }
        }

        if (ptr2 == null && n == 1 && ptr1 != head) {
            return head.next;
        }

        if (n==1 && ptr2 == null && ptr1 == head) {
            return null;
        }

        if (ptr2 == null) {
            return ptr1;
        }

        if ((count - del_pos) == 0) {
            return ptr2.next;
        }

        ptr2.next = ptr2.next.next;
        return head;
    }
}
