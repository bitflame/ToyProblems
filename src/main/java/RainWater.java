import edu.princeton.cs.algs4.Stack;

import java.util.Collections;

public class RainWater {
    private int calculateRainWater(int[] height) {
        int leftPointer = 0, rightPointer = height.length - 1, maxHeight = 0, sum = 0, delta = 0,
                leftMax = height[leftPointer], rightMax = height[rightPointer];
        while (leftPointer < rightPointer) {
            maxHeight = Math.min(leftMax, rightMax);
            if (height[leftPointer] > height[rightPointer]) {
                rightPointer--;
                delta = maxHeight - height[rightPointer];
                if (delta > 0) sum = sum + delta;
                rightMax = Math.max(rightMax, height[rightPointer]);
            } else {
                leftPointer++;
                delta = maxHeight - height[leftPointer];
                if (delta > 0) sum = sum + delta;
                leftMax = Math.max(leftMax, height[leftPointer]);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        RainWater rainWater = new RainWater();
        // int[] height = {4, 2, 0, 3, 2, 5};
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        rainWater.calculateRainWater(height);
        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.printf("%d\n", rainWater.calculateRainWater(height));
    }
}
