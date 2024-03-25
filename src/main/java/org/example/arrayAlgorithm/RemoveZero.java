package org.example.arrayAlgorithm;

/**
 * 移除数组中的0元素
 */
public class RemoveZero {
    public static int[] RemoveZero(int[] nums){
        int quickPoint = 0;
        int slowPoint = 0;
        for ( ; quickPoint < nums.length; quickPoint++) {
            if (nums[quickPoint] != 0) {
                nums[slowPoint] = nums[quickPoint];
                slowPoint++;
            }
        }
        for ( ; slowPoint < nums.length; slowPoint++) {
            nums[slowPoint] = 0;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums1 = RemoveZero(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums1[i]);
        }

    }
}
