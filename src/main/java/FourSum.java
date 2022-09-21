import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> match = new ArrayList<>();
        int w = 0, x = w + 1, y = x + 1, z = nums.length - 1;
        Arrays.sort(nums);
        int sum = 0;
        while (w < nums.length - 3) {
            while (x < nums.length - 2) {
                while (y < z) {
                    if (nums[w] + nums[x] + nums[y] + nums[z] == target && !overflow(nums[w], nums[x], nums[y], nums[z])) {
                        match.add(nums[w]);
                        match.add(nums[x]);
                        match.add(nums[y]);
                        match.add(nums[z]);
                        result.add(match);
                        match = new ArrayList<>();
                        while (y < nums.length - 2 && y < z && nums[y] == nums[y + 1]) y++;
                        y++;
                    } else if (nums[w] + nums[x] + nums[y] + nums[z] > target) z--;
                    else y++;
                }
                while (x < y && nums[x] == nums[x + 1]) x++;
                x++;
                y = x + 1;
                z = nums.length - 1;
            }
            while (w < nums.length - 3 && w < x && nums[w] == nums[w + 1]) w++;
            w++;
            x = w + 1;
            y = x + 1;
            z = nums.length - 1;
        }
        return result;
    }

    private boolean overflow(int a, int b, int c, int d) {
        if (a > 0 && b > 0 && c > 0 && d > 0 && a + b + c + d < 0) return true;
        else return false;
    }

    private List<List<Integer>> fourSumLeetCodeSolution(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length) {
            return res;
        }
        long average_value = target / k;
        if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
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
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }
        return res;
    }

    public List<List<Integer>> twoSumUsingHashSet(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (s.contains(target - nums[i])) {
                    res.add(Arrays.asList((int) target - nums[i], nums[i]));
                }
            }
            s.add((long) nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        FourSum four_Sum = new FourSum();
        System.out.println("Test 1 - Expecting: [[-2, -1, 1, 2]], Getting: " + four_Sum.fourSum(nums, 0));
        nums = new int[]{2, 2, 2, 2, 2};
        System.out.println("Test 2 - Expecting: [[2,2,2,2]], Getting: " + four_Sum.fourSum(nums, 8));
        nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println("Test 3 - Expecting: [[]], Getting: " + four_Sum.fourSum(nums, -294967296));
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        System.out.println(total);
    }
}
