import java.util.*;

public class FourSumLCHashSet {
    /*This is also a LeetCode solution, but it uses HashSet to implement twoSum portion of the solution instead of
    pointers */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length)
            return res;
        if (k == 2)
            return twoSumHash(nums, target, start);
        long avg_val = target / k;
        if (nums[start] > avg_val || avg_val > nums[nums.length - 1])
            return res;
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

    public List<List<Integer>> twoSumHash(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i] != nums[i - 1]) {
                if (set.contains(target - nums[i])) {
                    res.add(Arrays.asList((int) target - nums[i], nums[i]));
                }
                set.add((long) nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        FourSumLCHashSet fourSumLCSolution = new FourSumLCHashSet();
        System.out.println(fourSumLCSolution.fourSum(nums, 0));
    }
}
