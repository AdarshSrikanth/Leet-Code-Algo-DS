package main.algo.dc;

import java.util.Scanner;

import main.Util;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Util.get_input_array(sc);
        quickSortAsc(input, 0, input.length - 1);  // both start and end are arry indices
        Util.printarr(input, "Sorted array:");
    }

    public static void quickSortAsc(int[] input, int start, int end) {
        if (start < end) {
            int p = partition(input, start, end);
            quickSortAsc(input, start, p - 1);
            quickSortAsc(input, p + 1, end);
        }
    }

    public static void swap (int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static int partition(int[] input, int start, int end) {
        // taking the right most index as pivot
        int pivot_index = end;
        int pivot = input[end];
        int j = start - 1;
        for (int i = start; i < pivot_index; i++) {
            if (input[i] < pivot) {
                j++;
                swap(input, i, j);
            }
        }
        swap(input, j + 1, pivot_index);
        pivot_index = j + 1; // set pivot at correct index;
        return pivot_index;
    }
}
