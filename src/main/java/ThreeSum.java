import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> match = new ArrayList<>();
        Arrays.sort(nums);
        int j = nums.length - 1;
        int k = 0;
        int i = k + 1;
        while (k < nums.length - 2) {
            while (i < j) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    match.add(nums[i]);
                    match.add(nums[j]);
                    match.add(nums[k]);
                    result.add(match);
                    match = new ArrayList<>();
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    i++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    j--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    i++;
                }

            }
            while (k < nums.length - 2 && nums[k] == nums[k + 1]) {
                k++;
            }
            k++;
            i = k + 1;
            j = nums.length - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        ThreeSum sum = new ThreeSum();
        System.out.println("Test 1 Expecting:  [[-1, 2, -1], [0, 1, -1]], Getting: : " + sum.threeSum(nums));
        nums = new int[]{0, 1, 1};
        System.out.println("Test 2: Expecting [], Getting: " + sum.threeSum(nums));
        nums = new int[]{0, 0, 0, 0};
        System.out.println("Test 3: Expecting: [[0, 0, 0]] " + sum.threeSum(nums));
        nums = new int[]{1, -1, -1, 0};
        System.out.println("Test 4: Expecting: [[0, 1, -1]], Getting:  " + sum.threeSum(nums));
        nums = new int[]{-2, 0, 1, 1, 2};
        System.out.println("Test 5: Expecting: [[0, 2, -2], [1, 1, -2]], Getting: " + sum.threeSum(nums));
        nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("Test 6: Expecting: [[-1,-1,2],[-1,0,1]], Getting:  " + sum.threeSum(nums));
        nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        System.out.println("Test 7: Expecting: [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]], Getting: " + sum.threeSum(nums));
        nums = new int[]{0, 0, 0};
        System.out.println("Test 8: Expecting: [[0,0,0]], Getting: " + sum.threeSum(nums));
    }
}
