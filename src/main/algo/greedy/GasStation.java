package main.algo.greedy;

import java.util.Scanner;

import main.Util;

public class GasStation {
    public static void main(String[] args) {
        Scanner sc = Util.getScanner();
        int[] gas = Util.get_input_array(sc);
        int[] cost = Util.get_input_array(sc);
        Util.println("Starting index of the trip - " + canCompleteCircuit(gas, cost));
        sc.close();
    }
    
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int total_sum = 0;
        int start_index = 0;
        for (int i = 1; i <= n; i++) {
            sum += gas[i - 1] - cost[i - 1];
            total_sum += gas[i - 1] - cost[i - 1];
            if (sum < 0) {
                start_index = i;
                sum = 0;
            }
        }
        if(total_sum < 0) {
            return -1;
        }
        return start_index;
    }
}