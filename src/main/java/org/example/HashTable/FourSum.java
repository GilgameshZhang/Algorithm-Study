package org.example.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int m = i + 1;
            for (; m < nums.length; m++) {
                if (m > i + 1 && nums[m] == nums[m - 1]) {
                    continue;
                }
                int left = m + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //int加和会越界，用long保险，否则会像案例一样报错
                    long sum = (long)nums[i] + nums[m] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> res = Arrays.asList(nums[i], nums[m], nums[left], nums[right]);
                        result.add(res);
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        FourSum fourSum = new FourSum();
        fourSum.fourSum(nums, target);
    }
}
