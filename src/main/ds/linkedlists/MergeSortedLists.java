package main.ds.linkedlists;

import java.util.Arrays;
import java.util.Scanner;

import main.Util;
import main.Util.ListNode;

public class MergeSortedLists {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        int[] arr1 = Util.get_input_array(sc);
        int[] arr2 = Util.get_input_array(sc);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        ListNode head = mergeTwoLists(Util.buildListNode(arr1), Util.buildListNode(arr2));
        Util.printLinkedList(head);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, temp = null;
        while(list1!= null && list2!=null) {
            ListNode node;
            if (list1.val < list2.val) {
                node = list1;
                list1 = list1.next;
            }
            else {
                node = list2;
                list2 = list2.next;
            }
            if (head == null) {
                head = node;
                temp = head;
            }
            else {
                temp.next = node;
                temp = temp.next;
            }
        }
        
        while(list1!= null) {
            if (head == null) {
                head = list1;
                temp = head;
            }
            else {
                temp.next = list1;
                temp = temp.next;
            }
            list1 = list1.next;
            
        }
        
        while(list2!= null) {
            if (head == null) {
                head = list2;
                temp = head;
            }
            else {
                temp.next = list2;
                temp = temp.next;
            }
            list2 = list2.next;
        }
        
        return head;
    }
}
