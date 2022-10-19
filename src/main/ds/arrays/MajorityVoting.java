package main.ds.arrays;

import java.util.ArrayList;
import java.util.List;

import main.Util;

// Modified Boyer-Moore Voting algo.
// Ref: https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html

public class MajorityVoting {
    public static void main(String[] args) {
        int nums[] = {2,1,1,3,1,4,5,6,};
        Util.printarr(majorityElement(nums).toArray(), "Majority Algo: \n");
    }

    /**
     * Return elements that appear more than n/3 times.
     * In majoirity voting problem if a person has more than n/2 votes, he is declared a majority.
     * this is checked in O(2 x n) time with no extra space using the BM algo 
     * 
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int k = Math.floorDiv(n, 3);
        
        int count1 = 0, candidate1 = 0, count2 = 0, candidate2 = 0;
        for (int i = 0; i < n; i++) {
            if (candidate1 == nums[i]) {
                count1++;
                continue;
            }
            else if (candidate2 == nums[i]) {
                count2++;
                continue;
            }
            else if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
                continue;
            }
            else if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
                continue;
            }
            
            else {
                count1--; count2--;
            }
        }
        
        count1 = 0; count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            }
        }
        
        List<Integer> resp = new ArrayList<Integer>();
        if (count1 > k) {
            resp.add(candidate1);
        }
        if (count2 > k) {
            resp.add(candidate2);
        }
        
        return resp;
    }    
}
