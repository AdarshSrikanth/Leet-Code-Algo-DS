package main.ds.stacks;

import java.util.Scanner;
import java.util.Stack;

import main.Util;

public class ValidParanthesis {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        String s = sc.nextLine();
        Util.println("Valid parenthesis? - " + isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                case '}':
                if (stack.empty() || stack.pop() != '{') {
                    return false;
                }
                case ']':
                if (stack.empty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
