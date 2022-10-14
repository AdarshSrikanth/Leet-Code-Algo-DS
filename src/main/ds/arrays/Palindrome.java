package main.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import main.Util;

public class Palindrome {
    public static void main(String[] args) {
        Util.println("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        Util.println("Is Palindrome: " + isPalindrome(num));

    }

    public static boolean isPalindrome(int x) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while(x > 0) {
            digits.add(x % 10);
            x /= 10;
        }
        Collections.reverse(digits);
        int[] d = digits.stream().mapToInt(i -> i).toArray();
        
        for (int i = 0, j = d.length - 1; i < j; i++, j--) {
            if (d[i] != d[j]) {
                return false;
            }
        }
        return true;
    }
}
