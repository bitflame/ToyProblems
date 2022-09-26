import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumLCSolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }
        if (k == 2) {
            return twoSum(nums, target, start);
        }

        Long avg_value = target / k;
        if (nums[start] > avg_value || nums[nums.length - 1] < avg_value) {
            return res;
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i] != nums[i - 1]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start;
        int hi = nums.length - 1;
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }

    public static void main(String[] args) {
        FourSumLCSolution fourSumLCSolution = new FourSumLCSolution();
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        System.out.println("Test 1 - target is 0: " + fourSumLCSolution.fourSum(nums, 0));
        System.out.println("Test 2 - target is 1: " + fourSumLCSolution.fourSum(nums, 1));
        System.out.println("Test 3 - target is 2: " + fourSumLCSolution.fourSum(nums, 2));
        System.out.println("Test 4 - target is 3: " + fourSumLCSolution.fourSum(nums, 3));
        System.out.println("Test 5 - target is 4: " + fourSumLCSolution.fourSum(nums, 4));

    }
}
