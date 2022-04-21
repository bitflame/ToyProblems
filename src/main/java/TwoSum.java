import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Node : This project uses gradle build tool */
public class TwoSum {
    int[] result = new int[2];

    // Nested loops approach
    private int[] twoSumII(int[] nums, int target) {
        SET<Integer> set = new SET<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // HashMap approach
    private int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> db = new HashMap<>();
        int counter = 0;
        while (counter < nums.length) {
            if (db.containsKey(target - nums[counter])) {
                int[] toReturn = {db.get(target - nums[counter]), counter};
                return toReturn;
            }
            db.put(nums[counter], counter);
            counter++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        // StdOut.print("Hello");
        TwoSum twoSum = new TwoSum();
        int target = 6;
        System.out.printf("HashMap approach - Expecting [1, 2], actual:\n[");
        for (int i : twoSum.twoSumHashMap(nums, target)) {
            System.out.printf(" %d", i);
        }
        System.out.printf(" ]\n");
        nums = new int[]{3, 3};
        System.out.printf("HashMap approach - Expecting [0, 1], actual: \n[");
        for (int i : twoSum.twoSumHashMap(nums, target)) {
            System.out.printf(" %d", i);
        }
        System.out.printf("] \n");
        nums = new int[]{2, 5, 5, 11};
        target = 10;
        System.out.printf("Nested loops approach - Expecting [1, 2]. actual: \n[");
        for (int i : twoSum.twoSumII(nums, target)) System.out.printf(" %d", i);
        System.out.printf(" ]\n");
    }
}
