package org.example.HashTable;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {
    /**
     * 最简单的想法是两次遍历数组
     * 但我们可以进一步想想，当两个数的和是目标值的时候，也就意味之当我们已知一个数，
     * 可以算出使得此成立的另外一个数，只需要判断出这个数是否在数组中即可
     * 判断一个数是否出现过，我们会想到哈希法，此题中由于要返回值对应的下标，也就是K，V
     * K-值，V-下标，所以我们用map保存
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];//距离目标值差的数字
            if (hashMap.containsKey(m)) {//数组中是否已经遍历过相差的数
                res[0] = i;
                res[1] = hashMap.get(m);
                return res;
            } else {
                hashMap.put(i, nums[i]);//没有的话把当前值放进hashMap中
            }
        }
        return null;
    }
}
