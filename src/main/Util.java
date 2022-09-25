package main;

import java.util.Scanner;

public class Util {
    public static int[] get_input_array(Scanner sc) {
        System.out.println("Enter the array size followed by the numbers");
        Integer size = Integer.parseInt(sc.next());
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = (int) Integer.parseInt(sc.next());
        }
        return input;
    }

    public static void println(String str) {
        System.out.println(str);
    }
}
