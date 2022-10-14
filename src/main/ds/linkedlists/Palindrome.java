package main.ds.linkedlists;

import java.util.Scanner;

import main.Util;
import main.Util.ListNode;

public class Palindrome {

    public static ListNode t1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = Util.buildLinkedList(sc);
        Util.println("Is palindrome: " + isPalindrome(head));
        sc.close();
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode l = head, r = head;
        while (r != null && r.next != null) {
            r = r.next.next;
            l = l.next;
        }
        ListNode mid = l;
        t1 = temp;
        return checkPalindrome(mid);
    }
    
    public static boolean checkPalindrome(ListNode head2) {
        ListNode t2 = head2;
        if (t2 == null) {
            return true;
        }
        if (checkPalindrome(t2.next) && t1.val == t2.val) {
            t1 = t1.next;
            return true;
        }
        return false;
    }
}
