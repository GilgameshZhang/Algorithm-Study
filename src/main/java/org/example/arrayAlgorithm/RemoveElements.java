package org.example.arrayAlgorithm;

/**
 * 数组中移除某一个元素，返回移除后的数组（数组覆盖）
 */
public class RemoveElements {

    public static int RemoveElements(int[] nums, int val) {
        int quickPoint = 0; //快指针搜索新数组元素
        int slowPoint = 0; //慢指针搜索被覆盖元素
        for ( ; quickPoint<nums.length; quickPoint ++) {
            if (nums[quickPoint] != val) {
                nums[slowPoint] = nums[quickPoint];
                slowPoint++;
            }
        }
        return slowPoint;
    }

    /**
     * 标答
     */
    class Solution {
        public int removeElement(int[] nums, int val) {
            // 快慢指针
            int slowIndex = 0;
            for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
                if (nums[fastIndex] != val) {
                    nums[slowIndex] = nums[fastIndex];
                    slowIndex++;
                }
            }
            return slowIndex;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,5,8};
        int val = 2;
        System.out.println(RemoveElements(nums, val));

    }
}
