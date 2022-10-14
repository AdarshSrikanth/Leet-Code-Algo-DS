package main.ds.arrays;

import java.util.Scanner;

import main.Util;

public class Palindrome_II {
    public static void main(String[] args) {
        Util.println("Enter the string");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Util.println("Palindrome with one excedption: " + validPalindrome(s));
        sc.close();
    }

    public static boolean validPalindrome(String s) {
        boolean first = true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if (first) {
                    first = false;
                    if (checkPalindrome(s, i+1, j)) {
                        i++;
                        continue;
                    }
                    if (checkPalindrome(s, i, j - 1)) {
                        j--;
                        continue;
                    }
                    else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean checkPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
