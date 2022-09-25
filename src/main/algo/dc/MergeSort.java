package main.algo.dc;

import java.util.Scanner;

import main.Util;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Util.get_input_array(sc);
        mergeSortAsc(input, 0, input.length - 1);  // both start and end are arry indices
        Util.printarr(input, "Sorted array:");
    }

    public static void mergeSortAsc(int[] input, int start, int end) {
        if (start < end) {
            int mid = Math.floorDiv(start + end, 2);
            mergeSortAsc(input, start, mid);
            mergeSortAsc(input, mid + 1, end);
            merge(input, start, mid, end);
        }
    }

    public static void merge(int[] input, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i = 0; i < n1; i++) {
            L[i] = input[start + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = input[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                input[k] = L[i];
                i++;
            } else {
                input[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            input[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            input[k] = R[j];
            j++;
            k++;
        }
    }
}
