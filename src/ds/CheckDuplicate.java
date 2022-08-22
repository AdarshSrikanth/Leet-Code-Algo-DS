import java.util.*;

class CheckDuplicate {
    public static void main (String[] args) {
        try {
            System.out.println("Enter the array size followed by the numbers");
            Scanner sc = new Scanner(System.in);
            Integer size = Integer.parseInt(sc.next());
            int[] input = new int[size];
            for (int i = 0; i < size; i++) {
                input[i] = (int) Integer.parseInt(sc.next());
            }
            boolean result = containsDuplicate(input);
            System.out.println("Contains Duplicate: " + result);
            sc.close();
        }
        catch (Exception ex) {

        }
        
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(Integer.valueOf(nums[i]))) {
                return true;
            }
        }
        return false;
    }
}