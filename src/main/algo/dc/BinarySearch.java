package main.algo.dc;

import java.util.Scanner;

import main.Util;

public class BinarySearch {
    public static void main (String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int[] input = Util.get_input_array(sc);
            Util.println("Enter the number to find");
            int num = Integer.parseInt(sc.next());
            Util.println("Number found at index: " + binarySearch(input, 0, input.length, num));
            sc.close();
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    public static int binarySearch(int arr[], int start, int end, int num) {
        if (start < end) {
            int mid = Math.floorDiv(start + end, 2);
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                return binarySearch(arr, mid + 1, end, num);
            } else {
                return binarySearch(arr, start, mid, num);
            }
        }
        return -1;
    }
}
