import java.util.ArrayList;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> match = new ArrayList<>();
        int w = 0, x = w + 1, y = x + 1, z = nums.length - 1;
        while (w < nums.length - 3) {
            while (x < nums.length - 2) {
                while (y < z) {
                    if (nums[w] + nums[x] + nums[y] + nums[z] == target) {
                        match.add(nums[w]);
                        match.add(nums[x]);
                        match.add(nums[y]);
                        match.add(nums[z]);
                        result.add(match);
                        match = new ArrayList<>();
                        while (nums[y] == nums[y + 1]) y++;
                        y++;
                    } else if (nums[w] + nums[x] + nums[y] + nums[z] > target) z--;
                    else if (nums[w] + nums[x] + nums[y] + nums[z] < target) y++;
                }
                while (x < y && nums[x] == nums[x + 1]) x++;
                x++;
                y = x + 1;
                z = nums.length - 1;
            }
            while (w < x && nums[w] == nums[w + 1]) w++;
            x = w + 1;
            y = x + 1;
            z = nums.length - 1;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        FourSum four_Sum = new FourSum();
        System.out.println(four_Sum.fourSum(nums, 0));
    }
}
