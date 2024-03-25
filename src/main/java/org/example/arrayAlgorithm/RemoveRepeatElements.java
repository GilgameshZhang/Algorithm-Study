package org.example.arrayAlgorithm;

/**
 * 移除重复的数组
 */
public class RemoveRepeatElements {
    public static int RemoveRepeatElements(int[] nums){
        int quickPoint = 0;
        int slowPoint = 0;
        for ( ; quickPoint < nums.length; quickPoint++) {
            if (nums[quickPoint] != nums[slowPoint]) {
                slowPoint++;
                nums[slowPoint] = nums[quickPoint];
            }
        }
        return ++ slowPoint;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,2};
        System.out.println(RemoveRepeatElements(nums));

    }
}
